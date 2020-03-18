package battletower;

public class Battle {
    private Trainers player;
    private Trainers opponent;
    private Boolean inProgress;
    private Summary summary;


    public Battle(Trainers player, Trainers opponent){
        this.player = player;
        this.opponent = opponent;
        inProgress = true;
        summary = new Summary();
        summary.setBattleStart(player.getName() + " vs " + opponent.getName());

        System.out.println(summary.getBattleStart());
    }

    public Boolean endBattle(){
        if(player.outOfPokemon()){
            player.setLoses(player.getLoses()+1);
            inProgress = false;
            summary.setBattleEnd(player.getName() + " has lost");
            System.out.println(summary.getBattleEnd());
            return true;
        }
        else if(opponent.outOfPokemon()){
            opponent.setLoses(opponent.getLoses()+1);
            inProgress = false;
            summary.setBattleEnd(opponent.getName() + " has lost");
            System.out.println(summary.getBattleEnd());
            return true;
        }
        return false;
    }

    public Pokemon whoGoesFirst(){

        Integer num = BattleUtils.getRandomNumber(1,3);
        //will compare speed stat later
        if(num == 1){
            return player.getBattlingPokemon();
        }
        return opponent.getBattlingPokemon();
    }

    public static Integer decrementHP(Integer amountToDecrement, Pokemon p){
        if(p.getHp()-amountToDecrement <= 0){
            p.fainted();
            System.out.println(p.getName() + " has fainted.");
            p.getTrainer().getBattlingPokemon();
        }
        else{
            p.setHp(p.getHp() - amountToDecrement);
            System.out.println(p.getName() + " took " + amountToDecrement + " damage. Current hp: " + p.getHp());
        }
        return p.getHp();
    }

    public static Boolean isSuperEffective(Types type1, Types type2){ //move on pokemon
        if(type1.weakAgainst.equals(type2.toString())){
            System.out.println("super effective!");
            return true;
        }
        return false;
    }



    public static Integer attack(Pokemon attacker, Pokemon defender){
        Integer damage;
        Types moveType = attacker.getCurrentMove().getType();
        Types defType = defender.getType();
        if (isSuperEffective(moveType,defType)){
            damage = attacker.getCurrentMove().getPower()*2;
        }
        else {
            damage = attacker.getCurrentMove().getPower();
        }
        return damage;
    }

    public static void takeDamage(Pokemon attacker, Pokemon defender){
        Integer damage = attack(attacker,defender);
        System.out.println(defender.getName() + " current hp: " + defender.getHp());
        decrementHP(damage, defender);


    }

    public void round(){

       Pokemon a = player.getActivePokemon();
       Pokemon b = opponent.getActivePokemon();
        //Pokemon attackFirst = whoGoesFirst();
        a.pickMove();
        attack(a,b);
        takeDamage(a,b);
        if(a.getHasFainted()){
            a.getTrainer().getBattlingPokemon();
        }
        b.pickMove();
        attack(b,a);
        takeDamage(b,a);
        if(b.getHasFainted()){
            b.getTrainer().getBattlingPokemon();
        }
    }

    public void battling(){
        while (!endBattle()){
            round();
            System.out.println("end round");

            endBattle();
        }
    }



}
