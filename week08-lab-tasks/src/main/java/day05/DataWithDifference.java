package day05;

public class DataWithDifference {

    // --- attributes ---------------------------------------------------------

    private String name;
    private int valueA;
    private int valueB;

    // --- constructors -------------------------------------------------------

    public DataWithDifference(String name, int valueA, int valueB) {
        this.name = name;
        this.valueA = valueA;
        this.valueB = valueB;
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public int getValueA() { return valueA; }
    public int getValueB() { return valueB; }

    // --- public methods -----------------------------------------------------

    public int getDifference() {
        return Math.abs(valueA - valueB);
    }
}