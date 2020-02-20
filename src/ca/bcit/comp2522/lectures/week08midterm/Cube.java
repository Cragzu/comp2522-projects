package ca.bcit.comp2522.lectures.week08midterm;

import java.util.Random;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class Cube {
    private int x;
    private int y;
    private int z;
    private double value;

    public Cube(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = new Random().nextDouble();

    }

}
