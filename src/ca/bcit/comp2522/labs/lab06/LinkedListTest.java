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
    public void testAppend() throws Exception {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.append(50);
        System.out.println(testList.toString());
        assertEquals(50, (int) testList.findTail(testList.getHead()).getData());
    }

    @Test
    public void testPrepend() throws Exception {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.prepend(1);
        assertEquals(1, (int) testList.get(0));
    }

    @Test
    public void add() throws Exception {
        testList2.add(44, 3);
        assertEquals(44, (int) testList2.get(3));
    }

    @Test
    public void clear() {
        testList3.clear();
        assertEquals(0, testList3.size());
    }


    @Test
    public void getSize() {
        assertEquals(10, testList1.size());
    }

    @Test
    public void remove() {
        testList2.add(45, 3);
        testList2.remove(3);
        assertNotEquals(45, (int) testList2.get(3));
    }

    @Test
    public void get() {
        testList2.add(45, 3);
        assertEquals(45, (int) testList2.get(3));
    }

    @Test
    public void testEqualsNot() {
        assertNotEquals(testList1, testList2);
    }

    @Test
    public void testEqualsPartialAnagram() {
        assertNotEquals(testList5, testList6);
    }
    
    @Test
    public void testEqualsEmpty() {
        LinkedList<Integer> testList7 = new LinkedList<>();
        LinkedList<Integer> testList8 = new LinkedList<>();
        assertEquals(testList7, testList8);
    }
    @Test
    public void testEqualsUnequalSize() {
        testList3.clear();
        assertNotEquals(testList1, testList3);
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