package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class Node {
    private Object data;
    private Node next;

    public Node(final Object data) {
        this.data = data;
        this.next = null;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(getData(), node.getData()) &&
                Objects.equals(getNext(), node.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getNext());
    }
}
