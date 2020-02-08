package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

/**
 * Simulates an ecosystem of Guppies and Pools.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Ecosystem {

    //<editor-fold desc="Instance variable and constructor">
    private ArrayList<Pool> pools;

    public Ecosystem() {
        this.pools = new ArrayList<>();
    }
    //</editor-fold>

    /**
     * Adds a pool to the pools in the ecosystem, as long as it is not null.
     *
     * @param newPool the pool to be added.
     */
    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    /**
     * Resets the ecosystem, clearing out all existing pools.
     */
    public void reset() {
        pools.clear();
    }

    /**
     * Determines the total number of living guppies in the entire ecosystem.
     *
     * @return the population of the ecosystem.
     */
    public int getPopulation() {
        int totalPopulation = 0;
        Iterator<Pool> it = pools.iterator();

        while(it.hasNext()) {
            Pool currentPool = it.next();
            totalPopulation += currentPool.getPopulation();
        }
        return totalPopulation;
    }

    /**
     * Extinguishes the weakest guppies in all pools in the ecosystem that have been crowded out.
     *
     * @return the number of perished guppies.
     */
    public int adjustForCrowding() {
        int totalGuppiesExtinguished = 0;
        Iterator<Pool> it = pools.iterator();

        while(it.hasNext()) {
            Pool currentPool = it.next();
            totalGuppiesExtinguished += currentPool.adjustForCrowding();
        }
        return totalGuppiesExtinguished;
    }

    //<editor-fold desc="Three pools creation methods">
    /**
     * Creates the Skookumchuk pool for use in the Ecosystem simulation.
     *
     * @return the new pool.
     */
    public Pool createSkookumchukPool() {
        final String name = "Skookumchuk";
        final int volumeLitres = 3000;
        final int tempCelsius = 42;
        final double pH = 7.9;
        final double nutrientCoefficient = 0.9;
        final int numOfGuppies = 300;
        final int minGuppyAge = 10;
        final int maxGuppyAge = 25;
        final double minGuppyHealth = 0.5;
        final double maxGuppyHealth = 0.8;
        final double femalePercentChance = 0.75;

        Pool skookumchuk = new Pool(name, volumeLitres, tempCelsius, pH, nutrientCoefficient);

        for (int i = 0; i < numOfGuppies; i++) {
            int guppyAge = new Random().nextInt(maxGuppyAge - minGuppyAge) + maxGuppyAge;
            double guppyHealth = minGuppyHealth
                    + (new Random().nextDouble() * (maxGuppyHealth - minGuppyHealth));
            double femaleGenerator = new Random().nextDouble();
            boolean isFemale = femaleGenerator <= femalePercentChance;

            Guppy currentGuppy = new Guppy("Poecilia", "reticulata", guppyAge,
                    isFemale, 1, guppyHealth);
            skookumchuk.addGuppy(currentGuppy);
        }

        return skookumchuk;
    }

    /**
     * Creates the Squamish pool for use in the Ecosystem simulation.
     *
     * @return the new pool.
     */
    public Pool createSquamishPool() {
        final String name = "Squamish";
        final int volumeLitres = 15000;
        final int tempCelsius = 39;
        final double pH = 7.7;
        final double nutrientCoefficient = 0.85;

        return new Pool(name, volumeLitres, tempCelsius, pH, nutrientCoefficient);
    }

    /**
     * Creates the Semiahmoo pool for use in the Ecosystem simulation.
     *
     * @return the new pool.
     */
    public Pool createSemiahmooPool() {
        final String name = "Semiahmoo";
        final int volumeLitres = 4500;
        final int tempCelsius = 37;
        final double pH = 7.5;
        final double nutrientCoefficient = 1.0;

        return new Pool(name, volumeLitres, tempCelsius, pH, nutrientCoefficient);
    }
    //</editor-fold>

    /**
     * Runs a simulation of an Ecosystem.
     */
    public void setupSimulation() {
        Pool skookumchuk = createSkookumchukPool();
        Pool squamish = createSquamishPool();
        Pool semiahmoo = createSemiahmooPool();

        this.addPool(skookumchuk);
        this.addPool(squamish);
        this.addPool(semiahmoo);


    }

    public static void main(String[] args) {
        Ecosystem myEco = new Ecosystem();
        Pool myPool = new Pool();
    }


}
