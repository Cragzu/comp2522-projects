package ca.bcit.comp2522.assignments.a3;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class StackOverflowException extends Exception {
    /**
     * Constructs a StackOverflowException.
     * @param s a description of the exceptional situation.
     */
    public StackOverflowException(String s) {
        super(s);
    }
}
