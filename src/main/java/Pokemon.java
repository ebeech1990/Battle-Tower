public class Pokemon {
    private String name;
    private Types type;

    public Pokemon(String name, Types type){
        this.name = name;
        this.type = type;
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

    public  String battle(Pokemon opponent){
        if(this.getType().weakAgainst.equals(opponent.getType().toString())){
            return opponent.getName();
        }
        else if(this.getType().strongAgainst.equals(opponent.getType().toString())){
            return this.getName();
        }
        return "tie";
    }
}
