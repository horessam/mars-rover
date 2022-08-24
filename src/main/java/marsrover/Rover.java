package marsrover;

import static marsrover.Direction.E;
import static marsrover.Direction.N;
import static marsrover.Direction.S;
import static marsrover.Direction.W;

public class Rover {
    public static final char FORWARD_COMMAND = 'F';
    private static final char BACKWARD_COMMAND = 'B';
    private static final char TURN_RIGHT_COMMAND = 'R';
    private static final char TURN_LEFT_COMMAND = 'L';
    private final Point limit;
    private Point point;
    private Direction direction;

    public Rover(Point point, Direction direction, Point limit) {
        this.point = point;
        this.direction = direction;
        this.limit = limit;
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
            case FORWARD_COMMAND -> forward();
            case BACKWARD_COMMAND -> backward();
            case TURN_RIGHT_COMMAND -> turnRight();
            case TURN_LEFT_COMMAND -> turnLeft();
        }
    }

    private void turnLeft() {
        switch (this.direction) {
            case N -> setDirection(W);
            case E -> setDirection(N);
            case S -> setDirection(E);
        }
    }

    private void turnRight() {
        setDirection(switch (this.direction) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        });
    }

    private void backward() {
        switch (this.direction) {
            case E -> goToWest();
            case W -> goToEast();
            case N -> goToSouth();
            case S -> goToNorth();
        }
    }

    private void forward() {
        switch (this.direction) {
            case E -> goToEast();
            case W -> goToWest();
            case N -> goToNorth();
            case S -> goToSouth();
        }
    }

    private void goToSouth() {
        int x = this.point.x();
        int y = this.point.y();
        int limitX = this.limit.x();
        if (y > 1) {
            setPoint(Point.of(x, y - 1));
        } else {
            setPoint(Point.of(limitX, y));
        }
    }

    private void goToNorth() {
        int x = this.point.x();
        int y = this.point.y();
        int limitY = this.limit.y();
        if (y < limitY) {
            setPoint(Point.of(x, y + 1));
        } else {
            setPoint(Point.of(1, 1));
        }
    }

    private void goToWest() {
        int x = this.point.x();
        int y = this.point.y();
        int limitX = this.limit.x();
        if (x > 1) {
            setPoint(Point.of(x - 1, y));
        } else {
            setPoint(Point.of(limitX, y));
        }
    }

    private void goToEast() {
        int x = this.point.x();
        int y = this.point.y();
        int limitX = this.limit.x();
        if (x < limitX) {
            setPoint(Point.of(x + 1, y));
        } else {
            setPoint(Point.of(1, y));
        }
    }
}
