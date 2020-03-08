package ca.bcit.comp2522.assignments.a3;

/**
 * Prime sum operation; calculates the sum of all prime numbers between two bounds.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class PrimeSumOperation extends AbstractOperation {
    /**The char code for the prime sum operation.*/
    static final char PRIME_SUM_CODE = '@';

    /**
     * Constructor - passes prime sum code to superclass.
     */
    public PrimeSumOperation() {
        super(PRIME_SUM_CODE);
    }

    /**
     * Determines whether or not a number is prime.
     *
     * @param num the number to check.
     * @return true if the number is prime, else false.
     */
    private boolean isPrime(final int num) {
        if (num < 2) { // any numbers below 2 are not prime
            return false;
        }
        for (int i = 2; i <= Math.round(Math.sqrt(num)); i++) {
            if (num % i == 0) { // num is divisible by something
                return false;
            }
        }
        return true;
    }

    /**
     * Performs a prime sum operation.
     * Calculates the sum of all prime numbers between the two params.
     *
     * @param operandA the first int
     * @param operandB the second int
     * @return the result of the operation
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        int result = 0;

        int largerOperand = Math.max(operandA, operandB);
        int smallerOperand = Math.min(operandA, operandB);

        for (int i = smallerOperand; i <= largerOperand; i++) {
            if (isPrime(i)) {
                result += i;
            }
        }
        return result;
    }

    /**
     * Generates a string representation of the object.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "PrimeSumOperation{}";
    }
}
