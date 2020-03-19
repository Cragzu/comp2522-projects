package ca.bcit.comp2522.lectures.week06;

public class FullStackException extends RuntimeException {

    public FullStackException() {
        this("Stack is full");
    }

    public FullStackException(String exception) {
        super(exception);
    }
}
