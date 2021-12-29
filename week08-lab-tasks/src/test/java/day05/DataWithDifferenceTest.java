package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataWithDifferenceTest {

    DataWithDifference dataWithDifferenceA;
    DataWithDifference dataWithDifferenceB;

    @BeforeEach
    void setUp() {
        dataWithDifferenceA = new DataWithDifference("name", 1, 10);
        dataWithDifferenceB = new DataWithDifference("name", 10, 1);
    }

    @Test
    void getNameTest() {
        assertEquals("name", dataWithDifferenceA.getName());
    }

    @Test
    void getValueATest() {
        assertEquals(1, dataWithDifferenceA.getValueA());
    }

    @Test
    void getValueBTest() {
        assertEquals(10, dataWithDifferenceA.getValueB());
    }

    @Test
    void getDifferenceTest() {
        assertEquals(9, dataWithDifferenceA.getDifference());
        assertEquals(9, dataWithDifferenceB.getDifference());
    }
}