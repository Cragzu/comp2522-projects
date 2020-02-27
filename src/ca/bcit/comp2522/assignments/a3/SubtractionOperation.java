package ca.bcit.comp2522.assignments.a3;

/**
 * Subtraction operation.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class SubtractionOperation extends AbstractOperation {
    private static final char SUBTRACTION_CODE = '-';

    /**
     * Constructor - passes subtraction code to superclass.
     */
    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA - operandB;
    }
}
