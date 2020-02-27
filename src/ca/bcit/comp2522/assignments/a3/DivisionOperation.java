package ca.bcit.comp2522.assignments.a3;

/**
 * Division operation.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class DivisionOperation extends AbstractOperation {
    private static final char DIVISION_CODE = '/';

    /**
     * Constructor - passes division code to superclass.
     */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA / operandB;
    }
}
