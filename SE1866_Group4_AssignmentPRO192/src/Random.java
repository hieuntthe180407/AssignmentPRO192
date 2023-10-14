
import java.util.*;
import java.lang.*;
public class Random {
    public static int genRandomInt() {
        java.util.Random rand = new java.util.Random();
        return rand.nextInt();
    }
    public static int genRandomInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min must be less than or equal to Max");
        }
        java.util.Random random = new java.util.Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
