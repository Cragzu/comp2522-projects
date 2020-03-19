package ca.bcit.comp2522.labs.lab06;

import java.util.Objects;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class Node<T> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(getData(), node.getData()) &&
                Objects.equals(getNext(), node.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getNext());
    }
}
