package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {

    // --- attributes ---------------------------------------------------------

    private List<Integer> sequence;
    private Random random;

    // --- constructors -------------------------------------------------------

    public NumberSequence(List<Integer> sequence) {
        this.sequence = sequence;
    }

    public NumberSequence(int numberOfMembers, int lowerBound, int upperBound, Random random) {
        this.random = random;

        sequence = new ArrayList<>();
        for (int i = 0; i < numberOfMembers; i++) {
            sequence.add(random.nextInt(lowerBound, upperBound + 1));
        }
    }

    // --- getters and setters ------------------------------------------------

    public List<Integer> getSequence() {
        return sequence;
    }

    // --- public methods -----------------------------------------------------

    public List<Integer> closeToAverage(int value) {
        List<Integer> closeNeighbours = new ArrayList<>();
        for (int member : sequence) {
            if (isInNeighbourhoodOf(member, getAverage(sequence), value)) {
                closeNeighbours.add(member);
            }
        }
        return closeNeighbours;
    }

    // --- private methods ----------------------------------------------------

    private double getAverage(List<Integer> sequence) {
        if (sequence.size() == 0) {
            return 0.0;
        }
        return getSum(sequence) / (double) sequence.size();
    }

    private int getSum(List<Integer> sequence) {
        int sum = 0;
        for (int member : sequence) {
            sum += member;
        }
        return sum;
    }

    private boolean isInNeighbourhoodOf(double value, double point, double neighbourhood) {
        double epsilon = Math.pow(10.0, -5.0);
        return Math.abs(point - value) < neighbourhood + epsilon;
    }
}