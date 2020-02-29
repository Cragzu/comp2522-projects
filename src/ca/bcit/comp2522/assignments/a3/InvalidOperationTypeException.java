package ca.bcit.comp2522.assignments.a3;

/**
 * Exception generated when an unknown operation type is encountered.
 * 
 * @author Chloe Glave
 * @version 2020
 */
public class InvalidOperationTypeException extends Exception {
    /**
     * Constructs a InvalidOperationTypeException.
     * @param s a description of the exceptional situation.
     * @param symbol the unknown operation.
     */
    public InvalidOperationTypeException(String s, char symbol) {
        super(s);
        System.out.println("Received unknown symbol: " + symbol);
    }
}
