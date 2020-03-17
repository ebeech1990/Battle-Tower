import java.util.ArrayList;
import java.util.List;

public class Trainers{

    private List<Pokemon> team;
    private String name;
    private Integer wins;
    private Integer loses;
    private Pokemon activePokemon;


    public Trainers(String name, List<Pokemon> team){
        this.name = name;
        this.team = new ArrayList<>();
        this.team = team;
        wins = 0;
        loses = 0;

    }

    public Trainers(String name){
        this.name = name;
        this.team = new ArrayList<>();
        wins = 0;
        loses = 0;
    }


    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void addPokemon(Pokemon p) {
        this.team.add(p);
    }

    public String getName() {
        return name;
    }


    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLoses() {
        return loses;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
    }

    public Pokemon getActivePokemon(){
        return activePokemon;
    }

    public Pokemon getBattlingPokemon(Pokemon toTakeOut){
        if(!toTakeOut.getHasFainted()){
            return toTakeOut;
        }
        setActivePokemon(null);
        toTakeOut.setHasFainted(true);
        toTakeOut.setBattling(false);
       Pokemon toTagIn = team
                .stream()
                .filter(p -> !p.getHasFainted())
                .findFirst()
                .orElse(null);
       if(toTagIn == null){
           return null;
       }
        setActivePokemon(toTagIn);
        toTagIn.setBattling(true);
        Summary.sentOut(this.getName(),toTagIn.getName());
        return toTagIn;
    }


    public Boolean outOfPokemon(){
        int count = (int) team
                .stream()
                .filter(Pokemon::getHasFainted)
                .count();

        if(count == team.size()){
            return true;
        }
        return false;
    }


}