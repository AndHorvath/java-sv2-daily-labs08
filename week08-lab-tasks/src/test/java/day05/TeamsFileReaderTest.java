package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TeamsFileReaderTest {

    TeamsFileReader teamsFileReader;
    TeamsFileReader other;
    String pathString;
    String fileName;
    IllegalStateException stateException;
    IllegalArgumentException argumentException;

    @BeforeEach
    void setUp() {
        pathString = "src/test/resources/datamunging/";
        fileName = "football.dat";
        teamsFileReader = new TeamsFileReader(pathString, fileName);
    }

    @Test
    void getPathStringTest() {
        assertEquals("src/test/resources/datamunging/", teamsFileReader.getPathString());
    }

    @Test
    void getFileNameTest() {
        assertEquals("football.dat", teamsFileReader.getFileName());
    }

    @Test
    void findSmallestDifferenceResultTest() {
        assertEquals("Aston_Villa", teamsFileReader.findSmallestDifferenceResult());

        other = new TeamsFileReader(pathString, "football_.dat");
        stateException = assertThrows(IllegalStateException.class, () -> other.findSmallestDifferenceResult());
        assertEquals("Cannot read file.", stateException.getMessage());

        other = new TeamsFileReader(pathString, "footballinvalid.dat");
        argumentException = assertThrows(IllegalArgumentException.class, () -> other.findSmallestDifferenceResult());
        assertEquals("Invalid number format.", argumentException.getMessage());
    }

    @Test
    void getIndicesNotToConsiderTest() {
        assertArrayEquals(new Integer[] { 0, 18 }, teamsFileReader.getIndicesNotToConsider());
    }

    @Test
    void getNamePositionTest() {
        assertEquals(7, teamsFileReader.getNamePosition().getStart());
        assertEquals(23, teamsFileReader.getNamePosition().getEnd());
    }

    @Test
    void getValueAPositionTest() {
        assertEquals(43, teamsFileReader.getValueAPosition().getStart());
        assertEquals(45, teamsFileReader.getValueAPosition().getEnd());
    }

    @Test
    void getValueBPositionTest() {
        assertEquals(50, teamsFileReader.getValueBPosition().getStart());
        assertEquals(52, teamsFileReader.getValueBPosition().getEnd());
    }
}