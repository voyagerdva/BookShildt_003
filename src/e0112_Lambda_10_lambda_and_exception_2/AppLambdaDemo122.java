package e0112_Lambda_10_lambda_and_exception_2;

import java.io.*;

public class AppLambdaDemo122 {
    public void myRun() throws EmptyArrayException122 {
        Double[] values = {1.0, 2.0, 3.0, 4.0};
        DoubleNumArrayInterface122<Double, Double[]> average = n -> {
            double sum = 0;

            if (n.length == 0) {
                throw new EmptyArrayException122();
            }

            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }

            return (double) sum / n.length;
        };
        System.out.println("Aver is: " + average.func(values));
        System.out.println("Aver is:" + average.func(new Double[0]));
    }


    public void myRun2() {
        MyFuncInterface122 myLambda = (n) -> {
            n = 12;
            System.out.println(n);



            myFileOut3();
            System.out.println("\n0: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            try {
                myFileOut4();
            } catch (FileNotFoundException e) {
                System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + "!!! FileNotFoundException e !!! : " + e.getLocalizedMessage());
            }

//            myFileOut5();
//
//            myFileOut6();

            n = 14;
            System.out.println(n);

            return n;
        };


        try {
            myLambda.func(new Object());
        } catch (FileNotFoundException e) {
            System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + "!!! FileNotFoundException e !!! : " + e.getLocalizedMessage());
        }

//        myLambda.func(new Object());



    }


    public void myRun3() {

        MyFuncInterface123 myLambda3 = () -> {
            try {
                int[] arr = {1, 2, 3};

                for (int i = 0; i < 4; i++) {
                    System.out.println(arr[i]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + "!!! FileNotFoundException e !!! : " + e.getLocalizedMessage());
                e.printStackTrace();
            }


        };


        myLambda3.func();
    }


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

}
