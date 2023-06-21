package e0143_dmdev_level2_15_REGEX_practice;

import java.util.regex.Pattern;

public class Task1_43 {
    public static void main(String[] args) {
        String regex = "[a-zA-Z]\\w*@\\w{3,}\\.(org|com)";
        String input = "dmdev@gmail.com";
        System.out.println(Pattern.matches(regex, input));
//        Pattern


    }
}
