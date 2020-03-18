package ca.bcit.comp2522.labs.lab06;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Demonstrates the use of generics.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class OrderedPair<K, V> {
    private K first;
    private V second;

    /**
     * Constructs an ordered pair.
     * @param first K - the first object.
     * @param second V - the second object.
     */
    public OrderedPair(final K first, final V second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Accesses the first variable.
     *
     * @return K - the first instance variable.
     */
    public K getFirst() {
        return first;
    }

    /**
     * Accesses the second variable.
     *
     * @return V - the second instance variable.
     */
    public V getSecond() {
        return second;
    }

    public static void main(String[] args) {
        String firstStr = "Hello World";
        String secondStr = "Java Chip";
        OrderedPair<String, String> stringOrderedPair = new OrderedPair<>(firstStr, secondStr);

        Integer i = 50;
        ArrayList<Integer> ar = new ArrayList<Integer>();
        OrderedPair<Integer, ArrayList<Integer>> integerArrayListOrderedPair
                = new OrderedPair<>(i, ar);

        Box<Double> firstBox = new Box<>();
        Box<Double> secondBox = new Box<>();
        OrderedPair<Box<Double>, Box<Double>> boxOrderedPair
                = new OrderedPair<>(firstBox, secondBox);
    }

}
