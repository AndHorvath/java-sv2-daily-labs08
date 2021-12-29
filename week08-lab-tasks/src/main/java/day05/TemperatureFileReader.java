package day05;

public class TemperatureFileReader extends AbstractFileReader {

    // --- constructors -------------------------------------------------------

    public TemperatureFileReader(String pathString, String fileName) {
        super(pathString, fileName);
    }

    // --- public methods -----------------------------------------------------

    public int findSmallestDifferenceResult() {
        try {
            return Integer.parseInt(findSmallestDifferenceName());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Invalid number format.", exception);
        }
    }

    // --- protected methods --------------------------------------------------

    @Override
    protected Integer[] getIndicesNotToConsider() {
        return new Integer[] { 0, 1, 32 };
    }

    @Override
    protected Position getNamePosition() {
        return new Position(2, 4);
    }

    @Override
    protected Position getValueAPosition() {
        return new Position(6, 8);
    }

    @Override
    protected Position getValueBPosition() {
        return new Position(12, 14);
    }
}