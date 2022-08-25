package marsrover;

import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoverTest {
    private static final String FORWARD_COMMAND = "F";
    private static final String BACKWARD_COMMAND = "B";
    private static final String TURN_RIGHT_COMMAND = "R";
    private static final String TURN_LEFT_COMMAND = "L";

    private final Point maxPoint = Point.of(5, 5);
    private final List<Point> obstacles = new ArrayList<>(Arrays.asList(Point.of(1, 2), Point.of(3, 1)));

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void should_ends_at_1_0_E_when_start_at_0_0_E_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.E, maxPoint);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 0), Direction.E, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_5_0_E_when_start_at_1_0_E_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 0), Direction.E, maxPoint);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(5, 0), Direction.E, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_5_0_W_when_start_at_1_0_W_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 0), Direction.W, maxPoint);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(5, 0), Direction.W, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_1_0_W_when_start_at_0_0_W_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.W, maxPoint);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 0), Direction.W, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_1_N_when_start_at_0_0_N_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.N, maxPoint);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 1), Direction.N, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_1_S_when_start_at_0_0_S_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.S, maxPoint);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 1), Direction.S, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_0_E_when_start_at_0_0_N_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.N, maxPoint);

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 0), Direction.E, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_0_W_when_start_at_0_0_N_and_execute_left_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.N, maxPoint);

        //When
        rover.execute(TURN_LEFT_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 0), Direction.W, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_0_S_when_start_at_0_0_E_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.E, maxPoint);

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 0), Direction.S, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_0_N_when_start_at_0_0_E_and_execute_left_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.E, maxPoint);

        //When
        rover.execute(TURN_LEFT_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 0), Direction.N, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_0_W_when_start_at_0_0_S_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.S, maxPoint);

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 0), Direction.W, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_0_E_when_start_at_0_0_S_and_execute_left_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.S, maxPoint);

        //When
        rover.execute(TURN_LEFT_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 0), Direction.E, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_0_N_when_start_at_0_0_W_and_execute_right_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.W, maxPoint);

        //When
        rover.execute(TURN_RIGHT_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 0), Direction.N, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_0_0_S_when_start_at_0_0_W_and_execute_left_command() {
        //Given
        Rover rover = new Rover(Point.of(0, 0), Direction.W, maxPoint);

        //When
        rover.execute(TURN_LEFT_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(0, 0), Direction.S, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_1_1_E_when_start_at_5_1_E_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(5, 1), Direction.E, maxPoint);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 1), Direction.E, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_1_1_E_when_start_at_5_1_E_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.E, maxPoint);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(5, 1), Direction.E, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_5_1_W_when_start_at_1_1_W_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.W, maxPoint);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(5, 1), Direction.W, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_2_1_W_when_start_at_3_1_W_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(3, 1), Direction.W, maxPoint);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(2, 1), Direction.W, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_1_1_W_when_start_at_5_1_W_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(5, 1), Direction.W, maxPoint);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 1), Direction.W, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_5_1_S_when_start_at_1_1_S_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.S, maxPoint);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(5, 1), Direction.S, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_5_1_N_when_start_at_1_1_N_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.N, maxPoint);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(5, 1), Direction.N, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_1_1_N_when_start_at_1_5_N_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 5), Direction.N, maxPoint);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 1), Direction.N, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_1_1_S_when_start_at_1_5_S_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 5), Direction.S, maxPoint);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 1), Direction.S, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_1_1_S_when_start_at_1_2_S_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 2), Direction.S, maxPoint);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 1), Direction.S, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_stop_at_1_1_N_when_start_at_1_1_N_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.N, maxPoint, obstacles);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 1), Direction.N, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
        Assertions.assertEquals("Obstacle reported at: Point {x=1, y=2}", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_stop_at_1_1_S_when_start_at_1_3_S_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.S, maxPoint, obstacles);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 1), Direction.S, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
        Assertions.assertEquals("Obstacle reported at: Point {x=1, y=2}", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_stop_at_2_1_E_when_start_at_2_1_E_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(2, 1), Direction.E, maxPoint, obstacles);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(2, 1), Direction.E, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
        Assertions.assertEquals("Obstacle reported at: Point {x=3, y=1}", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_stop_at_2_1_W_when_start_at_2_1_W_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(2, 1), Direction.W, maxPoint, obstacles);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(2, 1), Direction.W, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
        Assertions.assertEquals("Obstacle reported at: Point {x=3, y=1}", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_stop_at_1_3_S_when_start_at_1_3_S_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 3), Direction.S, maxPoint, obstacles);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 3), Direction.S, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
        Assertions.assertEquals("Obstacle reported at: Point {x=1, y=2}", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_stop_at_1_3_N_when_start_at_1_3_N_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(1, 3), Direction.N, maxPoint, obstacles);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(1, 3), Direction.N, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
        Assertions.assertEquals("Obstacle reported at: Point {x=1, y=2}", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_stop_at_4_1_W_when_start_at_4_1_W_and_execute_forward_command() {
        //Given
        Rover rover = new Rover(Point.of(4, 1), Direction.W, maxPoint, obstacles);

        //When
        rover.execute(FORWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(4, 1), Direction.W, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
        Assertions.assertEquals("Obstacle reported at: Point {x=3, y=1}", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_stop_at_4_1_E_when_start_at_4_1_E_and_execute_backward_command() {
        //Given
        Rover rover = new Rover(Point.of(4, 1), Direction.E, maxPoint, obstacles);

        //When
        rover.execute(BACKWARD_COMMAND);

        //Then
        Rover expectedRover = new Rover(Point.of(4, 1), Direction.E, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
        Assertions.assertEquals("Obstacle reported at: Point {x=3, y=1}", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_return_exception_when_command_does_not_exist() {
        // Given
        Rover rover = new Rover(Point.of(4, 1), Direction.E, maxPoint, obstacles);

        // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> rover.execute("Z"));
    }

    @Test
    public void should_ends_at_1_3_N_when_start_at_1_1_N_and_execute_sequence_command_FFF() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.N, maxPoint);

        //When
        rover.execute("FFF");

        //Then
        Rover expectedRover = new Rover(Point.of(1, 4), Direction.N, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

    @Test
    public void should_ends_at_4_2_E_when_start_at_1_1_N_and_execute_sequence_command_() {
        //Given
        Rover rover = new Rover(Point.of(1, 1), Direction.N, maxPoint);

        //When
        rover.execute("LBBLBLF");

        //Then
        Rover expectedRover = new Rover(Point.of(4, 2), Direction.E, maxPoint);
        Assertions.assertEquals(expectedRover, rover);
    }

}
