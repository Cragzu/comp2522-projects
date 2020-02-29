package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

/**
 * Reverse Polish Notation calculator.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class RPNCalculator {
    /**
     * The minimum possible size a stack can be.
     */
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

    /**
     * Pushes an int onto the Stack to be processed.
     *
     * @param operand int - the number to push.
     * @throws StackOverflowException if the stack is full and cannot accept a new operand.
     */
    public void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("No room left in the stack for this!");
        }
        stack.push(operand);
    }

    private Operation getOperation(final char symbol) {
        switch (symbol) {
            case AdditionOperation.ADDITION_CODE:
                return new AdditionOperation();
            case SubtractionOperation.SUBTRACTION_CODE:
                return new SubtractionOperation();
            case MultiplicationOperation.MULTIPLICATION_CODE:
                return new MultiplicationOperation();
            case DivisionOperation.DIVISION_CODE:
                return new DivisionOperation();
            default:

        }
    }


    /**
     * Processes formulae using reverse polish notation.
     *
     * @param formula String - numbers and operand characters forming the mathematical expression.
     * @return Operation - the type of operation we are using.
     * @throws IllegalArgumentException if formula is an invalid string.
     */
    public int processFormula(final String formula) throws IllegalArgumentException {
        if (formula == null || formula.length() == 0) {
            throw new IllegalArgumentException("That formula doesn't exist!");
        }

        return 0;



    }

}
