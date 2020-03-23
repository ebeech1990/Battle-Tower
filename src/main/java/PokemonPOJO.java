import java.util.List;

public class PokemonPOJO {
    private String name;
    private List<String> types;
    private Integer weight;

    public PokemonPOJO(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
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
}
