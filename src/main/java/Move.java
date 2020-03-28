import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Move {
    private String name;
    private Types type;
    private Integer power;
    private Integer accuracy;
    private Integer pp;
    private boolean usable = true;
    private final Map<String, Integer> ORIGINAL_STATS;

    public Move(String name) throws IOException, JSONException {
        MoveBuilder builder = new MoveBuilder(name);
        builder.build(this);
        ORIGINAL_STATS = new HashMap<>();
        ORIGINAL_STATS.put("power", power);
        ORIGINAL_STATS.put("accuracy", accuracy);
        ORIGINAL_STATS.put("pp", pp);
        this.name = name;
    }

    public Map<String, Integer> getOriginalStats(){
        return ORIGINAL_STATS;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }



    public Integer decrementPP(){
        this.setPp(this.getPp()-1);
        if(outOfPP()){
            this.setUsable(false);
            return -1;
        }
        return this.getPp();
    }

    public Boolean outOfPP(){
        if(this.getPp()<=0){
            this.setUsable(false);
            return true;
        }
        return false;
    }

}
