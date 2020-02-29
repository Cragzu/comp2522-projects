package ca.bcit.comp2522.assignments.a3;

import java.util.Arrays;
import java.util.Objects;

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
    public Stack(final int arraySize) {
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
    public void push(final int value) throws StackOverflowException {
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

    /**
     * Finds the last value at the end of the Stack, without removing it.
     *
     * @return int - the value on the end of the Stack array.
     * @throws StackUnderflowException when Stack is empty and nothing can be viewed in it.
     */
    public int peek() throws StackUnderflowException {
        if (this.size() == 0) {
            throw new StackUnderflowException("Cannot call Stack.peek() on an empty stack!");
        }
        return stackValues[this.size() - 1];
    }

    //<editor-fold desc="toString, equals, hashcode">
    /**
     * Generates a string representation of the object.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Stack{"
                + "stackValues=" + Arrays.toString(stackValues)
                + ", count=" + count
                + '}';
    }

    /**
     * Determines whether this object is equal to another.
     *
     * @param o object - to be compared to this.
     * @return boolean - true if the objects are equal else false
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Stack)) {
            return false;
        }
        Stack stack = (Stack) o;
        return count == stack.count
                && Arrays.equals(stackValues, stack.stackValues);
    }

    /**
     * Generates a unique hashcode for this object.
     *
     * @return int - the object's hashcode.
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result += Arrays.hashCode(stackValues);
        return result;
    }
    //</editor-fold>
}
