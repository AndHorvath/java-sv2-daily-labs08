package day05;

public class Position {

    // --- attributes ---------------------------------------------------------

    private int start;
    private int end;

    // --- constructors -------------------------------------------------------

    public Position(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // --- getters and setters ------------------------------------------------

    public int getStart() { return start; }
    public int getEnd() { return end; }

    // --- public methods -----------------------------------------------------

    public String getAsString(String line) {
        return line.substring(start, end).trim();
    }

    public int getAsNumber(String line) {
        try {
            return Integer.parseInt(getAsString(line));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Invalid number format.", exception);
        }
    }
}