package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {

    NumberSequence sequenceA;
    NumberSequence sequenceB;
    Random random;

    @BeforeEach
    void setUp() {
        random = new Random(100);
        sequenceA = new NumberSequence(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        sequenceB = new NumberSequence(9, 1, 10, random);
    }

    @Test
    void getSequenceTest() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), sequenceA.getSequence());
        assertEquals(Arrays.asList(6, 1, 5, 9, 2, 7, 7, 9, 4), sequenceB.getSequence());
    }

    @Test
    void closeToAverageTest() {
        assertEquals(Arrays.asList(3, 4, 5, 6, 7), sequenceA.closeToAverage(2));
        assertEquals(Arrays.asList(6, 5, 7, 7, 4), sequenceB.closeToAverage(2));
    }
}