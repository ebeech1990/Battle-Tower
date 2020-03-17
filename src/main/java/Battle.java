public class Battle {
    private Trainers player;
    private Trainers opponent;
    private Summary summary;
    private String loser;
    private String playerName;
    private String opponentName;
    private String playerActivePokemon;
    private String opponentActivePokemon;
    private String reset = SoutColor.ANSI_RESET;


    public Battle(Trainers player, Trainers opponent) {
        this.player = player;
        this.opponent = opponent;
        summary = new Summary();
        this.player.setTrainerColor(SoutColor.ANSI_PURPLE);
        this.opponent.setTrainerColor(SoutColor.ANSI_BLUE);
        this.playerName =this.player.getTrainerColor() + this.player.getName() + reset;

        this.opponentName =this.opponent.getTrainerColor() + this.opponent.getName() + reset;

        summary.setBattleStart(playerName + " vs " + opponentName);
        System.out.println(summary.getBattleStart());
        this.player.setActivePokemon(this.player.getTeam().get(0));
        this.player.setActivePokemonColor(SoutColor.ANSI_RED);
        this.playerActivePokemon = this.player.getActivePokemonColor() + this.player.getActivePokemon().getName() + reset;
        Summary.sentOut(playerName,playerActivePokemon);
        this.opponent.setActivePokemon(this.opponent.getTeam().get(0));
        this.opponent.setActivePokemonColor(SoutColor.ANSI_GREEN);
        this.opponentActivePokemon = this.opponent.getActivePokemonColor() + this.opponent.getActivePokemon().getName() + reset;
        Summary.sentOut(opponentName,opponentActivePokemon);
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
            System.out.println("************");
            Summary.currentHP(p);
            p.fainted();
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

        decrementHP(damage, defender);


    }




    public void roundA() {

        Pokemon a = player.getActivePokemon();
        Pokemon b = opponent.getActivePokemon();
        //Pokemon attackFirst = whoGoesFirst();
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