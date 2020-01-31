package ca.bcit.comp2522.labs.lab03;

import java.util.Scanner;

/**
 * Demonstrates the Tree and Plantation classes.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Driver {
    /**The number of times to seed the farm in this demonstration.*/
    static final int NUM_OF_PLANTING_ROUNDS = 5;



    public static void main(String[] args) {

        Plantation lotusLandLumber = new Plantation();

        for (int plantingRounds = 0; plantingRounds < NUM_OF_PLANTING_ROUNDS; plantingRounds++) {
            lotusLandLumber.seed();
        }
        System.out.println("Lotus Land Lumber has " + lotusLandLumber.size() + " trees");

//        final Scanner titleScanner = new Scanner(System.in);
//        System.out.print("What circumference should a tree have to be ready for harvest?: ");

//        final double inputCircumference = titleScanner.nextDouble();

//        int harvest = lotusLandLumber.harvestCount(inputCircumference);
        int harvest = lotusLandLumber.harvestCount(50.0);
        System.out.println(harvest + " trees were harvested!");

    }
}
