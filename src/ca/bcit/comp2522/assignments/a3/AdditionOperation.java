package ca.bcit.comp2522.assignments.a3;

/**
 * Addition operation.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class AdditionOperation extends AbstractOperation {
    /**The char code for the addition operation.*/
    private static final char ADDITION_CODE = '+';

    /**
     * Constructor - passes addition code to superclass.
     */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA + operandB;
    }

    /**
     * Generates a string representation of the object.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "AdditionOperation{}";
    }
}
