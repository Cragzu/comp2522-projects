package ca.bcit.comp2522.labs.lab06;

/**
 * Simple box.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Box<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}
