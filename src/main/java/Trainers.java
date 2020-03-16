import java.util.ArrayList;
import java.util.List;

public class Trainers {

    private List<Pokemon> team;
    private String name;
    private Integer wins;
    private Integer loses;
    private Pokemon activePokemon;
    private Pokemon lastPokemon;
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

    public Pokemon getLastPokemon() {
        return lastPokemon;
    }

    public void setLastPokemon(Pokemon lastPokemon) {
        this.lastPokemon = lastPokemon;
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

    public void setName(String name) {
        this.name = name;
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
        //////////////////
        //Below is the problem. I cannot get the Raticate to not be active");
        setActivePokemon(null);
        /////////////////");
        toTakeOut.setHasFainted(true);
        toTakeOut.setBattling(false);
       Pokemon toTagIn = team
                .stream()
                .filter(p -> !p.getHasFainted())
                .findFirst()
                .orElse(null);
       if(toTagIn == null){
           System.out.println("hi");
           return null;
       }
        setActivePokemon(toTagIn);
        toTagIn.setBattling(true);
        if(team.indexOf(toTagIn) == team.size()-1){
            setLastPokemon(toTagIn);
        }
        System.out.println(this.getName() + " sent out " + toTagIn.getName());
        return toTagIn;
    }

//    public Pokemon getBattlingPokemon(){
//
//        if(activePokemon == null){
//            activePokemon = team.get(0);
//            activePokemon.setBattling(true);
//            System.out.println(this.getName() + " sent out " + activePokemon.getName());
//            return activePokemon;
//        }
//
//        else if(!activePokemon.getHasFainted()){
//            return activePokemon;
//        }
//
//
//        List<Pokemon> active = new ArrayList<>();
//        for(Pokemon p : team){
//            if(!p.getHasFainted()){
//                active.add(p);
//            }
//        }
//
//        if(active.size() == 0){
//            return null;
//        }
//        else{
//            activePokemon = active.get(0);
//            activePokemon.setBattling(true);
//            System.out.println(this.getName() + " sent out " + activePokemon.getName());
//            return active.get(0);
//        }
//
//    }



    public Boolean outOfPokemon(){
        int count = (int) team
                .stream()
                .filter(p -> p.getHasFainted())
                .count();

        if(count == team.size()){
            return true;
        }
        return false;
    }


}