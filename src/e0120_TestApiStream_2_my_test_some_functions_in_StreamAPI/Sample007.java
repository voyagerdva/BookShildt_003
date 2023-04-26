
package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        System.out.println();
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

//        for (int i = 0; i < hello.length; i++) {
//            System.out.println(hello);
//        }
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
        System.out.println();
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().availableProcessors());
//        Runtime.getRuntime().halt(-1);
        System.out.println(Runtime.getRuntime().getClass());

        //==============================================================
        System.out.println();

        Runtime r1 = Runtime.getRuntime();
        long mem1;
        long mem2;
        int qty = 1000;
        Integer someints[] = new Integer[qty];

        System.out.println("Всего памяти: " + r1.totalMemory());
        mem1 = r1.freeMemory();

        System.out.println("Свободной памяти иходно: " + mem1);
        r1.gc();
        mem1 = r1.freeMemory();
        System.out.println("Свободной памяти после очистки gc(): " + mem1);

        for (int i = 0; i < qty; i++) {
            someints[i] = Integer.valueOf(new String(String.valueOf(i))); // выделить память для объектов типа Integer
        }

        mem2 = r1.freeMemory();
        System.out.println("Свободной памяти после выделения: " + mem2);
        System.out.println("Использовано памяти для выделения: " + (mem1 - mem2));

        // отвергнуть объекты типа Integer:
        for (int i = 0; i < qty; i++) {
            someints[i] = null;
        }
        r1.gc(); // запустить сборку мусора gc()

        mem2 = r1.freeMemory();
        System.out.println("Свободной памяти после очистки отвергнутых объектов типа Integer: " + mem2);

        //==============================================================

        Runtime r2 = Runtime.getRuntime();
        Process p2 = null;
        String name = "Notepad";

        try {
            p2 = r2.exec(name);
            Thread.sleep(1000);
//            p2.waitFor();
            p2.destroy();
        } catch (Exception exception) {
            System.out.println("Error run");
        }
//        System.out.println("Notepad возвратил " + p2.exitValue());

        Runtime.Version ver = Runtime.version();
        // вывести номера отдельных версий
        System.out.println("Ocнoвнoй номер версии: "
                + ver.major());
        System.out.println("Дoпoлнитeльный номер версии: "
                + ver.minor());
        System.out.println("Hoмep версии системы защиты: "
                + ver.security());

        //==============================================================
        System.out.println();
        Map<String, String> env = new ProcessBuilder().environment();
        env.entrySet().forEach(System.out::println);

        //==============================================================

        System.out.println();
        try {
            ProcessBuilder proc = new ProcessBuilder("notepad.exe", "testfile.txt");
            proc.start();

        } catch (Exception e3) {
            System.out.println("\n>.. 0шибка запуска Notepad");
            e3.printStackTrace();
        }

        //==============================================================

        System.out.println();

        byte[] a4 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74};
        byte[] b4 = {77, 77, 77, 77, 77, 77, 77, 77, 77, 77};

        System.out.println("a4 = " + new String(a4));
        System.out.println("b4 = " + new String(b4));
        System.arraycopy(a4, 0, b4, 0, a4.length);

        System.out.println("a4 = " + new String(a4));
        System.out.println("b4 = " + new String(b4));
        System.arraycopy(a4, 0, a4, 1, a4.length - 1);

        System.arraycopy(b4, 1, b4, 0, b4.length - 1);
        System.out.println("a4 = " + new String(a4));
        System.out.println("b4 = " + new String(b4) );
        //==============================================================

        System.out.println();
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("path.separator"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("line.separator"));

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
