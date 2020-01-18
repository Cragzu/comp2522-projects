package ca.bcit.comp2522.labs.lab01;

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
     *
     */
    public void reset() {
        // todo: use const instead of 0?
        racerHare.setPosition(0);
        racerTortoise.setPosition(0);
    }



}
