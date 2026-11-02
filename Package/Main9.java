import mathematics.statistics.Statistics;
import mathematics.conversion.NumberConversion;

public class Main9 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        Statistics statistics = new Statistics();
        NumberConversion conversion = new NumberConversion();

        System.out.println("Statistical Operations");
        System.out.println("----------------------");
        System.out.println("Mean = " + statistics.mean(numbers));

        int number = 25;
        System.out.println("\nNumber System Conversion");
        System.out.println("------------------------");
        System.out.println("Decimal = " + number);
        System.out.println("Binary = " + conversion.decimalToBinary(number));
        System.out.println("Octal = " + conversion.decimalToOctal(number));
        System.out.println("Hexadecimal = " + conversion.decimalToHexadecimal(number));
    }
}