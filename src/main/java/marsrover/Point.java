package marsrover;

public record Point(int x, int y) {
    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Point {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
