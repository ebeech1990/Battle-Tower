import java.util.ArrayList;
import java.util.List;

public class Trainers {

    private List<Pokemon> team;
    private String name;

    public Trainers(String name, List<Pokemon> team){
        this.name = name;
        this.team = new ArrayList<Pokemon>();
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
}
