package ca.bcit.comp2522.assignments.a3;

/**
 * Division operation.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class DivisionOperation extends AbstractOperation {
    /**The char code for the division operation.*/
    static final char DIVISION_CODE = '/';

    /**
     * Constructor - passes division code to superclass.
     */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA / operandB;
    }

    /**
     * Generates a string representation of the object.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "DivisionOperation{}";
    }
}
