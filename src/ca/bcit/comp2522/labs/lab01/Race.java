package ca.bcit.comp2522.labs.lab01;
import java.util.Random;

/**
 * Creates a Race to pit two racers against one another.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Race {
    /**The starting position of the race.*/
    static final int STARTING_POSITION = 0;

    /**Number of ticks (rounds of movements elapsed in the race.*/
    private int numOfTicks;

    /**A hare object for use in the race.*/
    private Hare racerHare;

    /**A tortoise object for use in the race.*/
    private Tortoise racerTortoise;

    private int length;

    /**
     * Constructor.
     *
     * @param givenLength the length of the race
     */
    public Race(int givenLength) {
        length = givenLength;
        racerHare = new Hare();
        racerTortoise = new Tortoise();
    }

    /**
     * Gets the Hare object being used in the race.
     *
     * @return the racer Hare.
     */
    public Hare getRacerHare() {
        return racerHare;
    }

    /**
     * Gets the Tortoise object being used in the race.
     *
     * @return the racer Tortoise.
     */
    public Tortoise getRacerTortoise() {
        return racerTortoise;
    }

    /**
     * Gets the number of ticks (rounds of movement) elapsed in the current race.
     *
     * @return the number of ticks.
     */
    public int getNumOfTicks() {
        return numOfTicks;
    }

    /**
     * Sets the positions of the two racers to the starting position, resetting the race.
     */
    public void reset() {
        racerHare.setPosition(STARTING_POSITION);
        racerTortoise.setPosition(STARTING_POSITION);
        numOfTicks = 0;
    }

    /**
     * Moves the two racers repeatedly until one reaches the end of the race.
     *
     * @return a string representation of the winner, either Tortoise or Hare.
     */
    private String race() {
        do {
            Random generator = new Random();
            int coinFlip = generator.nextInt(2); /*generate num 0 or 1 to determine first racer*/
            if (coinFlip == 0) {
                racerTortoise.move();
                racerHare.move();
            } else {
                racerHare.move();
                racerTortoise.move();
            }
            numOfTicks++;
        } while (racerHare.getPosition() < length && racerTortoise.getPosition() < length);

        if (racerHare.getPosition() >= length) {
            return "Hare";
        } else {
            return "Tortoise";
        }
    }

    /**
     * Simulates a race between the Tortoise and the Hare.
     *
     * @return a string representation of the winner, either Tortoise or Hare.
     */
    public String simulateRace() {
        reset(); // ensure racers are at the starting line
        return race();
    }
}
