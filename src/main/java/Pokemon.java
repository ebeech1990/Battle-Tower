import org.json.JSONException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Pokemon {
    private Trainers trainer;
    private String name;
    private List<Types> types;
    private Integer weight;
    private Types primaryType;
    private Types secondaryType;
    private Integer speed;
    private Integer hp;
    private List<Move> moves = new ArrayList<>();
    private Boolean isBattling = false;
    private Boolean hasFainted = false;
    private Move currentMove;
    private  List<String> learnableMoves;
    private final Map<String, Integer> ORIGINAL_STATS;

    public Pokemon(String name) throws IOException, JSONException {
        PokemonBuilder builder = new PokemonBuilder(name);
        builder.build(this);
        ORIGINAL_STATS = new HashMap<>();
        ORIGINAL_STATS.put("speed", speed);
        ORIGINAL_STATS.put("hp", hp);
    }

    public Map<String, Integer> getOriginalStats(){
        return ORIGINAL_STATS;
    }

    public void setLearnableMoves(List<String> learnable){
        learnableMoves = new ArrayList<>();
        learnableMoves.addAll(learnable);
    }

    public List<String> getLearnableMoves(){
        return learnableMoves;
    }



    public List<String> removeInvalidMoves(List<String> pendingMoves){
        return pendingMoves.stream()
                .filter(o -> getLearnableMoves().contains(o))
                .collect(Collectors.toList());
    }


    public int getCurrentNumOfMoves(){
        return moves.size();
    }



    public List<Move> addMoves(String... pendingMoves) throws IOException, JSONException {
        int overloadCheck = getCurrentNumOfMoves() + Utils.getSizeOfVarargs(pendingMoves);
        if(Utils.checkForValidNumOfVarArgs(1,4,pendingMoves) && overloadCheck <= 4){
            List<String> list = removeInvalidMoves(Arrays.asList(pendingMoves));
            for(String s : list){
                moves.add(new Move(s));
            }
            return moves;
        }
       else {
            System.out.println("need to add at least one move and no more than 4(max)");
           return null;
        }
    }

    public List<Move> getMoves(){
        return moves;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public List<Types> getTypes() {
        return types;
    }

    public Types getPrimaryType() {
        return primaryType;
    }

    public Types getSecondaryType() {
        return secondaryType;
    }

    public void setPrimaryType(Types primaryType) {
        this.primaryType = primaryType;
    }

    public void setSecondaryType(Types secondaryType) {
        this.secondaryType = secondaryType;
    }

    public Trainers getTrainer() {
        return trainer;
    }

    public Boolean getBattling() {
        return isBattling;
    }

    public Boolean getHasFainted() {
        return hasFainted;
    }

    public Move getCurrentMove() {
        return currentMove;
    }

    public Map<String, Integer> getORIGINAL_STATS() {
        return ORIGINAL_STATS;
    }

    public void setTrainer(Trainers trainer) {
        this.trainer = trainer;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBattling(Boolean battling) {
        isBattling = battling;
    }

    public void setHasFainted(Boolean hasFainted) {
        this.hasFainted = hasFainted;
    }

    public void setCurrentMove(Move currentMove) {
        this.currentMove = currentMove;
    }

    public Integer getMovesWithPP(){
        Integer numOfMoves = 0;
        for(Move m : moves){
            if(!m.outOfPP()){
                numOfMoves++;
            }
        }
        return numOfMoves;
    }

    public Move pickMove(){
        //random for now
        Integer numOfMoves = getMovesWithPP();
        Move pickedMove;
        if(numOfMoves == 1){
             pickedMove = this.moves.get(0);
        }
        else{
            Integer randomNum = Utils.getRandomNumber(0, numOfMoves-1);
             pickedMove = this.moves.get(randomNum);
        }

        System.out.println(this.getName() + " used " + pickedMove.getName());
        setCurrentMove(pickedMove);
        pickedMove.decrementPP();
        return pickedMove;
    }

}
