import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private Trainers trainer;
    private String name;
    private Integer hp;
    private Types type;
    private List<Moves> moves;
    private Boolean isBattling;
    private Boolean hasFainted;
    private Integer startingHP;
    private Moves currentMove;
    private String color;

    public Pokemon(String name, Integer hp, Types type){
        this.name = name;
        this.hp = hp;
        this.type = type;
        moves = new ArrayList<>();
        isBattling = false;
        hasFainted = false;
        startingHP = hp;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void addMove(Moves m) {
        this.moves.add(m);
    }

    public List<Moves> getMoves(){
        return moves;
    }

    public Trainers getTrainer(){
        return trainer;
    }

    public void setTrainer(Trainers t){
        this.trainer = t;
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

    public void setCurrentMove(Moves move){
        this.currentMove = move;
    }

    public Moves getCurrentMove(){
        return currentMove;
    }


    public Boolean hasFainted(){

        return this.getHp() <= 0;
    }

    public void fainted(){
        this.setBattling(false);
        this.setHasFainted(true);
    }

    public Integer getMovesWithPP(){
        Integer numOfMoves = 0;
        for(Moves m : moves){
            if(!m.outOfPP()){
                numOfMoves++;
            }
        }
        return numOfMoves;
    }

    public Moves pickMove(){
        //random for now
        Integer numOfMoves = getMovesWithPP();
        Integer randomNum = BattleUtils.getRandomNumber(0, numOfMoves-1);
        Moves pickedMove = this.moves.get(randomNum);
        System.out.println(this.getName() + " used " + pickedMove.getName());
        setCurrentMove(pickedMove);
        pickedMove.decrementPP();
        return pickedMove;
    }


}