package ca.bcit.comp2522.assignments.a3;

/**
 * Parent class for various types of operations.
 *
 * @author Chloe Glave
 * @version 2020
 */
public abstract class AbstractOperation implements Operation {
     /**The type of operation to be used; add, subtract, multiply, or divide.*/
    protected char operationType;

    /**
     * Constructor.
     *
     * @param operationType char - the type of operation to be performed.
     */
    public AbstractOperation(final char operationType) {
        this.operationType = operationType;
    }

    /**
     * Gets the char representing the operation type.
     *
     * @return char - the operation to be performed.
     */
    public final char getSymbol() {
        return operationType;
    }
}
