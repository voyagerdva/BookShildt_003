package e0133_dmdev_level2_13_Threads_practice;

import java.util.Random;

public final class RandomUtil_33 {
    public static final Random RANDOM = new Random();
    public static final int DEFAULT_BOUND = 10;

    private RandomUtil_33() {
    }

    public static int getRandom() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

    public static int getRandom(int bound) {
        return RANDOM.nextInt(bound);
    }



}
