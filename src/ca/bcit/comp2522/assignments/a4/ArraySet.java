package ca.bcit.comp2522.assignments.a4;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ArraySet is a resizeable-array implementation of the Set interface. It
 * contains a set of elements in no particular order that excludes duplicates or
 * nulls.
 * 
 * Elements may be added to, removed from, and searched for in the ArraySet. As
 * elements are added to the ArraySet its capacity is resized automatically.
 * 
 * ArraySet contains a SetIterator that permits access to the elements in the
 * ArraySet one at a time.
 * 
 * @author Chloe Glave
 * @version 2020
 * @invariant The ArraySet never contains duplicate elements.
 * @invariant The ArraySet never contains nulls.
 */
public class ArraySet<E> implements Set<E>, MyIterable<E> {

    /**
     * The initial capacity of the ArraySet.
     */
    public static final int INITIAL_CAPACITY = 10;

    /**
     * The capacity of the ArraySet.
     */
    protected int capacity;

    /**
     * The number of elements contained in the ArraySet.
     */
    protected int elementCount;

    /**
     * The array buffer that stores the elements of the ArraySet.
     */
    protected E[] collection;

    /**
     * Constructs a new empty ArraySet of default initial capacity 10.
     * 
     * @pre true
     * @post size() = 0.
     */
    public ArraySet() {
        this.capacity = INITIAL_CAPACITY;
        this.elementCount = 0;
        this.collection = (E[]) new Object[capacity];
    }

    /**
     * Adds the specified element to the ArraySet if it is not already present.
     * 
     * @param element The element to be added to the set.
     * @pre true
     * @post IF ( element != null AND NOT @pre.contains(element) ) THEN
     *       contains(element) ELSE the ArraySet is not changed
     * @return true if the ArraySet did not already contain the specified
     *         element, else false.
     */
    public boolean add(final E element) {
        // todo: finish method
        resize();


        System.out.println("Added element " + element);
        collection[elementCount] = element;
        elementCount++;
        return false;
    }

    /**
     * Removes the specified element from the ArraySet if it exists.
     * 
     * @param element The element to be removed, if present.
     * @pre true
     * @post IF @pre.contains(element) THEN NOT contains(element) ELSE the
     *       ArraySet is not changed
     * @return true if element was removed from the ArraySet, else false.
     */
    public boolean remove(final E element) {
        if (contains(element)) { // todo: added complexity. if contains returned an int I could just use that value
            MyIterator<E> it = new SetIterator<>();
            int positionOfRemoved = 0;

            while (it.hasNext()) {
                if (it.next() == element) {
                    break;
                }
                positionOfRemoved++;
            }
            collection[positionOfRemoved] = collection[size() - 1]; // fill gap with last element
            collection[size() - 1] = null;
            elementCount--;
            return true;
        }
        return false;
    }

    /**
     * Removes all elements from the ArraySet. The ArraySet will be empty after
     * this call returns.
     * 
     * @pre true
     * @post size() = 0
     */
    public void clear() {
        MyIterator<E> it = new SetIterator<>();
        int position = 0;
        while (it.hasNext()) {
            collection[position] = null;
        }
    }

    /**
     * Returns true if this ArraySet contains the specified element. todo: change return type to int; index of contained element?
     * 
     * @param element The element to be checked for containment.
     * @pre true
     * @post true
     * @return true if element is in the ArraySet, and false otherwise.
     */
    public boolean contains(final E element) { // todo: make this a wrapper for a new method that gives the position of the element or -1 if it doesn't exist
        MyIterator<E> it = new SetIterator<>();
        while (it.hasNext()) {
            if (it.next() == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in the ArraySet (its cardinality).
     * 
     * @pre true
     * @post true
     * @return The number of elements in the ArraySet.
     */
    public int size() {
        return elementCount;
    }

    /**
     * Doubles the size of the ArraySet.
     * 
     * @pre true
     * @post the capacity of the ArraySet is doubled.
     */
    private void resize() {
        if (size() == capacity) { // array is full
            int position = 0;
            E[] newCollection = (E[]) new Object[capacity * 2];

            while (position < capacity) {
            newCollection[position] = collection[position];
            position++;
            }

            capacity *= 2;
            collection = newCollection;
        }
    }

    /**
     * Creates and returns an array containing the elements of the ArraySet.
     * 
     * @pre true
     * @post true
     * @return an unordered array containing the elements of the ArraySet.
     */
    public Object[] toArray() {
        Object[] newArray = new Object[size()];
        int position = 0;

        MyIterator<Integer> it = new SetIterator<>();
        while (it.hasNext() && position < size()) {
            newArray[position] = it.next();
            position++;
        }
        return newArray;
    }

    /**
     * Returns an iterator over the elements in this ArraySet. The elements are
     * returned in no particular order.
     * 
     * @pre true
     * @post true
     * @return an iterator for the ArraySet of elements that points to the first
     *         element in the ArraySet.
     */
    public SetIterator<E> iterator() {
        return new SetIterator();
    }

    /**
     * SetIterator provides a means for iterating over the elements of an ArraySet.
     */
    public class SetIterator<E> implements MyIterator<E> {

        private int currentPosition;

        /**
         * Returns true if the iteration has more elements.
         *
         * @pre true
         * @post true
         * @return true if the iteration has more elements, false otherwise.
         */
        public boolean hasNext() {
            return collection[currentPosition] != null && currentPosition < size();
        }

        /**
         * Returns the next element in the iteration and advances to point to
         * the next.
         *
         * @pre @pre.hasNext()
         * @post SetIterator points to the next element in the ArraySet.
         * @return the element pointed to by the SetIterator when the method is called.
         */
        public E next() {
            currentPosition++;
            return (E) collection[currentPosition - 1];
        }
    }

    public static void main(String[] args) {
        ArraySet<Integer> ar = new ArraySet<>();
        ar.add(0);
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.add(5);
        ar.add(6);
        ar.add(7);
        ar.add(8);
        ar.add(9);
        System.out.println(Arrays.toString(ar.collection));
        System.out.println("size " + ar.size());
        System.out.println("capacity " + ar.capacity);

        ar.add(10);
        System.out.println(Arrays.toString(ar.collection));
        System.out.println("size " + ar.size());
        System.out.println("capacity " + ar.capacity);


      //  System.out.println(Arrays.toString(ar.toArray()));

    }

}
