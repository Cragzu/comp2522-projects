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
    LinkedList<Integer> testList2 = new LinkedList<>();
    LinkedList<Integer> testList3 = new LinkedList<>();
    LinkedList<Integer> testList4 = new LinkedList<>();
    LinkedList<Integer> testList5 = new LinkedList<>();
    LinkedList<Integer> testList6 = new LinkedList<>();
    LinkedList<Integer> testList7 = new LinkedList<>();

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
    public void testAppend() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.append(50);
        System.out.println(testList.toString());
        assertEquals(50, (int) testList.get(0));
    }

    @Test
    public void testPrepend() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.prepend(2);
        testList.prepend(1);
        assertEquals(1, (int) testList.get(0));
    }

    @Test
    public void add() {
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
        System.out.println(testList1.toString());
        assertEquals(10, testList1.size());
    }

    @Test
    public void remove() {
        System.out.println(testList2);
        testList2.add(45, 3);
        System.out.println(testList2);
        testList2.remove(3);
        System.out.println(testList2);
        assertNotEquals(45, (int) testList2.get(3));
    }

    @Test
    public void testGet() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.append(0);
        testList.append(1);
        testList.append(2);
        for (int i = 0; i <= 2; i++) {
            assertEquals(i, (int) testList.get(i));
        }
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
        LinkedList<Integer> testList1 = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            testList1.append(i);
        }
        LinkedList<Integer> testList2 = testList1;
        assertEquals(testList1, testList2);
    }

    @Test
    public void testInteger() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.append(1);
        testList.append(2);
        testList.append(3);
        assertEquals("LinkedList{1 2 3}", testList.toString());
    }

    @Test
    public void testString() {
        LinkedList<String> testList = new LinkedList<>();
        testList.append("One");
        testList.append("Two");
        testList.append("Three");
        assertEquals("LinkedList{One Two Three}", testList.toString());
    }
}