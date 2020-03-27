import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class PokemonPOJO {
    private Trainers trainer;
    private String name;
    private List<Types> types;
    private Integer weight;
    private Types primaryType;
    private Types secondaryType;
    private Integer speed;
    private Integer hp;
    private List<Moves> moves;
    private Boolean isBattling = false;
    private Boolean hasFainted = false;
    private Moves currentMove;

//    public PokemonPOJO(String name) throws IOException, JSONException {
//        PokemonBuilder pf = new PokemonBuilder(name);
//        this.jo = pf.getJo();
//        this.setName(pf.getPokemonName());
//        this.setWeight(pf.getPokemonWeight());
//        this.setTypes(pf.getPokemonTypes());
//        //this.getTypes().forEach(System.out::println);
//        pf.setTypeOrder(this);
//        this.setHp(pf.getPokemonHP());
//        this.setSpeed(pf.getPokemonSpeed());
//    }

    public PokemonPOJO(String name) throws IOException, JSONException {
        PokemonBuilder builder = new PokemonBuilder(name);
        builder.build(this);
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



}
