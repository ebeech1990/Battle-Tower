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

    public Pokemon(String name, Integer hp, Types type, List<Moves> moves){
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

    public Pokemon whoGoesFirst(Pokemon opponent){
        Integer num = BattleUtils.getRandomNumber(1,3);
        //will compare speed stat later
        if(num == 1){
            return this;
        }
        return opponent;
    }

    public Boolean isSuperEffective(Moves move){ //move on pokemon
        if(this.getType().strongAgainst.equals(move.getType().toString())){
            move.setPower(move.getPower()*2);
            return true;
        }
        return false;
    }

    public String pokemonTypeAdvantage(Pokemon opponent){
        if(this.getType().weakAgainst.equals(opponent.getType().toString())){
            return opponent.getName();
        }
        else if(this.getType().strongAgainst.equals(opponent.getType().toString())){
            return this.getName();
        }
        return "tie";
    }

    public Integer decrementPP(Moves move){
        move.setPp(move.getPp()-1);
        if(outOfPP(move)){
            move.setUseable(false);
            return -1;
        }
        return move.getPp();
    }

    public Integer decrementHP(Pokemon defender, Integer amountToDecrement){
        defender.setHp(defender.getHp() - amountToDecrement);
        if(hasFainted(defender)){
            defender.setHasFainted(true);
            return -1;
        }
        return defender.getHp();
    }

    public Boolean hasFainted(Pokemon pokemon){
        return pokemon.getHp() <= 0;
    }

    public Boolean outOfPP(Moves move){
        if(move.getPp()<=0){
            return true;
        }
        return false;
    }
}
