package ca.bcit.comp2522.labs.lab06;

public class WarmUp {

    public static int getSumOfTwoLargest(int[] arrayOfInts) {
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
        System.out.println("Largest = " + largest + " Second largest = " + secondLargest);
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
