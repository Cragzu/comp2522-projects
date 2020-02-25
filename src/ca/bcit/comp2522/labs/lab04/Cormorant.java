package ca.bcit.comp2522.labs.lab04;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class Cormorant implements Aerial, Terrestrial, Aquatic {
    @Override
    public void fly() {
        System.out.println("swoosh");
    }

    @Override
    public void swim() {
        System.out.println("dive");
    }

    @Override
    public void walk() {
        System.out.println("waddle");
    }
}
