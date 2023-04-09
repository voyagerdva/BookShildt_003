package e0111_Lambda_9_args;

import java.util.Locale;

public class AppLambdaDemo11 {
    String stringOp(StringFuncInterface11<String> sf, String s) {
        return sf.func(s);
    }

    Integer intOp(StringFuncInterface11<Integer> sf, int i) {
        return sf.func(i);
    }

    public void run() {
        String inStr = "bla bla bla";
        String outStr;
        System.out.println("1: " + inStr);


        StringFuncInterface11<String> s = (str) -> str.toUpperCase();
        outStr = stringOp(s, inStr);
        System.out.println("2: " + outStr);


        StringFuncInterface11<Integer> in = (i) -> i * i * i;
        int j = intOp(in, 7);
        System.out.println("3: " + j);

        outStr = stringOp((str) -> {
            String result = "";

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }
            return result;
        }, inStr);

        System.out.println("4:" + outStr);

        StringFuncInterface11<String> reverse = str -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }

            return result;
        };

        System.out.println(reverse.func("1 2 3 4 5"));

        System.out.println("5: " + stringOp(reverse, inStr));
    }
}
