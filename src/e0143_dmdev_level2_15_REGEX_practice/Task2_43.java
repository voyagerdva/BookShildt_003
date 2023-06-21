package e0143_dmdev_level2_15_REGEX_practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2_43 {
    public static void main(String[] args) {
        String regex = "0[Xx][0-9a-fA-F]+";
        String input = "sdfsdf 0Xff asdfasd 0x12 sfasdfas 0XAB 0xABC 0xFF 0xFghjt 0xghj";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
