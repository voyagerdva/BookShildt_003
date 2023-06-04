package e0128_dmdev_level2_12_DateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Task4_28 {
    public static void main(String[] args) {
        String formatterDate = "26-03-1968T09:24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(formatterDate, formatter);
        System.out.println(localDateTime);

        Instant instant = localDateTime.toInstant(ZoneId.of("America/Chicago").getRules().getOffset(localDateTime));
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());

        List<Integer> ints = new ArrayList<>();
        ints.add(4);
        ints.add(4);
        ints.add(4);
        ints.add(4);
        ints.add(4);
        ints.add(4);

        for (Integer item : ints) {
            System.out.println(item + "   ");
        }

    }
}
