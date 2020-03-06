package ca.bcit.comp2522.labs.lab05;

/**
 * A string of Nodes connected through addresses.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class LinkedList {
    private Node head;

    /**
     * Constructs a LinkedList with a null head.
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Finds the last Node of the linked list.
     * @param current the Node being examined.
     * @return the last Node in the list; the one pointing to null.
     */
    public Node findTail(Node current) {
        if (current.getNext() == null) {
            return current;
        }
        return findTail(current.getNext());
    }

    /**
     * Adds a new Node to the end of the linked list.
     * @param data the Object that the new Node will store.
     */
    public void append(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = findTail(head);
        lastNode.setNext(newNode);
    }

    /**
     * Adds a new Node to the beginning of the linked list.
     * @param data the Object that the new Node will store.
     */
    public void prepend(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Inserts a new Node at the specified position in the linked list.
     * @param data the Object that the new Node will store.
     * @param index the position to insert the new Node at.
     */
    public void add(Object data, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("That index is invalid!");
        }
        Node newNode = new Node(data);
        if (head == null) { // index given is 0 and the list is empty
            head = newNode;
            return;
        }

        int currentPosition = 0;
        Node it = head;
        while (it.getNext() != null) {
            if (index == currentPosition - 1) {
                newNode.setNext(it.getNext());
                it.setNext(newNode);
                return;
            }
            currentPosition++;
            it = it.getNext();
        }
    }

    /**
     * Counts the total number of Nodes in the linked list.
     * @return the size of the linked list.
     */
    public int size() {
        int numElements = 0;
        if (head == null) {
            return numElements;
        }
        Node it = head;
        while (it.getNext() != null) {
            numElements++;
            it = it.getNext();
        }
        return numElements;
    }

    /**
     * Clears the linked list, setting head Node to null.
     */
    public void clear() {
        head = null;
    }

    /**
     * Finds the data stored in the Node at the specified index.
     * @param index the Node to find.
     * @return the data stored by the node at position index.
     */
    public Object get(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("That index is invalid!");
        }
        if (head == null) {
            return null;
        }

        int currentPosition = 0;
        Node it = head;
        while (it.getNext() != null) {
            if (index == currentPosition) {
                return it.getData();
            }
            currentPosition++;
            it = it.getNext();
        }
        return null;
    }

    /**
     * Removes the Node at the specified index from the linked list and gets its data.
     * @param index the Node to find.
     * @return the data from the Node removed.
     */
    public Object remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("That index is invalid!");
        }
        if (head == null) {
            return null;
        }
        int currentPosition = 0;
        Node it = head;
        while (it.getNext() != null) {
            if (index == currentPosition - 1) {
                Object removedData = it.getNext().getData();
                it.setNext(it.getNext().getNext()); // skip over node to be removed
                return removedData;
            }
            currentPosition++;
            it = it.getNext();
        }
        return null;
    }




}
