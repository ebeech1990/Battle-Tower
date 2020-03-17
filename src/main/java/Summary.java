public class Summary {
    private String battleStart;
    private String battleEnd;


    public String getBattleStart() {
        return battleStart;
    }

    public void setBattleStart(String battleStart) {
        this.battleStart = battleStart;
    }

    public String getBattleEnd() {
        return battleEnd;
    }

    public void setBattleEnd(String battleEnd) {
        this.battleEnd = battleEnd;
    }

    public static void fainted(Pokemon p){
        System.out.println(p.getName() + " has fainted  XP");
    }

    public static void tookDamage(Integer amountToDecrement, Pokemon p){
        System.out.println(p.getName() + " took " + amountToDecrement + " damage. Current hp: " + p.getHp());
    }

    public static void sentOut(String trainerName, String pokemonName){
        System.out.println(trainerName + " sent out " + pokemonName);
    }

    public static void currentHP(Pokemon defender){
        System.out.println(defender.getName() + " current hp: " + defender.getHp());
    }
}
