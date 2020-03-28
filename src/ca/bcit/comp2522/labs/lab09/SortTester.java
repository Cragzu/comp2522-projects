package ca.bcit.comp2522.labs.lab09;

import java.util.Arrays;

/**
 * Showcases various array sorting algorithms.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class SortTester {

    /**
     * Sorts an array using the selection sort algorithm.
     * Reference: https://www.geeksforgeeks.org/selection-sort/
     *
     * @param array the array of ints to sort.
     * @return the time in nanoseconds it took to complete the sort.
     * @pre array contains ints or is empty.
     * @post array will be sorted in ascending order.
     */
    long quadraticSort(int[] array) {
        long timeAtStart = System.nanoTime();

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
        return System.nanoTime() - timeAtStart;
    }

    /**
     * Places an element in an array in the correct sorted position.
     * Helper method for logarithmicSort.
     *
     * @param array the array of ints to sort.
     * @param low the starting index.
     * @param high the ending index.
     * @return the "partition" index, where the array is divided.
     */
    int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i]; // swap elements
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**
     * Sorts an array using the quick sort algorithm.
     * Reference: https://www.geeksforgeeks.org/quick-sort/
     *
     * @param array the array of ints to sort.
     * @param low the starting index.
     * @param high the ending index.
     * @pre array contains ints or is empty.
     * @post array will be sorted in ascending order.
     */
    void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high); // find dividing index
            quickSort(array, low, (partitionIndex - 1)); // sort elements before partition
            quickSort(array, (partitionIndex + 1), high); // sort elements after partition
        }
    }

    /**
     * Drives the quickSort algorithm.
     * @param array the array of ints to sort.
     * @return the time in nanoseconds it took to complete the sort.
     */
    long logarithmicSort(int[] array) {
        long timeAtStart = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        return System.nanoTime() - timeAtStart;
    }

}
