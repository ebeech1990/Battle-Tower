package battletower;

import java.util.ArrayList;
import java.util.List;

public class Trainers {

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
        activePokemon = null;
    }

    public Trainers(String name){
        this.name = name;
        this.team = new ArrayList<>();
        wins = 0;
        loses = 0;
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

    public Pokemon getBattlingPokemon(){

        if(activePokemon == null){
            activePokemon = team.get(0);
            activePokemon.setBattling(true);
            System.out.println(this.getName() + " sent out " + activePokemon.getName());
            return activePokemon;
        }

        else if(!activePokemon.getHasFainted()){
            return activePokemon;
        }


            List<Pokemon> active = new ArrayList<>();
            for(Pokemon p : team){
                if(!p.getHasFainted()){
                    active.add(p);
                }
            }

            if(active.size() == 0){
                return null;
            }
            else{
                activePokemon = active.get(0);
                activePokemon.setBattling(true);
                System.out.println(this.getName() + " sent out " + activePokemon.getName());
                return active.get(0);
            }

    }



    public Boolean outOfPokemon(){
        if(getBattlingPokemon() == null){
            return true;
        }
        return false;
    }


}
