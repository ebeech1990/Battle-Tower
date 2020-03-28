public abstract class ResetStats {

    static void restoreHasFainted(Pokemon p){
        p.setHasFainted(false);
    }

    static void restoreIsBattling(Pokemon p){
        p.setBattling(false);
    }

    static void restoreStartingHP(Pokemon p){
        p.setHp(p.getOriginalStats().get("hp"));
    }

    static void restoreAllPokemonStats(Pokemon p){
        restoreHasFainted(p);
        restoreIsBattling(p);
        restoreStartingHP(p);
    }

    static void restorePP(Move m){
        m.setPp(m.getOriginalStats().get("pp"));
    }

    static void restoreAccuracy(Move m){
        m.setAccuracy(m.getOriginalStats().get("accuracy"));
    }

    static void restorePower(Move m){
        m.setPower(m.getOriginalStats().get("power"));
    }

    static void restoreAllMoveStats(Move m){
        restorePP(m);
        restoreAccuracy(m);
        restorePower(m);
    }

    static void restoreAllStats(Pokemon p, Move m){
        restoreAllPokemonStats(p);
        restoreAllMoveStats(m);
    }
}
