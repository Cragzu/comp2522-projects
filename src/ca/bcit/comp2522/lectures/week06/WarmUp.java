package ca.bcit.comp2522.lectures.week06;

/**
 * A warm-up for this week's lab activity.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class WarmUp {

    /**
     * Determines the sum of the largest two ints in an array.
     *
     * @param arrayOfInts int[] - the given array to calculate from.
     * @return the sum of the largest two ints in arrayOfInts
     */
    public static int getSumOfTwoLargest(final int[] arrayOfInts) {
        int largest = arrayOfInts[0];
        int secondLargest = arrayOfInts[1];

        for (int i = 2; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] > largest) {
                secondLargest = largest;
                largest = arrayOfInts[i];
            } else if (arrayOfInts[i] > secondLargest) {
                secondLargest = arrayOfInts[i];
            }
        }
        return largest + secondLargest;
    }

    public static void main(String[] args) {
        int[] testA = {2, 1};
        int[] testB = {2, 4, 6, 8, 10, 12, 14};
        int[] testC = {14, 12, 10, 8, 10, 12, 14};
        int[] testD = {8, 8, 8, 8, 8, 8, 8};

        System.out.println(getSumOfTwoLargest(testA));
        System.out.println(getSumOfTwoLargest(testB));
        System.out.println(getSumOfTwoLargest(testC));
        System.out.println(getSumOfTwoLargest(testD));
    }
}
