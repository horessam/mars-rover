import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoverTest {
    private static final char FORWARD_COMMAND = 'F';
    private static final char BACKWARD_COMMAND = 'B';

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

}