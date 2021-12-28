package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    // --- attributes ---------------------------------------------------------

    private String pathString;

    // --- constructors -------------------------------------------------------

    public FileReader(String pathString) {
        this.pathString = pathString;
    }

    // --- getters and setters ------------------------------------------------

    public String getPathString() { return pathString; }

    // --- public methods -----------------------------------------------------

    public int findSmallestTemperatureSpread(String fileName) {
        List<String> linesInFile = readFile(createPath(fileName));
        List<Integer> indicesNotToConsider = Arrays.asList(0, 1, 32);
        int[] boundsDay = new int[] { 2, 4 };
        int[] boundsMax = new int[] { 6, 8 };
        int[] boundsMin = new int[] { 12, 14 };

        return getResultDay(linesInFile, indicesNotToConsider, boundsDay, boundsMax, boundsMin);
    }

    public String findSmallestDifference(String fileName) {
        List<String> linesInFile = readFile(createPath(fileName));
        List<Integer> indicesNotToConsider = Arrays.asList(0, 18);
        int[] boundsName = new int[] { 7, 23 };
        int[] boundsGoalsFor = new int[] { 43, 45 };
        int[] boundsGoalsAgainst = new int[] { 50, 52 };

        return getResultTeam(
            linesInFile, indicesNotToConsider, boundsName, boundsGoalsFor, boundsGoalsAgainst);
    }

    // --- private methods ----------------------------------------------------

    private int getResultDay(
        List<String> linesInFile, List<Integer> indicesNotToConsider,
        int[] boundsDay, int[] boundsMax, int[] boundsMin) {

        int smallestTemperatureSpread = Integer.MAX_VALUE;
        int actualTemperatureSpread;
        int resultDay = 0;
        String actualLine;
        for (int i = 0; i < linesInFile.size(); i++) {
            if (indicesNotToConsider.contains(i)) {
                continue;
            }
            actualLine = linesInFile.get(i);
            actualTemperatureSpread = getSpread(actualLine, boundsMax, boundsMin);
            if (actualTemperatureSpread < smallestTemperatureSpread) {
                smallestTemperatureSpread = actualTemperatureSpread;
                resultDay = getDayNumber(actualLine, boundsDay);
            }
        }
        return resultDay;
    }

    private String getResultTeam(
        List<String> linesInFile, List<Integer> indicesNotToConsider,
        int[] boundsName, int[] boundsGoalsFor, int[] boundsGoalsAgainst) {

        int smallestDifference = Integer.MAX_VALUE;
        int actualDifference;
        String resultTeam = "";
        String actualLine;
        for (int i = 0; i < linesInFile.size(); i++) {
            if (indicesNotToConsider.contains(i)) {
                continue;
            }
            actualLine = linesInFile.get(i);
            actualDifference = getDifference(actualLine, boundsGoalsFor, boundsGoalsAgainst);
            if (actualDifference < smallestDifference) {
                smallestDifference = actualDifference;
                resultTeam = getTeamName(actualLine, boundsName);
            }
        }
        return resultTeam;
    }

    private Path createPath(String fileName) {
        return Path.of(pathString.concat(fileName));
    }

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read file.", exception);
        }
    }

    private int getDayNumber(String line, int[] boundsDay) {
        try {
            return Integer.parseInt(line.substring(boundsDay[0], boundsDay[1]).trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(createNumberFormatExceptionMessage(), exception);
        }
    }

    private String getTeamName(String line, int[] boundsName) {
        return line.substring(boundsName[0], boundsName[1]).trim();
    }

    private int getSpread(String line, int[] boundsMax, int[] boundsMin) {
        try {
            return
                Integer.parseInt(line.substring(boundsMax[0], boundsMax[1]).trim()) -
                Integer.parseInt(line.substring(boundsMin[0], boundsMin[1]).trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(createNumberFormatExceptionMessage(), exception);
        }
    }

    private int getDifference(String line, int[] boundsGoalsFor, int[] boundsGoalsAgainst) {
        try {
            return
                Math.abs(
                    Integer.parseInt(line.substring(boundsGoalsFor[0], boundsGoalsFor[1]).trim()) -
                    Integer.parseInt(line.substring(boundsGoalsAgainst[0], boundsGoalsAgainst[1]).trim()));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(createNumberFormatExceptionMessage(), exception);
        }
    }

    private String createNumberFormatExceptionMessage() {
        return "Invalid number format.";
    }
}