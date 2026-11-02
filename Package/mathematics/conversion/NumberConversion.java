package mathematics.conversion;

public class NumberConversion {
    public String decimalToBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String decimalToOctal(int number) {
        return Integer.toOctalString(number);
    }

    public String decimalToHexadecimal(int number) {
        return Integer.toHexString(number).toUpperCase();
    }
}