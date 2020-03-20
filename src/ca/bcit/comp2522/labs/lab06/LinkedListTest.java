package ca.bcit.comp2522.labs.lab06;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Linked List.
 * @author Karel Chanivecky Garcia
 * @author Chloe Glave
 * @version 2020
 */
public class LinkedListTest {
    LinkedList<Integer> testList1 = new LinkedList<>();
    LinkedList<Integer> testList2 = new LinkedList<Integer>();
    LinkedList<Integer> testList3 = new LinkedList<Integer>();
    LinkedList<Integer> testList4 = new LinkedList<>();
    LinkedList<Integer> testList5 = new LinkedList<>();
    LinkedList<Integer> testList6 = new LinkedList<>();
    LinkedList<Integer> testList7 = new LinkedList<Integer>();


    @Before
    public void setUp() {
        for (int i = 0; i < 10; i++) {
            testList1.append(i);
            testList2.append(i + 5);
            testList3.append(i + 10);
            testList4.prepend(i);
            testList5.append(i);
            testList6.append(i);
            testList7.append(i);
        }
        testList5.append(9);
        testList6.append(8);
    }

    @Test
    public void append() throws Exception{
        testList3.append(50);
        assertEquals(50, testList3.get(testList3.size() - 1));
    }

    @Test
    public void prepend() throws Exception{
        testList2.prepend(1);
        assertEquals(1, testList2.get(0));
    }

    @Test
    public void add() throws Exception{
        testList2.add(44, 3);
        assertEquals(44, testList2.get(3));
    }

    @Test
    public void clear() {
        testList3.clear();
        assertEquals(0, testList3.getSize());
    }


    @Test
    public void getSize() {
        assertEquals(10, testList1.getSize());
    }

    @Test
    public void remove() throws ItemOutOfBoundsException {
        testList2.add(45, 3);
        testList2.remove(3);
        assertNotEquals(45, testList2.get(3));
    }

    @Test
    public void get() throws ItemOutOfBoundsException {
        testList2.add(45, 3);
        assertEquals(45, testList2.get(3));
    }

    @Test
    public void testEqualsNot() {
        assertFalse(testList1.equals(testList2));
    }

    @Test
    public void testEqualsPartialAnagram() {
        assertFalse(testList5.equals(testList6));
    }
    
    @Test
    public void testEqualsEmpty() {
        LinkedList testList7 = new LinkedList();
        LinkedList testList8 = new LinkedList();
        assertTrue(testList7.equals(testList8));
    }
    @Test
    public void testEqualsUnequalSize() {
        testList3.clear();
        assertFalse(testList1.equals(testList3));
    }

    @Test
    public void testEquals() {
        assertTrue(testList1.equals(testList7));
    }


    @Test
    public void testEqualsSameElementsDifferentOrder() {
        assertTrue(testList1.equals(testList7));
    }

}