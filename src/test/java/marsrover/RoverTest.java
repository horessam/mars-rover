package marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoverTest {
    private static final char FORWARD_COMMAND = 'F';
    private static final char BACKWARD_COMMAND = 'B';
    private static final char TURN_RIGHT_COMMAND = 'R';
    private static final char TURN_LEFT_COMMAND = 'L';

    private final Point limit = Point.of(5, 5);

    private final List<Point> obstacles = new ArrayList<>(Arrays.asList(Point.of(1, 2), Point.of(3, 1)));

    @Test
    public void should_ends_at_1_0_E_when_start_at_0_0_E_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.E, limit, Collections.emptyList());

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 0), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_ends_at_5_0_E_when_start_at_1_0_E_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 0), Direction.E, limit, Collections.emptyList());

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(5, 0), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_ends_at_5_0_W_when_start_at_1_0_W_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 0), Direction.W, limit, Collections.emptyList());

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(5, 0), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_1_0_W_when_start_at_0_0_W_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.W, limit, Collections.emptyList());

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 0), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_1_N_when_start_at_0_0_N_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.N, limit, Collections.emptyList());

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 1), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_1_S_when_start_at_0_0_S_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.S, limit, Collections.emptyList());

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 1), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_E_when_start_at_0_0_N_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.N, limit, Collections.emptyList());

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_W_when_start_at_0_0_N_and_execute_left_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.N, limit, Collections.emptyList());

        //When
        rover.execute(TURN_LEFT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_S_when_start_at_0_0_E_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.E, limit, Collections.emptyList());

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_N_when_start_at_0_0_E_and_execute_left_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.E, limit, Collections.emptyList());

        //When
        rover.execute(TURN_LEFT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_W_when_start_at_0_0_S_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.S, limit, Collections.emptyList());

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_E_when_start_at_0_0_S_and_execute_left_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.S, limit, Collections.emptyList());

        //When
        rover.execute(TURN_LEFT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_N_when_start_at_0_0_W_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.W, limit, Collections.emptyList());

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void should_ends_at_1_1_E_when_start_at_5_1_E_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(5, 1), Direction.E, limit, Collections.emptyList());

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 1), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_ends_at_1_1_E_when_start_at_5_1_E_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.E, limit, Collections.emptyList());

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(5, 1), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_ends_at_5_1_W_when_start_at_1_1_W_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.W, limit, Collections.emptyList());

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(5, 1), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_2_1_W_when_start_at_3_1_W_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(3, 1), Direction.W, limit, Collections.emptyList());

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(2, 1), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_1_1_W_when_start_at_5_1_W_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(5, 1), Direction.W, limit, Collections.emptyList());

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 1), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_5_1_S_when_start_at_1_1_S_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.S, limit, Collections.emptyList());

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(5, 1), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_ends_at_5_1_N_when_start_at_1_1_N_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.N, limit, Collections.emptyList());

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(5, 1), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void should_ends_at_1_1_N_when_start_at_1_5_N_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 5), Direction.N, limit, Collections.emptyList());

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 1), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void should_ends_at_1_1_S_when_start_at_1_5_S_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 5), Direction.S, limit, Collections.emptyList());

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 1), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_ends_at_1_1_S_when_start_at_1_2_S_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 2), Direction.S, limit, Collections.emptyList());

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 1), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_stop_at_1_1_N_when_start_at_1_1_N_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.N, limit, obstacles);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 1), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void should_stop_at_1_1_S_when_start_at_1_3_S_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.S, limit, obstacles);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 1), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_stop_at_2_1_E_when_start_at_2_1_E_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(2, 1), Direction.E, limit, obstacles);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(2, 1), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_stop_at_2_1_W_when_start_at_2_1_W_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(2, 1), Direction.W, limit, obstacles);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(2, 1), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_stop_at_1_3_S_when_start_at_1_3_S_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 3), Direction.S, limit, obstacles);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 3), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_stop_at_1_3_N_when_start_at_1_3_N_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 3), Direction.N, limit, obstacles);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 3), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void should_stop_at_4_1_W_when_start_at_4_1_W_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(4, 1), Direction.W, limit, obstacles);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(4, 1), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_stop_at_4_1_E_when_start_at_4_1_E_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(4, 1), Direction.E, limit, obstacles);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(4, 1), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

}
