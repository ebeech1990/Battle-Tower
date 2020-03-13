import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Comparator;

public enum Types {
    NORMAL("POISON", "FIGHTING"),//normal not strong against anything but is resistant to ghost
    FIRE("GRASS","WATER"),
    WATER("FIRE", "GRASS"),
    ELECTRIC("WATER", "GROUND"),
    GRASS("WATER", "FIRE"),
    ICE("GRASS", "FIRE"),
    FIGHTING("NORMAL","POISON"),
    POISON("GRASS", "POISON"),
    GROUND("FIRE", "GRASS"),
    BUG("GRASS", "FIRE"),
    DARK("GHOST", "FIGHTING"),
    DRAGON("DRAGON", "ICE"),
    FLYING("GRASS", "ELECTRIC"),
    PSYCHIC("FIGHTING", "PSYCHIC"),
    GHOST("GHOST", "DARK"),
    ROCK("ICE", "FIGHTING"),
    STEEL("ICE", "WATER");

    String strongAgainst;
    String weakAgainst;

    Types(String strongAgainst, String weakAgainst){
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
    }



}
