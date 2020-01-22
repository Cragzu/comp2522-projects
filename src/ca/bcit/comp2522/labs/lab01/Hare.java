package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Creates a quick-moving but sporadic Hare for use in racing.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Hare {
    /**Value for the percent chance of hare moving with a big hop.*/
    static final int BIG_HOP_CHANCE = 2;

    /**Value for the percent chance of hare moving with a big slip.*/
    static final int BIG_SLIP_CHANCE = 3;

    /**Lower bound for the percent chance of hare moving with a small hop.*/
    static final int SMALL_HOP_LOWER_BOUND = 4;

    /**Upper bound for the percent chance of hare moving with a small hop.*/
    static final int SMALL_HOP_UPPER_BOUND = 6;

    /**Lower bound for the percent chance of hare moving with a small slip.*/
    static final int SMALL_SLIP_LOWER_BOUND = 7;

    /**Upper bound for the percent chance of hare moving with a small slip.*/
    static final int SMALL_SLIP_UPPER_BOUND = 9;

    /**Distance travelled for the hare's big hop.*/
    static final int BIG_HOP = 9;

    /**Distance travelled for the hare's big slip.*/
    static final int BIG_SLIP = -12;

    /**Distance travelled for the hare's small hop.*/
    static final int SMALL_HOP = 1;

    /**Distance travelled for the hare's small slip.*/
    static final int SMALL_SLIP = -2;

    private int position = 0;

    /**
     * Gets the hare's current position as an int.
     *
     * @return the current position of the hare.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Updates the hare's current position.
     *
     * @param newPosition the new position.
     */
    public void setPosition(int newPosition) {
        position = newPosition;
    }

    /**
     * Moves the hare once.
     *
     * @return the position of the hare after one movement.
     */
    public int move() {
        final Random generator = new Random();
        final int result = generator.nextInt(10) + 1; /*generate random num between 0-9*/

        /*20% of the time, do nothing.*/
        if (result == BIG_HOP_CHANCE) {
            setPosition(getPosition() + BIG_HOP);
        } else if (result == BIG_SLIP_CHANCE) {
            setPosition(getPosition() + BIG_SLIP);
        } else if (result >= SMALL_HOP_LOWER_BOUND && result <= SMALL_HOP_UPPER_BOUND) {
            setPosition(getPosition() + SMALL_HOP);
        } else if (result >= SMALL_SLIP_LOWER_BOUND && result <= SMALL_SLIP_UPPER_BOUND) {
            setPosition(getPosition() + SMALL_SLIP);
        }
        return position;
    }

    /**
     * Creates a string providing information about the hare.
     *
     * @return a formatted string describing the hare.
     */
    @Override
    public String toString() {
        return "Hare{"
                + "position="
                + position
                + '}';
    }

    /**
     * Compares the hare to another object and determines whether they are equal.
     *
     * @param o object to compare to this hare
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Hare)) {
            return false;
        }
        Hare hare = (Hare) o;
        return getPosition() == hare.getPosition();
    }

}
