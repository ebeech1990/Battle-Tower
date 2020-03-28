import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class PokemonBuilder {

    private JSONObject jo;

    public PokemonBuilder(String name) throws IOException, JSONException {
        APIParser apiParser = new APIParser("pokemon", name);
        this.jo = apiParser.getJo();

    }

    public Integer getPokemonSpeed() throws JSONException {
        return Integer.parseInt(getPokemonStatFromApi("stats", "speed", "base_stat"));
    }

    public Integer getPokemonHP() throws JSONException {
        return Integer.parseInt(getPokemonStatFromApi("stats", "hp", "base_stat"));
    }

    //for getting hp, def, etc
    public String getPokemonStatFromApi(String arrName, String searchedName, String valueKey) throws JSONException {
       String result;
        JSONArray ja = APIParser.getOuterJsonArray(arrName, jo);
        Integer i = APIParser.getIndexOfFieldWithByName(searchedName, ja);
        result =  ((JSONObject) ja.get(i)).getString(valueKey);
        return result;
    }



    public void setTypeOrder(Pokemon pojo){
        int numOfTypes = pojo.getTypes().size();
        if(numOfTypes == 1){
            pojo.setPrimaryType(pojo.getTypes().get(0));
            pojo.setSecondaryType(null);
        }
        else {
            pojo.setPrimaryType(pojo.getTypes().get(1));
            pojo.setSecondaryType(pojo.getTypes().get(0));
        }
    }

    public String getPokemonName() throws JSONException {
        return jo.getString("name");
    }

    public int getPokemonWeight() throws JSONException {
        return Integer.parseInt(String.valueOf(jo.getInt("weight"))) ;
    }

    public List<Types> getPokemonTypes() throws JSONException {
        JSONArray ja = jo.getJSONArray("types");
        List<Types> types = new ArrayList<>();
        for (int i = 0; i < ja.length(); i++) {
            String s = APIParser.getValueFromKeyField((JSONObject) ja.get(i), "name").toUpperCase();
            Types t = Types.valueOf(s);
            types.add(t);
        }
        return types;
    }

    public List<String> learnableMoves() throws JSONException {
        JSONArray ja = jo.getJSONArray("moves");
        List<String> moves = new ArrayList<>();
        for (int i = 0; i < ja.length(); i++) {
            JSONObject move = (JSONObject) ja.get(i);
            JSONObject mov = move.getJSONObject("move");
            moves.add(APIParser.getValueFromKeyField(mov, "name"));
        }
        return moves;
    }

    public Pokemon build(Pokemon pojo) throws JSONException {
        pojo.setName(getPokemonName());
        pojo.setWeight(getPokemonWeight());
        pojo.setTypes(getPokemonTypes());
        //this.getTypes().forEach(System.out::println);
        setTypeOrder(pojo);
        pojo.setHp(getPokemonHP());
        pojo.setSpeed(getPokemonSpeed());
        pojo.setLearnableMoves(learnableMoves());
        return pojo;
    }


}
