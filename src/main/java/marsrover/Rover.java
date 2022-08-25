package marsrover;

import java.util.Collections;
import java.util.List;

import static marsrover.Direction.*;

public class Rover {
    private static final char FORWARD_COMMAND = 'F';
    private static final char BACKWARD_COMMAND = 'B';
    private static final char TURN_RIGHT_COMMAND = 'R';
    private static final char TURN_LEFT_COMMAND = 'L';

    private final Point maxPoint;
    private final List<Point> obstacles;

    private Point point;
    private Direction direction;

    public Rover(Point point, Direction direction, Point maxPoint, List<Point> obstacles) {
        this.point = point;
        this.direction = direction;
        this.maxPoint = maxPoint;
        this.obstacles = obstacles;
    }

    public Rover(Point point, Direction direction, Point maxPoint) {
        this.point = point;
        this.direction = direction;
        this.maxPoint = maxPoint;
        this.obstacles = Collections.emptyList();
    }

    public Point getPoint() {
        return point;
    }

    private void setPoint(Point point) {
        if (!hasObstacle(point)) {
            this.point = point;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void execute(String sequenceCommand) {
        for (int i = 0; i < sequenceCommand.length(); i++) {
            execute(sequenceCommand.charAt(i));
        }
    }

    private void execute(char command) {
        switch (command) {
            case FORWARD_COMMAND -> forward();
            case BACKWARD_COMMAND -> backward();
            case TURN_RIGHT_COMMAND -> turnRight();
            case TURN_LEFT_COMMAND -> turnLeft();
            default -> throw new IllegalArgumentException("Unexpected value: " + command);
        }
    }

    private void turnLeft() {
        setDirection(switch (this.direction) {
            case N -> W;
            case E -> N;
            case S -> E;
            case W -> S;
        });
    }

    private void turnRight() {
        setDirection(switch (this.direction) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        });
    }

    private void forward() {
        switch (this.direction) {
            case E -> goToEast();
            case W -> goToWest();
            case N -> goToNorth();
            case S -> goToSouth();
        }
    }

    private void backward() {
        switch (this.direction) {
            case E -> goToWest();
            case W -> goToEast();
            case N -> goToSouth();
            case S -> goToNorth();
        }
    }

    private void goToSouth() {
        int y = this.point.y();
        Point newPoint = y > 1 ? Point.of(this.point.x(), y - 1) : Point.of(this.maxPoint.x(), y);
        setPoint(newPoint);
    }

    private void goToNorth() {
        int y = this.point.y();
        Point newPoint = y < this.maxPoint.y() ? Point.of(this.point.x(), y + 1) : Point.of(1, 1);
        setPoint(newPoint);
    }

    private void goToWest() {
        int x = this.point.x();
        Point newPoint = x > 1 ? Point.of(x - 1, this.point.y()) : Point.of(this.maxPoint.x(), this.point.y());
        setPoint(newPoint);
    }

    private void goToEast() {
        int x = this.point.x();
        Point newPoint = x < this.maxPoint.x() ? Point.of(x + 1, this.point.y()) : Point.of(1, this.point.y());
        setPoint(newPoint);
    }

    private boolean hasObstacle(Point point) {
        return obstacles.stream().anyMatch(obstacle -> obstacle.equals(point));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return getPoint().equals(rover.getPoint()) && getDirection() == rover.getDirection();
    }
}
