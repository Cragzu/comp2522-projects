package ca.bcit.comp2522.assignments.a5;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Demonstrates some applications of streaming in Java.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Streaming {
    /**
     * QUESTION 1
     *
     * The following stream pipeline will produce a sum of all odd Integers in the list.
     *
     * list.stream().filter(value -> value % 2 != 0).sum();
     */

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);

        System.out.println(al);

//        al.stream().forEach(e -> System.out.println(e));

        al.stream().filter(value -> value % 2 != 0).forEach(value -> System.out.println(value));




    }
}
