package ca.bcit.comp2522.assignments.a3;

/**
 * Stack data structure.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Stack {
    private int[] stackValues;
    private int count;

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
        int numElements = 0;
        for (int i = 0; i < this.capacity(); i++) {
            if (stackValues[i] != 0) {
                numElements++;
            }
        }
        return numElements;
    }

    public static void main(String[] args) {
        Stack s = new Stack(50);
        System.out.println(s.capacity());
    }

}
