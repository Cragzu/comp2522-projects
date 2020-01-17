package ca.bcit.comp2522.labs.lab01;
import java.util.Random;
import java.util.Scanner;

public class Hare {
    int position = 0;

    public void move() {
        final Random generator = new Random();
        final int answer = generator.nextInt(3) + 1;
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Hare myHare = new Hare();
        System.out.println(myHare.position);
    }
}
