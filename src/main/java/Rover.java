public class Rover {
    public static final char FORWARD_COMMAND = 'F';
    private static final char BACKWARD_COMMAND = 'B';
    private static final char TURN_RIGHT_COMMAND = 'R';
    private static final char TURN_LEFT_COMMAND = 'L';
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
        switch (command) {
            case FORWARD_COMMAND -> {
                switch (this.direction) {
                    case E -> goToEast();
                    case W -> goToWest();
                    case N -> goToNorth();
                    case S -> goToSouth();
                }
            }
            case BACKWARD_COMMAND -> {
                switch (this.direction) {
                    case E -> goToWest();
                    case W -> goToEast();
                    case N -> goToSouth();
                    case S -> goToNorth();
                }
            }
            case TURN_RIGHT_COMMAND -> {
                switch (this.direction) {
                    case N -> setDirection(Direction.E);
                }
            }
            case TURN_LEFT_COMMAND -> {
                switch (this.direction) {
                    case N -> setDirection(Direction.W);
                }
            }
        }
    }

    private void goToSouth() {
        setPoint(Point.of(this.point.x(), this.point.y() - 1));
    }

    private void goToNorth() {
        setPoint(Point.of(this.point.x(), this.point.y() + 1));
    }

    private void goToWest() {
        setPoint(Point.of(this.point.x() - 1, this.point.y()));
    }

    private void goToEast() {
        setPoint(Point.of(this.point.x() + 1, this.point.y()));
    }
}
