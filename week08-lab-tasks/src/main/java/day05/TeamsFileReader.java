package day05;

public class TeamsFileReader extends AbstractFileReader {

    // --- constructors -------------------------------------------------------

    public TeamsFileReader(String pathString, String fileName) {
        super(pathString, fileName);
    }

    // --- public methods -----------------------------------------------------

    public String findSmallestDifferenceResult() {
        return super.findSmallestDifferenceName();
    }

    // --- protected methods --------------------------------------------------

    @Override
    protected Integer[] getIndicesNotToConsider() {
        return new Integer[] { 0, 18 };
    }

    @Override
    protected Position getNamePosition() {
        return new Position(7, 23);
    }

    @Override
    protected Position getValueAPosition() {
        return new Position(43, 45);
    }

    @Override
    protected Position getValueBPosition() {
        return new Position(50, 52);
    }
}