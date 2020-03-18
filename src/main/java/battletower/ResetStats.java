package battletower;

public abstract class ResetStats {

    static void restoreHasFainted(Pokemon p){
        p.setHasFainted(false);
    }

    static void restoreIsBattling(Pokemon p){
        p.setBattling(false);
    }

    static void restoreStartingHP(Pokemon p){
        p.setHp(p.getStartingHP());
    }

    static void restoreAllPokemonStats(Pokemon p){
        restoreHasFainted(p);
        restoreIsBattling(p);
        restoreStartingHP(p);
    }

    static void restorePP(Moves m){
        m.setPp(m.getOriginalPP());
    }

    static void restoreAccuracy(Moves m){
        m.setAccuracy(m.getOriginalAccuracy());
    }

    static void restorePower(Moves m){
        m.setPower(m.getOriginalPower());
    }

    static void restoreAllMoveStats(Moves m){
        restorePP(m);
        restoreAccuracy(m);
        restorePower(m);
    }

    static void restoreAllStats(Pokemon p, Moves m){
        restoreAllPokemonStats(p);
        restoreAllMoveStats(m);
    }
}
