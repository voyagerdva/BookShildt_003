package e0142_dmdev_level2_15_REGEX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {
    public static void main(String[] args) {
        String phoneNumber = "+375 (29) 898-12-13";

        Pattern pattern = Pattern.compile("\\+375 \\(\\d{2}\\) \\d{3}-\\d{2}-\\d{2 }");
        Matcher matcher = pattern.matcher(phoneNumber);

        System.out.println(matcher.matches());
    }
}
