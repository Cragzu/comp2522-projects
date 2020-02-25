package ca.bcit.comp2522.labs.lab04;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class Human implements Terrestrial, Aquatic {
    @Override
    public void swim() {
        System.out.println("sploosh");
    }

    @Override
    public void walk() {
        System.out.println("makin my way downtown");
    }
}
