package e0128_dmdev_level2_12_DateTime;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Task8_28 {
    public static void main(String[] args) throws NoSuchFieldException{

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));
        System.out.println(localDateTime);

        LocalDateTime with = now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));

        now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));


        soutListOfNow(((((now)))));

        String s = "#AARRGGBB";
        ColorUIResource colorUIResource = new ColorUIResource(Color.BLUE);
        ColorUIResource colorUIResource1 = new ColorUIResource(0xca0924);
        ColorUIResource colorUIResource2 = new ColorUIResource(0xca081);
        ColorUIResource colorUIResource3 = new ColorUIResource(0xc0063);
        ColorUIResource colorUIResource4 = new ColorUIResource(0xc4492);


    }

    private static void soutListOfNow(LocalDateTime now) {
        List<LocalDateTime> ints = new ArrayList<>();

        ints.add(now);
        ints.add(now);
        ints.add(now);
        ints.add(now);
        ints.add(now);
        ints.add(now);
        ints.add(now);

        for (LocalDateTime anInt : ints) {
            System.out.println(anInt + " lkjlkjlj ");
        }



    }
}                    







