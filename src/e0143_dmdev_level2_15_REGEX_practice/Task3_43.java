package e0143_dmdev_level2_15_REGEX_practice;

public class Task3_43 {
    public static void main(String[] args) {
        String regex = "(<p .+?>)(.+?</p>)";
        String input = "<p> dfsdf </p> <b> sdfsdf </b> ssdfsdf dsfsdf <p id=\"p1\">sdfsdf ssdfsdf</p>" +
                "AAA <p>sdfsdf BBB <p \"p2\">CCC df</p> ssdadfs" ;

        System.out.println(input.replaceAll(regex,"<p>$2"));

    }
}
