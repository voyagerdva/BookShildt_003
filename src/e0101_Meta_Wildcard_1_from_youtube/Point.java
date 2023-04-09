package e0101_Meta_Wildcard_1_from_youtube;

public class Point<T extends Number> {
    public T x;
    public T y;

    Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    double getMax() {
        double xd = x.doubleValue();
        double yd = y.doubleValue();
        return Math.max(xd, yd);
    }

    boolean equalsPoint(Point<?> pt) {
        return (this.x.doubleValue() == pt.x.doubleValue() &&
                this.y.doubleValue() == pt.y.doubleValue());
    }

}
