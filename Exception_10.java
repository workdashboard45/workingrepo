public class ExceptionDemo {
    static void check() throws ArithmeticException {
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }

    public static void main(String[] args) {

        try {
            
            check();
			
            int arr[] = {10, 20, 30};
            System.out.println(arr[5]);
        }

        catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: Cannot divide by zero.");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Exception: Invalid array index.");
        }

        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        finally {
            System.out.println("Finally block is executed.");
        }
    }
}