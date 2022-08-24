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
        switch (this.direction) {
            case E -> {
                switch (command) {
                    case FORWARD_COMMAND -> goToEast();
                    case BACKWARD_COMMAND -> goToWest();
                }
            }
            case W -> {
                switch (command) {
                    case FORWARD_COMMAND -> goToWest();
                    case BACKWARD_COMMAND -> goToEast();
                }
            }
            case N -> {
                if (FORWARD_COMMAND == command) {
                    setPoint(Point.of(this.point.x(), this.point.y() + 1));
                }
            }
        }
    }

    private void goToWest() {
        setPoint(Point.of(this.point.x() - 1, this.point.y()));
    }

    private void goToEast() {
        setPoint(Point.of(this.point.x() + 1, this.point.y()));
    }
}
