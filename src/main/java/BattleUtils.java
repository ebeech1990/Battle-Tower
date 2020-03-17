import java.util.Random;

public interface BattleUtils {

    static Integer getRandomNumber(Integer min, Integer max){
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }

}
