package ca.bcit.comp2522.labs.lab01;
import java.util.Random;
import java.util.Scanner;

/**
 * Creates a slower-moving but consistent Tortoise for use in racing.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Tortoise {
    // todo: toString and equals method
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

        switch (result) {
            case 0: case 1: case 2: case 3: case 4: /*50% of the time the Tortoise moves forward 3 units (fast plod).*/
                setPosition(getPosition() + FAST_PLOD);
                break;
            case 5: case 6: /*20% of the time the Tortoise slips and moves backward 6 units.*/
                setPosition(getPosition() + SLIP);
                break;
            default: /*the rest of the time, the Tortoise moves forward 1 unit with a slow plod.*/
                setPosition(getPosition() + SLOW_PLOD);
                break;
        }
        return position;
    }
}