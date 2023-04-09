package e0108_Lambda_6;

public class AppLambdaDemo8 {
    public void run() {
        MyNumber8 myNumber3;
        MyNumber8 myNumber31;

        myNumber3 = () -> 123.45;
        myNumber31 = () -> 300.51;

        System.out.println("Fixed value: " + myNumber3.getValue());
        System.out.println("Fixed value: " + myNumber31.getValue());

//        myNumber3 = () -> Math.random() * 100;
//        myNumber31 = () -> Math.random() * 200;

//        System.out.println("Random value: " + myNumber3.getValue());
//        System.out.println("Random value 2: " + myNumber3.getValue());


    }
}
