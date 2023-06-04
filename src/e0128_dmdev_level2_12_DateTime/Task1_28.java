package e0128_dmdev_level2_12_DateTime;

import java.time.LocalDateTime;

public class Task1_28 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 25, 19, 47);
        LocalDateTime newLocalDateTime1 = localDateTime.plusMonths(3L);

        System.out.println(newLocalDateTime1.toLocalDate());
        System.out.println(newLocalDateTime1.toLocalTime());
    }
}
