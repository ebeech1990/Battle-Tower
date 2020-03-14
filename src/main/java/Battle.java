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

    public void round(){
       Pokemon a = player.getBattlingPokemon();
       Pokemon b =  opponent.getBattlingPokemon();
        //Pokemon attackFirst = whoGoesFirst();
        a.pickMove();
        a.attack();
        b.takeDamage();
        b.pickMove();
        b.attack();
        a.takeDamage();
    }

    public void battling(){
        while (!endBattle()){
            round();
        }
    }



}
