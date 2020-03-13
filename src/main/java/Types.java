import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Comparator;

public enum Types {
    FIRE("GRASS","WATER"),
    WATER("FIRE", "GRASS"),
    GRASS("WATER", "FIRE"),
    GHOST("GHOST", "NORMAL"),
    NORMAL("GHOST", "FIGHTING");//normal not strong against anything but is resistant to ghost
    String strongAgainst;
    String weakAgainst;

    Types(String strongAgainst, String weakAgainst){
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
    }



}
