package ca.bcit.comp2522.assignments.a3;

/**
 * Stack data structure.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Stack {
    private int[] stackValues;
    private int count = 0;

    /**
     * Constructor - initializes a new Stack with a given size.
     *
     * @param arraySize the size of the array to create; the maximum number of ints it can hold.
     */
    public Stack(int arraySize) {
        if (arraySize < 1) {
            throw new IllegalArgumentException("Array size cannot be less than 1! "
                    + "\nSize given: " + arraySize);
        }
        stackValues = new int[arraySize];
    }

    /**
     * Gets the total capacity of the Stack.
     *
     * @return int - the size of the Stack array.
     */
    public int capacity() {
        return stackValues.length;
    }

    /**
     * Gets the number of non-zero elements currently in the Stack.
     *
     * @return int - the size of the Stack array.
     */
    public int size() {
        return this.count;
    }

    /**
     * Gets the amount of empty space in the Stack.
     *
     * @return int - the number of unused slots in the Stack array.
     */
    public int unused() {
        return this.capacity() - this.size();
    }

    /**
     * Adds a new value to the end of the Stack.
     *
     * @param value int - the number to put in the Stack array.
     * @throws StackOverflowException when Stack is full and cannot accept a new value.
     */
    public void push(int value) throws StackOverflowException {
        if (this.size() == this.capacity()) {
            throw new StackOverflowException("This stack is full!");
        }

        stackValues[this.size()] = value; // replace first non-zero value
        count++; // array size is one larger now
    }

    /**
     * Removes the last value from the end of the Stack.
     *
     * @return int - the value that was just removed from the Stack array.
     * @throws StackUnderflowException when Stack is empty and nothing can be removed from it.
     */
    public int pop() throws StackUnderflowException {
        if (this.size() == 0) {
            throw new StackUnderflowException("Cannot call Stack.pop() on an empty stack!");
        }

        int value = stackValues[this.size() - 1];
        stackValues[this.size() - 1] = 0;
        count--; // array size is one smaller now
        return value;
    }

    public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
        Stack s = new Stack(50);
        System.out.println("Capacity: " + s.capacity());
        System.out.println("Initial size: " + s.size());
        System.out.println("Empty space: " + s.unused());
        s.push(3);
        System.out.println("Size after adding element: " + s.size());
        System.out.println("First element: " + s.stackValues[0]);
        System.out.println("Removed element: " + s.pop());
        System.out.println("First element: " + s.stackValues[0]);
    }

}
