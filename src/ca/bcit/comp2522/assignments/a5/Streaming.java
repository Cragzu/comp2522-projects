package ca.bcit.comp2522.assignments.a5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates some applications of streaming in Java.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Streaming {
    /*
     * QUESTION 1
     *
     * The following stream pipeline will produce a sum of all odd Integers in the list.
     *
     * list.stream().filter(value -> value % 2 != 0).sum();
     */

    /*
     * QUESTION 2
     *
     * The following stream pipeline will run 1 million coin flips.
     * It generates a random number between 1 and 3 (so either 1 or 2) 1_000_000 times,
     * and puts the result in a collection, which stores the number of times each side was flipped.
     *
     * random.ints(1_000_000, 1, 3).boxed()
     * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
     * .forEach((side, frequency) -> System.out.printf("%-6d%d%n", side, frequency));
     */

    /**
     * Creates a List containing 30 random characters.
     *
     * @return the created List.
     */
   static List<Character> words() {

       List<Character> listToPopulate = new ArrayList<>();

       for (int j = 0; j < 30; ++j) {
           listToPopulate.add((char) (97 + new Random().nextInt(26)));
       }

       return listToPopulate;
   }

    /**
     * Sorts a List of characters in ascending order.
     *
     * @param listToSort the List of characters to sort.
     * @return the newly sorted List.
     */
   static List<Character> ascendingSort(List<Character> listToSort) {
       return listToSort.stream().sorted().collect(Collectors.toList());
   }

    public static void main(String[] args) { // todo: clean up main
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);

 //       System.out.println(al);

//        al.stream().forEach(e -> System.out.println(e));

   //     al.stream().filter(value -> value % 2 != 0).forEach(value -> System.out.println(value));

//        new Random().ints(1_000_000, 1, 3).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) .forEach((side, frequency) -> System.out.printf("%-6d%d%n", side, frequency));

        List<Character> letters = words();
        System.out.println("Generated letters array: " + letters);

        List<Character> ascendingSortedLetters = ascendingSort(letters);
        System.out.println("Ascending sorted array: " + ascendingSortedLetters);

    }
}
