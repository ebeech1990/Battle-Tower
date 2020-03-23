import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import org.json.simple.*;
import org.json.simple.parser.*;


import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class TestMain {

    public static void main(String[] args) throws IOException, ParseException {
        JSONObject obj = new JSONObject(IOUtils.toString(new URL(jsonlink), Charset.forName("UTF-8")));
        JSONObject facet_counts = obj.getJSONObjecy("facet_counts");
        JSONObject facet_fields = facet_counts.getJSONObjecy("facet_fields");
        JSONArray test_array = obj.getJSONArray("TESTARRAY");
        Integer smithage = test_array.getInt(3);
    }
}
