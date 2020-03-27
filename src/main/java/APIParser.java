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

public class APIParser {
    private JSONObject jo;

    public APIParser(String creationType, String creationName) throws IOException, JSONException {
        this.jo = initialToJSONObject(urlBuilder(creationType,creationName));
    }

    public String urlBuilder(String creationType, String creationName){
        return "https://pokeapi.co/api/v2/" + creationType + "/" + creationName;
    }

    public JSONObject getJo() {
        return jo;
    }

    public static String getValueFromKeyField(JSONObject jo, String fieldName){
        return StringUtils.substringBetween(String.valueOf(jo), fieldName + "\":\"", "\",\"");
    }

    private static String downloadWebPage(String url) throws IOException {
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

    public static JSONObject initialToJSONObject(String url) throws IOException, JSONException {
        String s = downloadWebPage(url);
        return new JSONObject(s);
    }

    public static Integer getIndexOfFieldWithByName(String value, JSONArray ja) throws JSONException {
        Integer index = null;
        for (int i = 0; i < ja.length(); i++) {
            String fieldNameValue = APIParser.getValueFromKeyField((JSONObject) ja.get(i), "name");
            if(fieldNameValue.equals(value)){
                index = i;
            }
        }
        return index;
    }

    public static JSONArray getOuterJsonArray(String arrName, JSONObject jo) throws JSONException {
        return jo.getJSONArray(arrName);
    }


}

