public class Battle {
    private Trainers player;
    private Trainers opponent;
    private Summary summary;
    private String loser;


    public Battle(Trainers player, Trainers opponent) {
        this.player = player;
        this.opponent = opponent;
        summary = new Summary();


        summary.setBattleStart(this.player.getName() + " vs " + this.opponent.getName());
        System.out.println(summary.getBattleStart());
        this.player.setActivePokemon(this.player.getTeam().get(0));

        Summary.sentOut(this.player.getName(),this.player.getActivePokemon().getName());
        this.opponent.setActivePokemon(this.opponent.getTeam().get(0));

        Summary.sentOut(this.opponent.getName(),this.opponent.getActivePokemon().getName());
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
            return true;
        } else if (opponent.outOfPokemon() || opponent.getActivePokemon()==null) {
            setLoser(opponent.getName());
            opponent.setLoses(opponent.getLoses() + 1);
            return true;
        }
        return false;
    }

//    public PokemonPojo whoGoesFirst() {
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
            System.out.println("************");
            Summary.currentHP(p);
            p.setHasFainted(true);
            Summary.fainted(p);
            System.out.println("************");
            p.getTrainer().getBattlingPokemon(p);
        } else {
            Summary.currentHP(p);
            p.setHp(p.getHp() - amountToDecrement);
            Summary.tookDamage(amountToDecrement,p);
        }
        return p.getHp();
    }

    public static Boolean isSuperEffective(Types type1, Types type2) { //move on pokemon
        if (type2.weakAgainst.equals(type1.toString())) {
            return true;
        }
        return false;
    }


    public static Integer attack(Pokemon attacker, Pokemon defender) {
        Integer damage;
        Types moveType = attacker.getCurrentMove().getType();
        Types defType = defender.getPrimaryType();
        if (isSuperEffective(moveType, defType)) {
            System.out.println("super effective!");
            damage = attacker.getCurrentMove().getPower() * 2;
        } else {
            damage = attacker.getCurrentMove().getPower();
        }
        return damage;
    }

    public static void takeDamage(Pokemon attacker, Pokemon defender) {
        Integer damage = attack(attacker, defender);

        decrementHP(damage, defender);


    }




    public void roundA() {

        Pokemon a = player.getActivePokemon();
        Pokemon b = opponent.getActivePokemon();
        //PokemonPojo attackFirst = whoGoesFirst();
            a.pickMove();
            attack(a, b);
            takeDamage(a, b);
            if(opponent.getActivePokemon()==null){
                endBattle();
            }
        }


    public void roundB() {
        Pokemon a = player.getActivePokemon();
        Pokemon b = opponent.getActivePokemon();
            b.pickMove();
            attack(b, a);
            takeDamage(b, a);
            if(opponent.getActivePokemon()==null){
                endBattle();
            }
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






}