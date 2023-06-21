package e0142_dmdev_level2_15_REGEX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {
    public static void main(String[] args) {
        String phoneNumber = "sdfsdfsdf +375 (29) 898-33-29 asasdfsdfsd +375 (44) 777-12-13 " +
                "sdfsdfsdffd +375 (25) 898-12-13 sdfsdfsdfsdf +375 (25) 111-11-11 sdf";
        String regex = "(?:\\+375)? ?\\((?<code>\\d{2})\\) ?(\\d{3})-(\\d{2})-(\\d{2})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

//        matcherGroup(matcher);

        StringBuilder stringBuilder = new StringBuilder();

//        matcherAppReplStringGroup(matcher, stringBuilder);

        while (matcher.find()) {
            String gr1 = matcher.group(2);
            String gr2 = matcher.group(3);
            String gr3 = matcher.group(4);
//            matcher.appendReplacement(stringBuilder, gr1 + " " + gr2 + " " + gr3);
            matcher.appendReplacement(stringBuilder, "$2 $3 $3");
        }


        matcher.appendTail(stringBuilder);

        System.out.println(stringBuilder);
        System.out.println(phoneNumber.replaceAll(regex, "$2 = $3 = $4"));
    }


    private static void matcherAppReplStringGroup(Matcher matcher, StringBuilder stringBuilder) {
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, "XXX");
        }

        matcher.appendTail(stringBuilder);

        System.out.println(stringBuilder);
    }

    private static void matcherGroup(Matcher matcher) {
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group("code"));
        }
    }
}
