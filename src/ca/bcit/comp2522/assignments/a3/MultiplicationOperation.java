package ca.bcit.comp2522.assignments.a3;

/**
 * Multiplication operation.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class MultiplicationOperation extends AbstractOperation {
    /**The char code for the multiplication operation.*/
    static final char MULTIPLICATION_CODE = '*';

    /**
     * Constructor - passes multiplication code to superclass.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA * operandB;
    }

    /**
     * Generates a string representation of the object.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "MultiplicationOperation{}";
    }
}
