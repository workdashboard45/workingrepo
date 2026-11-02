import operations.math.MathOperations;
import operations.statistics.StatisticsOperations;

public class Main14 {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();
        StatisticsOperations stats = new StatisticsOperations();

        int a = 20;
        int b = 10;

        System.out.println("Mathematical Operations:");
        System.out.println("Addition = " + math.add(a, b));
        System.out.println("Subtraction = " + math.subtract(a, b));
        System.out.println("Multiplication = " + math.multiply(a, b));
        System.out.println("Division = " + math.divide(a, b));

        int[] data = {10, 20, 30, 40, 50};

        System.out.println("\nStatistical Operations:");
        System.out.println("Mean = " + stats.mean(data));
        System.out.println("Maximum = " + stats.maximum(data));
        System.out.println("Minimum = " + stats.minimum(data));
    }
}