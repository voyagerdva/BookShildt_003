package e0112_Lambda_10_lambda_and_exception_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class AppLambdaDemo1333 {
    public void myRun() throws EmptyArrayException1333 {
        Double[] values = {1.0, 2.0, 3.0, 4.0};
        DoubleNumArrayInterface1333<Double, Double[]> average = n -> {
            double sum = 0;

            if (n.length == 0) {
                throw new EmptyArrayException1333();
            }

            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }

            return (double) sum / n.length;
        };
        System.out.println("Aver is: " + average.func(values));
        System.out.println("Aver is:" + average.func(new Double[0]));
    }


    public void myRun2 () {
        MyFuncInterface123 myLambda = () -> {
//            throw new Exception("Method not implemented");



        };

//
//        try {
//            myLambda.func(new Object());
//        } catch (FileNotFoundException e) {
//            System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + "!!! FileNotFoundException e !!! : " + e.getLocalizedMessage());
//        }

//        myLambda.func();


        String str = "KNEljYjlkjlkjGdfFdf1";

        Optional<String> optionalCharacter = Arrays.stream(str.split("j"))
                .flatMap(s -> {
                    return s.chars().mapToObj(c -> Character.valueOf((char) c));
                })
                .sorted()
                .peek(ch -> {
                    System.out.println("peek(ch) : " + ch);
                })
                .map(ch -> {
                    return ch.toString();
                })
                .reduce((a1, a2) -> {
                    System.out.println("a1: " + a1);
                    if (a1.length() == 1) {
                        if (a2.equals(a1)) {
                            return a1;
                        }
                    } else if (a2.equals(a1.substring(a1.length()-1, a1.length()))) {
                        return a1;
                    }
                    return a1 + "-" + a2;
                });


        String ch = optionalCharacter.get();
        System.out.println();
        System.out.println("optionalCharacter = " + ch);
    }


//    public void myRun3() {
//
//        MyFuncInterface123 myLambda3 = () -> {
//            try {
//                int[] arr = {1, 2, 3};
//
//                for (int i = 0; i < 4; i++) {
//                    System.out.println(arr[i]);
//                }
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + "!!! FileNotFoundException e !!! : " + e.getLocalizedMessage());
//                e.printStackTrace();
//            }
//
//
//        };
//
//
//        myLambda3.func();
//    }


    public void myFileOut3() {
        try {
            System.out.println("\n1: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            new FileInputStream("someFile.txt");
        } catch (FileNotFoundException e) {
            System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + "!!! FileNotFoundException e !!! : " + e.getLocalizedMessage());
        }
    }


    public void myFileOut4() throws FileNotFoundException {
        System.out.println("\n1: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        new FileInputStream("someFile.txt");
        System.err.println("2: " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + "!!! IOException e !!!");
    }


    public void myFileOut5() throws FileNotFoundException {
        System.out.println("\n1: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        new FileInputStream("someFile.txt");
        System.err.println("2: " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + "!!! IOException e !!!");
    }


    public void myFileOut6() throws FileNotFoundException {
        System.out.println("\n1: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        new FileInputStream("someFile.txt");
        System.err.println("2: " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + "!!! IOException e !!!");
    }



    public void myFileOut1() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("out111.txt");
            fileWriter.write("Hello World");
        } catch (IOException e) {
            System.err.println("!!! FILE NOT FOUND !!!");
        }
    }

    public void myFileOut2() throws IOException {
        FileWriter fileWriter = new FileWriter("out.txt");
        fileWriter.write("Hello World");
    }

    public void mySleep1() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mySleep2() throws InterruptedException {
        Thread.sleep(100);
    }

    public void myRun3() {
    }
}
