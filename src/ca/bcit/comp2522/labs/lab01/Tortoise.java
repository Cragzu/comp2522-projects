package ca.bcit.comp2522.labs.lab01;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Creates a slower-moving but consistent Tortoise for use in racing.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Tortoise {
    final static int FAST_PLOD_LOWER_BOUND = 0;
    final static int FAST_PLOD_UPPER_BOUND = 4;
    final static int SLIP_LOWER_BOUND = 5;
    final static int SLIP_UPPER_BOUND = 6;

    final static int FAST_PLOD = 3;
    final static int SLIP = -6;
    final static int SLOW_PLOD = 1;

    private int position = 0;

    /**
     * Gets the tortoise's current position as an int.
     *
     * @return the current position of the tortoise.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Updates the tortoise's current position.
     *
     * @param newPosition the new position.
     */
    public void setPosition(int newPosition) {
        position = newPosition;
    }

    /**
     * Moves the tortoise once.
     *
     * @return the position of the tortoise after one movement.
     */
    public int move() {
        final Random generator = new Random();
        final int result = generator.nextInt(10) + 1; /*generate random num between 0-9*/
        if (result >= FAST_PLOD_LOWER_BOUND && result <= FAST_PLOD_UPPER_BOUND) {
            setPosition(getPosition() + FAST_PLOD);
        }
        else if (result >= SLIP_LOWER_BOUND && result <= SLIP_UPPER_BOUND) {
            setPosition(getPosition() + SLIP);
        }
        else {
            setPosition(getPosition() + SLOW_PLOD);
        }
        return getPosition();
    }

    /**
     * Creates a string providing information about the tortoise.
     *
     * @return a formatted string describing the tortoise.
     */
    @Override
    public String toString() {
        return "Tortoise{" +
                "position=" + position +
                '}';
    }

    /**
     * Compares the tortoise to another object and determines whether they are equal.
     *
     * @param o object to compare to this tortoise
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Tortoise)) return false;
        Tortoise tortoise = (Tortoise) o;
        return getPosition() == tortoise.getPosition();
    }
    
}
