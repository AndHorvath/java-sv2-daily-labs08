package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureFileReaderTest {

    TemperatureFileReader temperatureFileReader;
    TemperatureFileReader other;
    String pathString;
    String fileName;
    IllegalStateException stateException;
    IllegalArgumentException argumentException;

    @BeforeEach
    void setUp() {
        pathString = "src/test/resources/datamunging/";
        fileName = "weather.dat";
        temperatureFileReader = new TemperatureFileReader(pathString, fileName);
    }

    @Test
    void getPathStringTest() {
        assertEquals("src/test/resources/datamunging/", temperatureFileReader.getPathString());
    }

    @Test
    void getFileNameTest() {
        assertEquals("weather.dat", temperatureFileReader.getFileName());
    }

    @Test
    void findSmallestDifferenceResultTest() {
        assertEquals(14, temperatureFileReader.findSmallestDifferenceResult());

        other = new TemperatureFileReader(pathString, "weather_.dat");
        stateException = assertThrows(IllegalStateException.class, () -> other.findSmallestDifferenceResult());
        assertEquals("Cannot read file.", stateException.getMessage());

        other = new TemperatureFileReader(pathString, "weatherinvalid.dat");
        argumentException = assertThrows(IllegalArgumentException.class, () -> other.findSmallestDifferenceResult());
        assertEquals("Invalid number format.", argumentException.getMessage());
    }

    @Test
    void getIndicesNotToConsiderTest() {
        assertArrayEquals(new Integer[] { 0, 1, 32 }, temperatureFileReader.getIndicesNotToConsider());
    }

    @Test
    void getNamePositionTest() {
        assertEquals(2, temperatureFileReader.getNamePosition().getStart());
        assertEquals(4, temperatureFileReader.getNamePosition().getEnd());
    }

    @Test
    void getValueAPositionTest() {
        assertEquals(6, temperatureFileReader.getValueAPosition().getStart());
        assertEquals(8, temperatureFileReader.getValueAPosition().getEnd());
    }

    @Test
    void getValueBPositionTest() {
        assertEquals(12, temperatureFileReader.getValueBPosition().getStart());
        assertEquals(14, temperatureFileReader.getValueBPosition().getEnd());
    }
}