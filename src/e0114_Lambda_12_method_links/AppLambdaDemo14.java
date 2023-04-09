package e0114_Lambda_12_method_links;

import java.util.function.Function;

public class AppLambdaDemo14 {
    String stringOp(StringFuncInterface14<String> sf, String s) {
        return sf.func(s);
    }

    String stringOp2(StringFuncInterface14<String> sf, String s) {
        return sf.func(s);
    }


    public void run() {

        String inStr = "Bla Bla Bla";
        String outStr;

        //==================================================================

        StringFuncInterface14<String> sfi = MyStringOps::strReverse;
        outStr = stringOp(sfi, inStr);
        System.out.println(inStr + "\n" + outStr);

        //===================================================================

        MyStringOps2 myStringOps2 = new MyStringOps2();
        StringFuncInterface14<String> sfi2 = myStringOps2::strReverse;
        outStr = stringOp2(sfi2, inStr);
        System.out.println(inStr + "\n" + outStr);
    }
}
