import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CreatePokemon {
    private JSONObject jo;
    private String name;
    private String url;

    public CreatePokemon(String name) throws IOException, JSONException {
        this.name = name.toLowerCase();
        this.url = "https://pokeapi.co/api/v2/pokemon/" + this.name + "/";
        this.jo = intialToJSONObject(this.url);
        init();
    }

    public PokemonPOJO init() throws JSONException {
        PokemonPOJO pojo = new PokemonPOJO();
        pojo.setName(getPokemonName());
        System.out.println(pojo.getName());
        pojo.setWeight(getPokemonWeight());
        System.out.println(pojo.getWeight());
        pojo.setTypes(getPokemonTypes());
        pojo.getTypes().forEach(System.out::println);
        return pojo;
    }

    public String getPokemonName() throws JSONException {
        return jo.getString("name");
    }

    public int getPokemonWeight() throws JSONException {
        return Integer.parseInt(String.valueOf(jo.getInt("weight"))) ;
    }

    public  List<String> getPokemonTypes() throws JSONException {
        JSONArray ja = jo.getJSONArray("types");
        List<String> types = new ArrayList<>();
        for (int i = 0; i < ja.length(); i++) {
            types.add(getValueFromNameKeyField((JSONObject) ja.get(i)));
        }
        return types;
    }

    public  String getValueFromNameKeyField(JSONObject jo){
        return StringUtils.substringBetween(String.valueOf(jo), "name\":\"", "\",\"url");
    }

    private  String downloadWebPage(String url) throws IOException {
        System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");
        StringBuilder result = new StringBuilder();
        String line;


        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla");

        urlConnection.setReadTimeout(5000);
        urlConnection.setConnectTimeout(5000);

        try (InputStream is = new URL(url).openStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }

        return result.toString();

    }

    public  JSONObject intialToJSONObject(String url) throws IOException, JSONException {
        String s = downloadWebPage(url);
        return new JSONObject(s);
    }

}
