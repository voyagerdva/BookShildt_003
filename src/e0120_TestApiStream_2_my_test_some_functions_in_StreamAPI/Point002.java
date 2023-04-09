package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;

public class Point002 {
    String x, y;

    Point002(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public static Point002 of(String x, String y) {
        return new Point002(x, y);
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}
