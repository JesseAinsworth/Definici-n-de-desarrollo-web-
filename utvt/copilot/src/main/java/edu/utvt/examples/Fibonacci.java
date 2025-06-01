package edu.utvt.examples;

//create a class named Fibonacci
// That contains a method to calculate the nth Fibonacci number
public class Fibonacci {
    /**
     * Calculates the nth Fibonacci number.
     * @param n the position in the Fibonacci sequence (0-based)
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // Example usage
    public static void main(String[] args) {
        int n = 10; // Change this value to compute a different Fibonacci number
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }

}
