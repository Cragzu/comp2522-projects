package ca.bcit.comp2522.assignments.a3;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class RPNCalculator {
    /**The minimum possible size a stack can be.*/
    static final int MIN_STACK_SIZE = 2;

    private Stack stack;

    /**
     * Constructs a new RPNCalculator with the specified size.
     *
     * @param stackSize int - the size of the calculator's stack.
     * @throws IllegalArgumentException when the given stackSize is below the minimum allowable.
     */
    public RPNCalculator(int stackSize) throws IllegalArgumentException {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException("The given stackSize was too small!"
                    + "\nMinimum size: " + MIN_STACK_SIZE + "\nGiven: " + stackSize);
        }
        this.stack = new Stack(stackSize);
    }
}
