import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private Integer hp;
    private Types type;
    private List<Moves> moves;
    private Boolean isBattling;
    private Boolean hasFainted;
    private Integer startingHP;

    public Pokemon(String name, Integer hp, Types type){
        this.name = name;
        this.hp = hp;
        this.type = type;
        moves = new ArrayList<>();
        isBattling = false;
        hasFainted = false;
        startingHP = hp;
    }

    public void addMove(Moves m) {
        this.moves.add(m);
    }

    public Integer getStartingHP(){
        return startingHP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Boolean getBattling() {
        return isBattling;
    }

    public void setBattling(Boolean battling) {
        isBattling = battling;
    }

    public Boolean getHasFainted() {
        return hasFainted;
    }

    public void setHasFainted(Boolean hasFainted) {
        this.hasFainted = hasFainted;
    }



    public Integer decrementHP(Integer amountToDecrement){
        this.setHp(this.getHp() - amountToDecrement);
        if(hasFainted()){
            this.setHasFainted(true);
            return -1;
        }
        return this.getHp();
    }

    public Boolean hasFainted(){
        return this.getHp() <= 0;
    }



    public Moves pickMove(){
        //random for now
        Integer numOfMoves = 0;
        for(Moves m : moves){
            if(!m.outOfPP()){
                numOfMoves++;
            }
        }
        Integer randomNum = BattleUtils.getRandomNumber(0, numOfMoves-1);
       Moves pickedMove = this.moves.get(randomNum);
        System.out.println(this.getName() + " used " + pickedMove.getName());
        pickedMove.decrementPP();
        return pickedMove;
    }

    public Boolean isSuperEffective(Moves m){ //move on pokemon
        if(this.getType().weakAgainst.equals(m.getType().toString())){
            return true;
        }
        return false;
    }

    public Integer damageToDeal(){
        Moves move = pickMove();
        Integer damage;
        if (isSuperEffective(move)){
            damage = move.getPower()*2;
        }
        else {
            damage = move.getPower();
        }
        return damage;
    }

    public Integer attack(){
        Integer damage = damageToDeal();
        return damage;
    }

    public void takeDamage(){
        System.out.println(this.getName() + " took " + attack() + " damage. Current hp: " + this.getHp());
        this.setHp(decrementHP(attack()));

    }
}
