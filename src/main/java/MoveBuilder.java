import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MoveBuilder {
    private JSONObject jo;

    public MoveBuilder(String name) throws IOException, JSONException {
        APIParser apiParser = new APIParser("move", name);
        this.jo = apiParser.getJo();
    }

    public int getMoveAccuracy() throws JSONException {
        return Utils.returnZeroIfNull(jo.get("accuracy"));
    }

    public Types getMoveType() throws JSONException {
        JSONObject type = jo.getJSONObject("type");
        String s = APIParser.getValueFromKeyField(type, "name").toUpperCase();
        return Types.valueOf(s);
    }

    public int getMovePower() throws JSONException {
        return Utils.returnZeroIfNull(jo.get("power"));
    }

    public int getMovePP() throws JSONException {
        return Utils.returnZeroIfNull(jo.get("pp"));
    }



    public Move build(Move move) throws JSONException {
        move.setAccuracy(getMoveAccuracy());
        move.setPower(getMovePower());
        move.setType(getMoveType());
        move.setPp(getMovePP());
        return move;
    }
}
