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

    /**
     * Determines the type of operation to use in a calculation.
     *
     * @param symbol char - the operation to use.
     * @return Operation - the appropriate Operation object to use.
     * @throws InvalidOperationTypeException if the given symbol is not recognized.
     */
    private Operation getOperation(final char symbol) throws InvalidOperationTypeException {
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
                throw new InvalidOperationTypeException("That symbol wasn't recognized!", symbol);
        }
    }

    /**
     * Processes formulae using reverse polish notation.
     *
     * @param formula String - numbers and operand characters forming the mathematical expression.
     * @return Operation - the type of operation we are using.
     * @throws IllegalArgumentException if formula is an invalid string.
     * @throws StackOverflowException if the stack is full and cannot accept a new operand.
     */
    public int processFormula(final String formula) throws IllegalArgumentException,
            StackOverflowException, InvalidOperationTypeException {

        if (formula == null || formula.length() == 0) {
            throw new IllegalArgumentException("That formula doesn't exist!");
        }

        Scanner scanner = new Scanner(formula);
        Operation currentOperation;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) { // next item is an operand int
                this.push(scanner.nextInt());
            } else { // next item is an operator char
                currentOperation = this.getOperation(scanner.next().charAt(0));
            }
            //pass to perform, invoke getresult


        }
        return 0;
    }

    /**
     * Retrieves the current value in the stack; the result.
     *
     * @return int - the result of some operation.
     * @throws StackUnderflowException if the stack is empty and nothing can be retrieved.
     */
    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("There are no operands!");
        }
        return stack.peek(); // the operation result on top of the stack
    }

    public static void main(String[] args) {
        String test = "+ - + / * +";
        Scanner scanner = new Scanner(test);

        while (scanner.hasNext()) {
            System.out.println(scanner.next().charAt(0));
        }

    }

}
