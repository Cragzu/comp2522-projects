package ca.bcit.comp2522.assignments.a3;

/**
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
}
