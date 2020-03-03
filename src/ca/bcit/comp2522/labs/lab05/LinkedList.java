package ca.bcit.comp2522.labs.lab05;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public Node findTail(Node current) {
        if (current.getNext() == null) {
            return current;
        }
        return findTail(current.getNext());
    }

    public void append(Node newNode) {
        Node lastNode = findTail(head);
        lastNode.setNext(newNode);
    }

    public void prepend(Node newNode) {
        newNode.setNext(head);
        head = newNode;
    }
}
