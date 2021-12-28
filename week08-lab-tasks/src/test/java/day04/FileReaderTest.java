package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    FileReader fileReader;
    String pathString;
    IllegalStateException stateException;
    IllegalArgumentException argumentException;

    @BeforeEach
    void setUp() {
        pathString = "src/test/resources/datamunging/";
        fileReader = new FileReader(pathString);
    }

    @Test
    void getPathStringTest() {
        assertEquals("src/test/resources/datamunging/", fileReader.getPathString());
    }

    @Test
    void findSmallestTemperatureSpreadTest() {
        assertEquals(14, fileReader.findSmallestTemperatureSpread("weather.dat"));

        stateException = assertThrows(
            IllegalStateException.class, () -> fileReader.findSmallestTemperatureSpread("weather_.dat"));
        assertEquals("Cannot read file.", stateException.getMessage());

        argumentException = assertThrows(
            IllegalArgumentException.class, () -> fileReader.findSmallestTemperatureSpread("weatherinvalid.dat"));
        assertEquals("Invalid number format.", argumentException.getMessage());
    }

    @Test
    void findSmallestDifferenceTest() {
        assertEquals("Aston_Villa", fileReader.findSmallestDifference("football.dat"));

        stateException = assertThrows(
            IllegalStateException.class, () -> fileReader.findSmallestDifference("football_.dat"));
        assertEquals("Cannot read file.", stateException.getMessage());

        argumentException = assertThrows(
            IllegalArgumentException.class, () -> fileReader.findSmallestDifference("footballinvalid.dat"));
        assertEquals("Invalid number format.", argumentException.getMessage());
    }
}