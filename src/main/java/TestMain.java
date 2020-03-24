import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import com.google.gson.JsonParser;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.*;

public class TestMain {

    public static void main(String[] args) throws IOException, ParseException, JSONException {
        System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");

        CreatePokemon cp = new CreatePokemon("Charmander");
    }





}
