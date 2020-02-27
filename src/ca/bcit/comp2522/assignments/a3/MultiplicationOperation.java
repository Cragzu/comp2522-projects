package ca.bcit.comp2522.assignments.a3;

/**
 * Multiplication operation.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class MultiplicationOperation extends AbstractOperation {
    private static final char MULTIPLICATION_CODE = '*';

    /**
     * Constructor - passes multiplication code to superclass.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA * operandB;
    }
}
