package e0128_dmdev_level2_12_DateTime;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ZoneDateTime28 {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        long toEpochMilli = now.toInstant().toEpochMilli();
        System.out.println(toEpochMilli);

        ZonedDateTime plus = now.plus(1L, ChronoUnit.DAYS);
        System.out.println(plus);

        ZonedDateTime zonedDateTime = now.truncatedTo(ChronoUnit.DAYS);
        System.out.println(zonedDateTime);
    }
}
