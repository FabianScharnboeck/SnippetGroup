public class FactorialExample {

    public static void main(String[] args) {
        int number = 5; // Number to calculate factorial for
        int result = factorial(number);

        System.out.println("Factorial of " + number + " is: " + result);
    }

    // Method to calculate factorial recursively
    public static int factorial(int n) {
        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            return n * factorial(n - 1); // Recursive call
        }
    }
}