import java.util.ArrayList;
import java.util.List;

public class Trainers {

    private List<Pokemon> team;
    private String name;
    private Integer wins;
    private Integer loses;
    public Trainers(String name, List<Pokemon> team){
        this.name = name;
        this.team = new ArrayList<Pokemon>();
        this.team = team;
        wins = 0;
        loses = 0;
    }

    public Trainers(String name){
        this.name = name;
        this.team = new ArrayList<Pokemon>();
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

    public Pokemon getBattlingPokemon(){
        Integer index = 0;
        Integer count = team.size();
        while (count > 0)
        for(Pokemon p : team){
            if(!p.hasFainted()){
                p.setBattling(true);
                index=team.indexOf(p);
                System.out.println(this.getName() + " sent out " + p.getName());
                return team.get(index);
            }
            else {
                count--;
            }

        }


        return null;
    }



    public Boolean outOfPokemon(){
        if(getBattlingPokemon() == null){
            return true;
        }
        return false;
    }


}
