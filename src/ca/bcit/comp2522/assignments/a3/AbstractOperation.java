package ca.bcit.comp2522.assignments.a3;

import java.util.Objects;

/**
 * Parent class for various types of operations.
 *
 * @author Chloe Glave
 * @version 2020
 */
public abstract class AbstractOperation implements Operation {
     /**The type of operation to be used; add, subtract, multiply, or divide.*/
    protected char operationType;

    /**
     * Constructor.
     *
     * @param operationType char - the type of operation to be performed.
     */
    public AbstractOperation(final char operationType) {
        this.operationType = operationType;
    }

    /**
     * Gets the char representing the operation type.
     *
     * @return char - the operation to be performed.
     */
    public final char getSymbol() {
        return operationType;
    }

    //<editor-fold desc="toString, equals, hashcode">
    /**
     * Generates a string representation of the object.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "AbstractOperation{"
                + "operationType=" + operationType
                + '}';
    }

    /**
     * Determines whether this object is equal to another.
     *
     * @param o object - to be compared to this.
     * @return boolean - true if the objects are equal else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractOperation)) {
            return false;
        }
        AbstractOperation that = (AbstractOperation) o;
        return operationType == that.operationType;
    }

    /**
     * Generates a unique hashcode for this object.
     *
     * @return int - the object's hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(operationType);
    }
    //</editor-fold>
}
