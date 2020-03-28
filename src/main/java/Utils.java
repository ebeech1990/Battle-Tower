import org.json.JSONObject;

import java.util.Arrays;
import java.util.Random;

public interface Utils {

    static Integer getRandomNumber(Integer min, Integer max){
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }

    static Integer returnZeroIfNull(Object o){
        return o == JSONObject.NULL ? 0 : Integer.parseInt(o.toString());
    }

    @SafeVarargs
    static <T> int getSizeOfVarargs(T... args){
       return Arrays.asList(args).size();
    }

     @SafeVarargs
     static  <T> boolean checkForValidNumOfVarArgs(int min, int max, T... args){
        return getSizeOfVarargs(args) >= min && getSizeOfVarargs(args) <= max;
    }

}
