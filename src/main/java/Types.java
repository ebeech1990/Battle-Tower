import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Comparator;

public enum Types {
    NORMAL("GHOST", "FIGHTING"),//normal not strong against anything but is resistant to ghost
    FIRE("GRASS","WATER"),
    WATER("FIRE", "GRASS"),
    ELECTRIC("WATER", "GROUND"),
    GRASS("WATER", "FIRE"),
    ICE("GRASS", "FIRE"),
    FIGHTING("NORMAL","FLYING"),
    POISON("GRASS", "GROUND"),
    //GROUND("")
    GHOST("GHOST", "NORMAL");

    String strongAgainst;
    String weakAgainst;

    Types(String strongAgainst, String weakAgainst){
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
    }



}
