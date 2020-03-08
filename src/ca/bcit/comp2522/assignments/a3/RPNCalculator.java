package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

/**
 * Reverse Polish Notation calculator.
 * todo: bonus?
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
    public RPNCalculator(final int stackSize) throws IllegalArgumentException {
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
            case ModulusOperation.MODULUS_CODE:
                return new ModulusOperation();
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
     * @throws InvalidOperationTypeException if the operation type is not recognized.
     * @throws StackUnderflowException if the stack is empty and nothing can be retrieved from it.
     */
    public int processFormula(final String formula) throws IllegalArgumentException,
            StackOverflowException, InvalidOperationTypeException, StackUnderflowException {

        if (formula == null) {
            throw new IllegalArgumentException("That formula doesn't exist!");
        } else if (formula.length() == 0) {
            throw new StackUnderflowException("The formula was empty!");
        }

        Scanner scanner = new Scanner(formula);
        Operation currentOperation;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) { // next item is an operand int
                this.push(scanner.nextInt());
            } else { // next item is an operator char
                currentOperation = this.getOperation(scanner.next().charAt(0));
                perform(currentOperation);
            }
        }
        return getResult();
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

    /**
     * Performs an operation of a given type on the top two operands in the stack.
     *
     * @param operation Operation - the object that will perform the type of work required
     * @throws IllegalArgumentException if the passed operation is null
     * @throws StackUnderflowException if the stack is empty and there is nothing to operate on
     * @throws StackOverflowException if the stack is full and there is no room for the result
     */
    public void perform(final Operation operation) throws IllegalArgumentException,
            StackUnderflowException, StackOverflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        }

        // pop top two operands in reverse order (A B / should be processed as A / B)
        int operandB = stack.pop();
        int operandA = stack.pop();

        int result = operation.perform(operandA, operandB);

        stack.push(result);
    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     *
     * Example usage: RPNCalculator 10 "1 2 +"
     *
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     *             to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {
        // Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }
        // Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);
        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println("formula can only contain integers, +, -, *, and /");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }

}
