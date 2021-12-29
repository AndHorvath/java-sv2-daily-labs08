package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractFileReader {

    // --- attributes ---------------------------------------------------------

    private String pathString;
    private String fileName;

    // --- constructors -------------------------------------------------------

    public AbstractFileReader(String pathString, String fileName) {
        this.pathString = pathString;
        this.fileName = fileName;
    }

    // --- getters and setters ------------------------------------------------

    public String getPathString() { return pathString; }
    public String getFileName() { return fileName; }

    // --- public methods -----------------------------------------------------

    public String findSmallestDifferenceName() {
        List<String> linesInFile = readFile();
        linesInFile = filterLines(linesInFile, getIndicesNotToConsider());
        List<DataWithDifference> teamData =
            extractData(linesInFile, getNamePosition(), getValueAPosition(), getValueBPosition());
        return findMinimalDifference(teamData).getName();
    }

    // --- protected methods --------------------------------------------------

    protected abstract Integer[] getIndicesNotToConsider();

    protected abstract Position getNamePosition();

    protected abstract Position getValueAPosition();

    protected abstract Position getValueBPosition();

    // --- private methods ----------------------------------------------------

    private List<String> readFile() {
        try {
            return Files.readAllLines(createPath());
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read file.", exception);
        }
    }

    private Path createPath() {
        return Path.of(pathString.concat(fileName));
    }

    private List<String> filterLines(List<String> lines, Integer... indicesNotToConsider) {
        List<String> filteredLinesInFile = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (!Arrays.asList(indicesNotToConsider).contains(i)) {
                filteredLinesInFile.add(lines.get(i));
            }
        }
        return filteredLinesInFile;
    }

    private List<DataWithDifference> extractData(
        List<String> lines, Position namePosition, Position valueAPosition, Position valueBPosition) {

        List<DataWithDifference> dataWithDifferenceList = new ArrayList<>();
        for (String line : lines) {
            dataWithDifferenceList.add(
                createDataWithDifference(line, namePosition, valueAPosition, valueBPosition));
        }
        return dataWithDifferenceList;
    }

    private DataWithDifference createDataWithDifference(
        String line, Position namePosition, Position valueAPosition, Position valueBPosition) {
        return new DataWithDifference(
            namePosition.getAsString(line), valueAPosition.getAsNumber(line), valueBPosition.getAsNumber(line));
    }

    private DataWithDifference findMinimalDifference(List<DataWithDifference> dataList) {
        DataWithDifference dataWithMinimalDifference = dataList.get(0);
        for (DataWithDifference data : dataList) {
            if (data.getDifference() < dataWithMinimalDifference.getDifference()) {
                dataWithMinimalDifference = data;
            }
        }
        return dataWithMinimalDifference;
    }
}