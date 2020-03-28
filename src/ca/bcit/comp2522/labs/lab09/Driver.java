package ca.bcit.comp2522.labs.lab09;

import java.util.Arrays;
import java.util.Random;

/**
 * Tests different sorting algorithms for their efficiency on arrays of various sizes.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Driver {
    static final int SIZE1 = 10;
    static final int SIZE2 = 100;
    static final int SIZE3 = 1_000;
    static final int SIZE4 = 10_000;
    static final int SIZE5 = 100_000;
    static final int SIZE6 = 1_000_000;
    static final int SIZE7 = 10_000_000;
    static final int NUM_OF_TESTS = 10;

    /**
     * Find the average time a quadratic sort algorithm takes to complete for a given array size.
     *
     * @param arrSize the number of elements in the array.
     * @return the average time over 10 trials.
     */
    long averageTimeForQuadratic(int arrSize) {
        SortTester st = new SortTester();
        long avgTime = 0;

        for (int i = 0; i < NUM_OF_TESTS; i++) {

            int[] testArray = new int[arrSize]; // fill test array with random ints
            for (int j = 0; j < arrSize; j++) {
                testArray[j] = new Random().nextInt(arrSize) + 1;
            }

            avgTime += st.quadraticSort(testArray);
        }
        return avgTime / NUM_OF_TESTS;
    }

    /**
     * Find the average time a quadratic sort algorithm takes to complete for a given array size.
     *
     * @param arrSize the number of elements in the array.
     * @return the average time over 10 trials.
     */
    long averageTimeForLogarithmic(int arrSize) {
        SortTester st = new SortTester();
        long avgTime = 0;

        for (int i = 0; i < NUM_OF_TESTS; i++) {

            int[] testArray = new int[arrSize]; // fill test array with random ints
            for (int j = 0; j < arrSize; j++) {
                testArray[j] = new Random().nextInt(arrSize) + 1;
            }

            avgTime += st.logarithmicSort(testArray);
        }
        return avgTime / NUM_OF_TESTS;
    }


    public static void main(String[] args) {
        Driver d = new Driver();

        System.out.println(d.averageTimeForQuadratic(SIZE1));
        System.out.println(d.averageTimeForQuadratic(SIZE2));
        System.out.println(d.averageTimeForQuadratic(SIZE3));
        System.out.println(d.averageTimeForQuadratic(SIZE4));
        System.out.println(d.averageTimeForQuadratic(SIZE5));
        System.out.println(d.averageTimeForQuadratic(SIZE6));
        System.out.println(d.averageTimeForQuadratic(SIZE7));

//        System.out.println(d.averageTimeForLogarithmic(SIZE1));
//        System.out.println(d.averageTimeForLogarithmic(SIZE2));
//        System.out.println(d.averageTimeForLogarithmic(SIZE3));
//        System.out.println(d.averageTimeForLogarithmic(SIZE4));
//        System.out.println(d.averageTimeForLogarithmic(SIZE5));
//        System.out.println(d.averageTimeForLogarithmic(SIZE6));
//        System.out.println(d.averageTimeForLogarithmic(SIZE7));

    }
}
