package ca.bcit.comp2522.labs.lab09;

import java.util.Arrays;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class SortTester {


    /**
     * Sorts an array using the selection sort algorithm.
     * Reference: https://www.geeksforgeeks.org/selection-sort/
     *
     * @param array the array of ints to sort.
     * @pre array contains ints or is empty.
     * @post array will be sorted in ascending order.
     */
    void QuadraticSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) { // iterate through array
            int minimumIndex = i;
            for (int j = i + 1; j < length; j++) { // find smallest element in unchecked part
                if (array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            int temp = array[minimumIndex]; // swap elements
            array[minimumIndex] = array[i];
            array[i] = temp;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));
    }


}
