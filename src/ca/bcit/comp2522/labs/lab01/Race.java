package ca.bcit.comp2522.labs.lab01;
import java.util.Random;

/**
 * Creates a Race to pit two racers against one another.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Race {
    /*instance variables*/
    private int length;
    private Hare racerHare;
    private Tortoise racerTortoise;

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
     * Sets the positions of the two racers to 0, resetting the race.
     */
    public void reset() {
        // todo: use const instead of 0?
        racerHare.setPosition(0);
        racerTortoise.setPosition(0);
    }

    /**
     * Moves the two racers repeatedly until one reaches the end of the race.
     *
     * @return a string representation of the winner, either Tortoise or Hare.
     */
    private String race() {
        Random generator;
        int coinFlip;
        // keep racing them while tortoise pos and hare pos less than race length

        do {
            generator = new Random();
            coinFlip = generator.nextInt(1) + 1; /*generate num 0 or 1 to determine first racer*/
            switch (coinFlip) {
                case 0:
                    System.out.println("T first");
                    racerTortoise.move();
                    racerHare.move();
                    break;
                case 1:
                    System.out.println("H first");
                    racerHare.move();
                    racerTortoise.move();
                    break;
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
