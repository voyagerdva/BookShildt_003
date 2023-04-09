package e0101_Meta_Wildcard_1_from_youtube;

public class App1 {
    public void run() {
        Point<Integer> ptI = new Point<>(1, 2);
        Point<Double> ptD = new Point<>(1.0, 2.0);

        boolean a = ptI.equalsPoint(ptD);
        System.out.println(a);
    }
}
