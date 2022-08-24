package marsrover;

import java.util.List;

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
    private final List<Point> obstacles;
    private Point point;
    private Direction direction;

    public Rover(Point point, Direction direction, Point limit, List<Point> obstacles) {
        this.point = point;
        this.direction = direction;
        this.limit = limit;
        this.obstacles = obstacles;
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
            default -> throw new IllegalStateException("Unexpected value: " + command);
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
        Point newPoint;
        if (y > 1) {
            newPoint = Point.of(x, y - 1);
        } else {
            newPoint = Point.of(limitX, y);
        }
        if (!hasObstacle(newPoint)) {
            setPoint(newPoint);
        }
    }

    private void goToNorth() {
        int x = this.point.x();
        int y = this.point.y();
        int limitY = this.limit.y();
        Point newPoint;
        if (y < limitY) {
            newPoint = Point.of(x, y+1);
        } else {
            newPoint = Point.of(1, 1);
        }
        if (!hasObstacle(newPoint)) {
            setPoint(newPoint);
        }
    }

    private void goToWest() {
        int x = this.point.x();
        int y = this.point.y();
        int limitX = this.limit.x();
        Point newPoint;
        if (x > 1) {
            newPoint = Point.of(x - 1, y);
        } else {
            newPoint = Point.of(limitX, y);
        }
        if (!hasObstacle(newPoint)) {
            setPoint(newPoint);
        }
    }

    private void goToEast() {
        int x = this.point.x();
        int y = this.point.y();
        int limitX = this.limit.x();
        Point newPoint;
        if (x < limitX) {
            newPoint = Point.of(x + 1, y);
        } else {
            newPoint = Point.of(1, y);
        }
        if (!hasObstacle(newPoint)) {
            setPoint(newPoint);
        }
    }

    private boolean hasObstacle(Point roverNewPoint) {
        for (Point obstacle : obstacles)
            if (obstacle.equals(roverNewPoint)) {
                return true;
            }
        return false;
    }
}
