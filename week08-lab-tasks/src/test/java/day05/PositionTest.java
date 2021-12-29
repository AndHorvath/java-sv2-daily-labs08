package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position position;
    String lineA;
    String lineB;
    IllegalArgumentException exception;

    @BeforeEach
    void setUp() {
        position = new Position(1, 2);
        lineA = "AB1";
        lineB = "A1B";
    }

    @Test
    void getStartTest() {
        assertEquals(1, position.getStart());
    }

    @Test
    void getEndTest() {
        assertEquals(2, position.getEnd());
    }

    @Test
    void getAsStringTest() {
        assertEquals("B", position.getAsString(lineA));
    }

    @Test
    void getAsNumberTest() {
        assertEquals(1, position.getAsNumber(lineB));

        exception = assertThrows(IllegalArgumentException.class, () -> position.getAsNumber(lineA));
        assertEquals("Invalid number format.", exception.getMessage());
    }
}