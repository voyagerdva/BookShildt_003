
package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Sample007 {
    public static void main(String[] args) throws IOException {
        String s = "Это демонстрация метода getChars() .";
        int start = 4;
        int end = 8;
        char[] buf = new char[end - start];
        s.getChars(start, end, buf, 0);
        System.out.println(buf);

        System.out.println(s.toCharArray());

        //========================================================================

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

//        int i;
//        int sum = 0;
//        System.out.println("Enter dig, 0 - for exit:");
//
//        do {
//            str = br.readLine();
//            try {
//                i = Integer.parseInt(str);
//            } catch (NumberFormatException e) {
//                System.out.println("BAD FORMAT");
//                i = 0;
//            }
//            sum += i;
//            System.out.println("Existing summa = :" + sum);
//        } while (i != 0);

        //==============================================================

        String s2 = Integer.toString(10) + Integer.toString(5) + " digits";
        System.out.println(s2);
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toOctalString(15));
        System.out.println(Integer.toHexString(15).toUpperCase());

        Integer i3 = 5;
        int i4 = i3 + i3;
        int i5 = i3 + i3.intValue();


        System.out.println(i3 + i3.intValue());

        //==============================================================

        char a[] = {'a', 'b', '5', '?', 'A', ' '};

        for (int i = 0; i < a.length; i++) {
            if (Character.isDigit(a[i])) {
                System.out.println(a[i] + " - это цифра.");
            }
            if (Character.isLetter(a[i])) {
                System.out.println(a[i] + " - это буква.");
            }
            if (Character.isWhitespace(a[i])) {
                System.out.println(a[i] + " - это пробельный символ.");
            }
            if (Character.isUpperCase(a[i])) {
                System.out.println(a[i] + " - это прописная буква.");
            }
            if (Character.isLowerCase(a[i])) {
                System.out.println(a[i] + " - это строчная буква.");
            }
        }


        //==============================================================
        Character H = 'H';
        Character e = 'e';
        Character l = 'l';
        Character o = 'o';
        Character W = 'W';
        Character r = 'r';
        Character d = 'd';
        Character z = ',';
        Character p = ' ';
        Character v = '!';

        char[] hello = {H, e, e, l, l, o,};

        for (int i = 0; i < hello.length; i++) {
            System.out.println(hello);
        }
        System.out.println(hello);

        String s4 = String.valueOf(H)
                + String.valueOf(e)
                + String.valueOf(l)
                + String.valueOf(l)
                + String.valueOf(o)
                + String.valueOf(z)
                + String.valueOf(p)
                + String.valueOf(W)
                + String.valueOf(o)
                + String.valueOf(r)
                + String.valueOf(l)
                + String.valueOf(d)
                + String.valueOf(v);

        System.out.println(s4);

        char num[] = {72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33};
        String s5 = null;
        for (char i : num) {
            if (s5 == null) {
                s5 = s5.valueOf(i);
            } else s5 += s5.valueOf(i);
        }


        //==============================================================


        //==============================================================


        //==============================================================


        //==============================================================


        //==============================================================


        //==============================================================


        //==============================================================


        //==============================================================


        //==============================================================

        //==============================================================
        //==============================================================

        //==============================================================
        //==============================================================

        //==============================================================
        //==============================================================

        //==============================================================
        //==============================================================

        //==============================================================
        //==============================================================

        //==============================================================


    }
}
