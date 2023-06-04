package e0128_dmdev_level2_12_DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task2_28 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String format = now.format(formatter);

        System.out.println(format);


    }
}
