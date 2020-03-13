public class Moves {
    private String name;
    private Types type;
    private Integer power;
    private Integer accuracy;
    private Integer pp;
    private boolean useable;
    private Integer originalPP;
    private Integer originalAccuracy;
    private Integer originalPower;

    public Moves(String name, Types type, Integer power, Integer accuracy, Integer pp){
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        useable = true;
        originalPP = pp;
        originalAccuracy = accuracy;
        originalPower = power;
    }

    public Integer getOriginalPP() {
        return originalPP;
    }

    public Integer getOriginalAccuracy() {
        return originalAccuracy;
    }

    public Integer getOriginalPower() {
        return originalPower;
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

    public boolean isUseable() {
        return useable;
    }

    public void setUseable(boolean useable) {
        this.useable = useable;
    }






}
