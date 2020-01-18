package ca.bcit.comp2522.labs.lab01;

public class Race {
    /*instance variables*/
    private int length;
    private Hare racerHare;
    private Tortoise racerTortoise;

    public Race(int givenLength) { /*constructor method for Race, sets length and creates racer objects*/
        length = givenLength;
        racerHare = new Hare();
        racerTortoise = new Tortoise();
    }

    // todo: public reset method that sets racer positions to 0



}
