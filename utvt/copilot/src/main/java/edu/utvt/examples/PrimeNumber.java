package edu.utvt.examples;

public class PrimeNumber {

    /**
     * Checks if the given number is a prime number.
     * @param number the number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        int testNumber = 17;
        System.out.println(testNumber + " is prime? " + isPrime(testNumber));
    }
}