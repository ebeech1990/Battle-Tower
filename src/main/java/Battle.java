import com.sun.org.apache.bcel.internal.generic.GOTO;
import sun.awt.EventQueueItem;

import java.util.Optional;

public class Battle {
    private Trainers player;
    private Trainers opponent;
    private Boolean inProgress;
    private Summary summary;
    private String loser;



    public Battle(Trainers player, Trainers opponent) {
        this.player = player;
        this.opponent = opponent;
        inProgress = true;
        summary = new Summary();
        System.out.println(summary.getBattleStart());
        summary.setBattleStart(player.getName() + " vs " + opponent.getName());
        this.player.setActivePokemon(this.player.getTeam().get(0));
        System.out.println(this.player.getName() + " sent out " + this.player.getActivePokemon().getName());

        this.opponent.setActivePokemon(this.opponent.getTeam().get(0));
        System.out.println(this.opponent.getName() + " sent out " + this.opponent.getActivePokemon().getName());


    }



    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public  Boolean endBattle() {
        if (player.outOfPokemon() || player.getActivePokemon()==null) {
            setLoser(player.getName());
            player.setLoses(player.getLoses() + 1);
            inProgress = false;

            return true;
        } else if (opponent.outOfPokemon() || opponent.getActivePokemon()==null) {
            setLoser(opponent.getName());
            opponent.setLoses(opponent.getLoses() + 1);
            inProgress = false;

            return true;
        }
        return false;
    }

//    public Pokemon whoGoesFirst() {
//
//        Integer num = BattleUtils.getRandomNumber(1, 3);
//        //will compare speed stat later
//        if (num == 1) {
//            return player.getBattlingPokemon();
//        }
//        return opponent.getBattlingPokemon();
//    }

    public static Integer decrementHP(Integer amountToDecrement, Pokemon p) {
        if (p.getHp() - amountToDecrement <= 0) {
            p.fainted();
            System.out.println(p.getName() + " has fainted.");
            p.getTrainer().getBattlingPokemon(p);
        } else {
            p.setHp(p.getHp() - amountToDecrement);
            System.out.println(p.getName() + " took " + amountToDecrement + " damage. Current hp: " + p.getHp());
        }
        return p.getHp();
    }

    public static Boolean isSuperEffective(Types type1, Types type2) { //move on pokemon
        if (type1.weakAgainst.equals(type2.toString())) {
            System.out.println("super effective!");
            return true;
        }
        return false;
    }


    public static Integer attack(Pokemon attacker, Pokemon defender) {
        Integer damage;
        Types moveType = attacker.getCurrentMove().getType();
        Types defType = defender.getType();
        if (isSuperEffective(moveType, defType)) {
            damage = attacker.getCurrentMove().getPower() * 2;
        } else {
            damage = attacker.getCurrentMove().getPower();
        }
        return damage;
    }

    public static void takeDamage(Pokemon attacker, Pokemon defender) {
        Integer damage = attack(attacker, defender);
        System.out.println(defender.getName() + " current hp: " + defender.getHp());
        decrementHP(damage, defender);


    }




    public void roundA() {

        Pokemon a = player.getActivePokemon();
        Pokemon b = opponent.getActivePokemon();
        //Pokemon attackFirst = whoGoesFirst();
        if(opponent.getActivePokemon()==null){
            endBattle();
        }
        if (a.getHp() > 0 ) {
            a.pickMove();
            attack(a, b);
            takeDamage(a, b);
            if(opponent.getActivePokemon()==null){
                endBattle();
            }

        } else {
            a.getHasFainted();

            if( a.getTrainer().getBattlingPokemon(a)==null ||b.getTrainer().getBattlingPokemon(b)==null){
                endBattle();
            }
            a.getTrainer().getBattlingPokemon(a);



        }
    }

    public void roundB() {
        Pokemon a = player.getActivePokemon();
        Pokemon b = opponent.getActivePokemon();
        if(opponent.getActivePokemon()==null){
            endBattle();
        }
        if (b.getHp() > 0) {
            b.pickMove();
            attack(b, a);
            takeDamage(b, a);

        } else {

            endBattle();
            if(b.getTrainer().getBattlingPokemon(b)==null || a.getTrainer().getBattlingPokemon(a)==null){
                endBattle();
            }
            b.getTrainer().getBattlingPokemon(b);



        }
    }

 public Boolean endConditionsMet(Pokemon p){
        if(p.getHasFainted()){
            return true;
        }
        else if(p.getTrainer().outOfPokemon()){
            return true;
        }
        else if(p.getTrainer().getLastPokemon() == p){
            return true;
        }
        return false;
 }

    public void battling(){

        while (!endBattle()){
         roundA();
            if(opponent.getActivePokemon()==null){
                break;
            }
         roundB();
         endBattle();
        }
        summary.setBattleEnd(getLoser() + " has lost");
        System.out.println(summary.getBattleEnd());
    }

//    public void battleRound(){
//        Pokemon a = player.getActivePokemon();
//        Pokemon b = opponent.getActivePokemon();
//        if (a.getHp() > 0){
//            a.pickMove();
//            attack(a,b);
//            takeDamage(a,b);
//        }
//        else {
//            a.getTrainer().getBattlingPokemon();
//        }
//        if (b.getHp() > 0) {
//            b.pickMove();
//            attack(b, a);
//            takeDamage(b, a);
//        }
//        else{
//            b.getTrainer().getBattlingPokemon();
//        }




}