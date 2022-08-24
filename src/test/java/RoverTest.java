import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoverTest {
    private static final char FORWARD_COMMAND = 'F';
    private static final char BACKWARD_COMMAND = 'B';
    private static final char TURN_RIGHT_COMMAND = 'R';
    private static final char TURN_LEFT_COMMAND = 'L';

    @Test
    public void should_ends_at_1_0_E_when_start_at_0_0_E_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.E);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 0), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_E_when_start_at_1_0_E_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 0), Direction.E);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_W_when_start_at_1_0_W_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 0), Direction.W);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_1_0_W_when_start_at_0_0_W_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.W);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(1, 0), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_1_N_when_start_at_0_0_N_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.N);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 1), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_N_when_start_at_0_1_N_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 1), Direction.N);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_S_when_start_at_0_1_S_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 1), Direction.S);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_1_S_when_start_at_0_0_S_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.S);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 1), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_E_when_start_at_0_0_N_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.N);

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_W_when_start_at_0_0_N_and_execute_left_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.N);

        //When
        rover.execute(TURN_LEFT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_S_when_start_at_0_0_E_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.E);

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.S, rover.getDirection());
    }

    @Test
    public void should_ends_at_0_0_N_when_start_at_0_0_E_and_execute_left_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.E);

        //When
        rover.execute(TURN_LEFT_COMMAND);

        //Then
        Assertions.assertEquals(Point.of(0, 0), rover.getPoint());
        Assertions.assertEquals(Direction.N, rover.getDirection());
    }

}
