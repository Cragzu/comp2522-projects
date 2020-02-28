package ca.bcit.comp2522.assignments.a3;

/**
 * Exception generated when Stack underflows.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class StackUnderflowException extends Exception {
    /**
     * Constructs a StackUnderflowException.
     * @param s a description of the exceptional situation.
     */
    public StackUnderflowException(String s) {
        super(s);
    }
}
