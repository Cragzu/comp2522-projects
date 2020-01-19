package ca.bcit.comp2522.labs.lab01;
import java.util.Random;
import java.util.Scanner;

/**
 * Creates a quick-moving but sporadic Hare for use in racing.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Hare {
    // todo: toString and equals method
    final static int BIG_HOP = 9;
    final static int BIG_SLIP = -12;
    final static int SMALL_HOP = 1;
    final static int SMALL_SLIP = -2;

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

        switch (result) {
            case 0: case 1: /*20% of the time the Hare sleeps and doesn’t move.*/
                break;
            case 2: /*10% of the time the Hare take a big hop and moves forward 9 units.*/
                setPosition(getPosition() + BIG_HOP);
                break;
            case 3: /*10% of the time the Hare suffers a big slip and moves backward 12 units.*/
                setPosition(getPosition() + BIG_SLIP);
                break;
            case 4: case 5: case 6: /*30% of the time the Hare takes a small hop and moves forward 1 unit.*/
                setPosition(getPosition() + SMALL_HOP);
                break;
            default: /*the rest of the time, the Hare suffers a small slip and moves backward 2 units.*/
                setPosition(getPosition() + SMALL_SLIP);
                break;
        }
        return position;
    }
}
