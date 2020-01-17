package ca.bcit.comp2522.labs.lab01;
import java.util.Random;
import java.util.Scanner;

public class Hare {
    // todo: accessor and mutator for position, toString and equals method
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
            case 0: case 1: /*20% of the time the Hare sleeps and doesn’t move.*/
                System.out.println("hare does nothing"); // todo: remove these prints
                break;
            case 2: /*10% of the time the Hare take a big hop and moves forward 9 units.*/
                System.out.println("hare big hop");
                position += 9;
                break;
            case 3: /*10% of the time the Hare suffers a big slip and moves backward 12 units.*/
                System.out.println("hare big slip");
                position -= 12;
                break;
            case 4: case 5: case 6: /*30% of the time the Hare takes a small hop and moves forward 1 unit.*/
                System.out.println("hare small hop");
                position += 1;
                break;
            default: /*the rest of the time, the Hare suffers a small slip and moves backward 2 units.*/
                System.out.println("hare small slip");
                position -= 2;
                break;
        }
        System.out.println(position);
        return position;
    }

    public static void main(String[] args) {
        Hare myHare = new Hare();
        myHare.move();
    }
}
