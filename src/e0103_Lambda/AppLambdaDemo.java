package e0103_Lambda;

public class AppLambdaDemo {
    public void run() {
        MyNumber3 myNumber3;
//        MyNumber3 myNumber31;

        myNumber3 = () -> 123.45;
        System.out.println(myNumber3.getValue());
//        myNumber31 = () -> 300.51;

//        System.out.println("Fixed value: " + myNumber3.getValue());

//        myNumber3 = () -> Math.random() * 100;
//        myNumber31 = () -> Math.random() * 200;

//        System.out.println("Random value: " + myNumber3.getValue());
//        System.out.println("Random value 2: " + myNumber3.getValue());


    }
}
