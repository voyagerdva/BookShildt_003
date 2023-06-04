package e0128_dmdev_level2_12_DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task3_28 {
    public static void main(String[] args) {
        String formatterDate = "26-03-1968T09:24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(formatterDate, formatter);

        System.out.println(localDateTime);

    }
}
