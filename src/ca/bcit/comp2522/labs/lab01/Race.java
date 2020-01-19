package ca.bcit.comp2522.labs.lab01;
import java.util.Random;

/**
 * Creates a Race to pit two racers against one another.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Race {
    final static int STARTING_POSITION = 0;

    /*instance variables*/
    private int length;
    public Hare racerHare;
    public Tortoise racerTortoise;

    /**
     * Constructor.
     *
     * @param givenLength the length of the race
     */
    public Race(int givenLength) { /*constructor method for Race, sets length and creates racer objects*/
        length = givenLength;
        racerHare = new Hare();
        racerTortoise = new Tortoise();
    }

    /**
     * Sets the positions of the two racers to the starting position, resetting the race.
     */
    public void reset() {
        racerHare.setPosition(STARTING_POSITION);
        racerTortoise.setPosition(STARTING_POSITION);
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
                System.out.println("T first");
                racerTortoise.move();
                racerHare.move();
            } else {
                System.out.println("H first");
                racerHare.move();
                racerTortoise.move();
            }
        } while (racerHare.getPosition() < length && racerTortoise.getPosition() < length);

        if (racerHare.getPosition() >= length) {
            // todo: remove prints
            System.out.println("Hare wins");
            return "Hare";
        } else {
            System.out.println("Tortoise wins");
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
