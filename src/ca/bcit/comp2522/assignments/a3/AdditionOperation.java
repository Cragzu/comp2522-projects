package ca.bcit.comp2522.assignments.a3;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class AdditionOperation extends AbstractOperation {
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
}
