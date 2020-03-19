package ca.bcit.comp2522.labs.lab06;

/**
 * An exception thrown if a LinkedList is empty
 *
 * @author Chloe Glave A01166947
 * @author C. Fernandes A01182058
 * @version 2020
 */
public class EmptyListException extends Exception{
    private String message;

    public EmptyListException(final String message) {
        this.message = message;
    }
}
