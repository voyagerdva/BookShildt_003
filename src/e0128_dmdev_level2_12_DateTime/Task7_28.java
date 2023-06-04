package e0128_dmdev_level2_12_DateTime;

import java.time.*;

public class Task7_28 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Africa/Cairo"));
        System.out.println(zonedDateTime);

    }
}
