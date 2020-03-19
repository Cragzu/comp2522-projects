package ca.bcit.comp2522.lectures.week06;

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

    /**
     * Compares two ordered pairs and checks their equality.
     *
     * @param p1 OrderedPair - the first object to compare.
     * @param p2 OrderedPair - the second object to compare.
     * @param <K> the first parameter of the OrderedPairs.
     * @param <V> the second parameter of the OrderedPairs.
     * @return true if the elements of the OrderedPair parameters are equal, else false.
     */
    public static <K, V> boolean same(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
        return (p1.getFirst().equals(p2.getFirst())) && (p1.getSecond().equals(p2.getSecond()));
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

        Integer a = 3;
        Integer b = 4;
        Integer c = 5;
        OrderedPair<Integer, Integer> firstIntegerOrderedPair = new OrderedPair<>(a, b);
        OrderedPair<Integer, Integer> secondIntegerOrderedPair = new OrderedPair<>(a, b);
        OrderedPair<Integer, Integer> thirdIntegerOrderedPair = new OrderedPair<>(a, c);

        System.out.println(same(firstIntegerOrderedPair, secondIntegerOrderedPair));
        System.out.println(same(firstIntegerOrderedPair, thirdIntegerOrderedPair));

    }
}
