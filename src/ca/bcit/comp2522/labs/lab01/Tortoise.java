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
    private int position = 0;

    public int getPosition() {
        return position;
    }
    public void setPosition(int newPosition) {
        position = newPosition;
    }

    public int move() {
        final Random generator = new Random();
        final int result = generator.nextInt(10) + 1; /*generate random num between 0-9*/

        switch (result) {
            case 0: case 1: case 2: case 3: case 4: /*50% of the time the Tortoise moves forward 3 units (fast plod).*/
                System.out.println("Tortoise plods fast"); // todo: remove these prints
                position += 3;
                break;
            case 5: case 6: /*20% of the time the Tortoise slips and moves backward 6 units.*/
                System.out.println("Tortoise slips back");
                position -= 6;
                break;
            default: /*the rest of the time, the Tortoise moves forward 1 unit with a slow plod.*/
                System.out.println("Tortoise plods slowly");
                position += 1;
                break;
        }
        System.out.println(position);
        return position;
    }

    public static void main(String[] args) {
        Tortoise myTortoise = new Tortoise();
        myTortoise.move();
    }
}
