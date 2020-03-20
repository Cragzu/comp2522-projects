package ca.bcit.comp2522.labs.lab06;

import java.util.Objects;

/**
 * A string of Nodes connected through addresses.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class LinkedList<T> {

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(final T data) {
            this.data = data;
            this.next = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private Node<T> head;

    /**
     * Constructs a LinkedList with a null head.
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Finds the first Node of the linked list.
     * @return the head of the list.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Finds the last Node of the linked list.
     * @param current the Node being examined.
     * @return the last Node in the list; the one pointing to null.
     */
    public Node<T> findTail(Node<T> current) {
        if (current.getNext() == null) {
            return current;
        }
        return findTail(current.getNext());
    }

    /**
     * Adds a new Node to the end of the linked list.
     * @param data the T that the new Node will store.
     */
    public void append(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> lastNode = findTail(head);
        lastNode.setNext(newNode);
    }

    /**
     * Adds a new Node to the beginning of the linked list.
     * @param data the T that the new Node will store.
     */
    public void prepend(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Inserts a new Node at the specified position in the linked list.
     * @param data the T that the new Node will store.
     * @param index the position to insert the new Node at.
     */
    public void add(T data, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("That index is invalid!");
        }
        Node<T> newNode = new Node<T>(data);
        if (head == null) { // index given is 0 and the list is empty
            head = newNode;
            return;
        }

        int currentPosition = 0;
        Node<T> it = head;
        while (it.getNext() != null) {
            if (index == currentPosition + 1) {
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
        Node<T> it = head;
        while (it.getNext() != null) {
            numElements++;
            it = it.getNext();
        }
        return numElements + 1; // account for starting at 0
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
    public T get(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("That index is invalid!");
        }
        if (head == null) {
            return null;
        }

        int currentPosition = 0;
        Node<T> it = head;
        while (it != null) {
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
    public T remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("That index is invalid!");
        }
        if (head == null) {
            return null;
        }
        int currentPosition = 0;
        Node<T> it = head;
        while (it.getNext() != null) {
            if (index == currentPosition + 1) {
                T removedData = it.getNext().getData();
                it.setNext(it.getNext().getNext()); // skip over node to be removed
                return removedData;
            }
            currentPosition++;
            it = it.getNext();
        }
        return null;
    }

    /**
     * Finds recursively the number of Nodes in the Linked List that contain equal data.
     * @param current Node - the node currently being examined
     * @param dataToCompare T - the data to check against
     * @param count int - the number of nodes containing the specified data. Should start at 0.
     * @return int - the number of nodes containing the specified data.
     */
    public int findEqualNodes(Node<T> current, T dataToCompare, int count) {
        if (current.getData().equals(dataToCompare)) {
            count++;
        }
        if (current.getNext() == null) { // base case
            return count;
        }
        return findEqualNodes(current.getNext(), dataToCompare, count);
    }

    /**
     * Determines the number of Nodes in the Linked List that contain equal data.
     * Wrapper method for findEqualNodes.
     *
     * @param o T - the data to check against.
     * @return int - the number of nodes containing the specified data.
     * @throws IllegalArgumentException if the given T is null
     * @throws EmptyListException if the list is empty
     */
    public int count(T o) throws IllegalArgumentException, EmptyListException {
        if (o == null) {
            throw new IllegalArgumentException("No T found!");
        } else if (head.getNext() == null) { // list is empty
            throw new EmptyListException("The list is empty!");
        }
        int count = 0;
        return findEqualNodes(head, o, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedList)) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        return Objects.equals(getHead(), that.getHead());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("LinkedList{" + head.data);

        Node<T> it = head;
        while (it.getNext() != null) {
            it = it.getNext();
            str.append(" ").append(it.data);
        }
        str.append("}");

        return str.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);

        System.out.println(list.toString());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

    }
}
