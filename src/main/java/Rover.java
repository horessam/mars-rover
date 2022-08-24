public class Rover {
    public static final char FORWARD_COMMAND = 'F';
    private static final char BACKWARD_COMMAND = 'B';
    private Point point;
    private Direction direction;

    public Rover(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void execute(char command) {
        if (FORWARD_COMMAND == command) {
            setPoint(Point.of(this.point.x() + 1, this.point.y()));
        }
        if (BACKWARD_COMMAND == command) {
            setPoint(Point.of(this.point.x() - 1, this.point.y()));
        }
    }
}
