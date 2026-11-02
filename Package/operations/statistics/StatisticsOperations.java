package operations.statistics;

public class StatisticsOperations {
    public double mean(int[] data) {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return (double) sum / data.length;
    }

    public int maximum(int[] data) {
        int max = data[0];
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public int minimum(int[] data) {
        int min = data[0];
        for (int value : data) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}