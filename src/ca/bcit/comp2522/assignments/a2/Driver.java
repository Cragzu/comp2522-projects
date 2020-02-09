package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

/**
 * Driver for the Guppy/Pool/Ecosystem simulation.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many weeks should the simulation run?: ");
        int numOfWeeks = input.nextInt();

        Ecosystem myEco = new Ecosystem();
        myEco.setupSimulation();
        myEco.simulate(numOfWeeks);
    }
}
