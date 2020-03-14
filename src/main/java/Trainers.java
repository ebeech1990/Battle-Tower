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

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
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
        for(Pokemon p : team){
            if(!p.hasFainted()){
                p.setBattling(true);
                return p;
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
