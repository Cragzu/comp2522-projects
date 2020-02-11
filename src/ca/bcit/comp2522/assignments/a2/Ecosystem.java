package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Iterator;
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

        while (it.hasNext()) {
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

        while (it.hasNext()) {
            Pool currentPool = it.next();
            totalGuppiesExtinguished += currentPool.adjustForCrowding();
        }
        return totalGuppiesExtinguished;
    }

    //<editor-fold desc="Three pools creation methods">
    /**
     * Populates a pool with guppies that have certain properties.
     *
     * @param pool the Pool to add the Guppies to.
     * @param numOfGuppies the number of Guppies to add.
     * @param minGuppyAge the lower bound for each Guppy's randomly generated age.
     * @param maxGuppyAge the upper bound for each Guppy's randomly generated age.
     * @param minGuppyHealth the lower bound for each Guppy's randomly generated health coefficient.
     * @param maxGuppyHealth the upper bound for each Guppy's randomly generated health coefficient.
     * @param femalePercentChance the percent chance that a Guppy will be female.
     */
    public void addGeneratedGuppies(final Pool pool, final int numOfGuppies, final int minGuppyAge,
                                    final int maxGuppyAge, final double minGuppyHealth,
                                    final double maxGuppyHealth, final double femalePercentChance) {
        for (int i = 0; i < numOfGuppies; i++) {
            int guppyAge = new Random().nextInt(maxGuppyAge - minGuppyAge) + minGuppyAge;
            double guppyHealth = minGuppyHealth
                    + (new Random().nextDouble() * (maxGuppyHealth - minGuppyHealth));
            double femaleGenerator = new Random().nextDouble();
            boolean isFemale = femaleGenerator <= femalePercentChance;

            Guppy currentGuppy = new Guppy("Poecilia", "reticulata", guppyAge,
                    isFemale, 1, guppyHealth);
            pool.addGuppy(currentGuppy);
        }
    }

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

        addGeneratedGuppies(skookumchuk, numOfGuppies, minGuppyAge, maxGuppyAge, minGuppyHealth,
                maxGuppyHealth, femalePercentChance);

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
        final int numOfGuppies = 100;
        final int minGuppyAge = 10;
        final int maxGuppyAge = 15;
        final double minGuppyHealth = 0.8;
        final double maxGuppyHealth = 1.0;
        final double femalePercentChance = 0.75;

        Pool squamish =  new Pool(name, volumeLitres, tempCelsius, pH, nutrientCoefficient);

        addGeneratedGuppies(squamish, numOfGuppies, minGuppyAge, maxGuppyAge, minGuppyHealth,
                maxGuppyHealth, femalePercentChance);

        return squamish;
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
        final int numOfGuppies = 200;
        final int minGuppyAge = 15;
        final int maxGuppyAge = 49;
        final double minGuppyHealth = 0.0;
        final double maxGuppyHealth = 1.0;
        final double femalePercentChance = 0.35;

        Pool semiahmoo =  new Pool(name, volumeLitres, tempCelsius, pH, nutrientCoefficient);

        addGeneratedGuppies(semiahmoo, numOfGuppies, minGuppyAge, maxGuppyAge, minGuppyHealth,
                maxGuppyHealth, femalePercentChance);

        return semiahmoo;
    }
    //</editor-fold>

    /**
     * Sets up a simulation of an Ecosystem; creating Pools and adding them to the Ecosystem.
     */
    public void setupSimulation() {
        Pool skookumchuk = createSkookumchukPool();
        Pool squamish = createSquamishPool();
        Pool semiahmoo = createSemiahmooPool();

        this.addPool(skookumchuk);
        this.addPool(squamish);
        this.addPool(semiahmoo);
    }

    /**
     * Increments the ages of every Guppy in every Pool in the Ecosystem.
     *
     * @return the number of guppies that have died of old age.
     */
    public int incrementAges() {
        int diedOfOldAge = 0;
        Iterator<Pool> it = pools.iterator();

        while (it.hasNext()) {
            Pool currentPool = it.next();
            diedOfOldAge += currentPool.incrementAges();
        }
        return diedOfOldAge;
    }

    /**
     * Removes all the dead guppies from every Pool in the Ecosystem.
     *
     * @return the number of guppies removed.
     */
    public int removeDeadGuppies() {
        int guppiesRemoved = 0;
        Iterator<Pool> it = pools.iterator();

        while (it.hasNext()) {
            Pool currentPool = it.next();
            guppiesRemoved += currentPool.removeDeadGuppies();
        }
        return guppiesRemoved;
    }

    /**
     * Applies nutrient coefficient to every Guppy in every Pool in the Ecosystem.
     *
     * @return the number of Guppies that have starved to death.
     */
    public int applyNutrientCoefficient() {
        int starvedGuppies = 0;
        Iterator<Pool> it = pools.iterator();

        while (it.hasNext()) {
            Pool currentPool = it.next();
            starvedGuppies += currentPool.applyNutrientCoefficient();
        }
        return starvedGuppies;
    }

    /**
     * Spawns every Guppy in every Pool in the Ecosystem.
     *
     * @return the number of new Guppies created.
     */
    public int spawn() {
        int newGuppies = 0;
        Iterator<Pool> it = pools.iterator();

        while (it.hasNext()) {
            Pool currentPool = it.next();
            newGuppies += currentPool.spawn();
        }
        return newGuppies;
    }

    /**
     * Simulates one week in the Ecosystem.
     */
    public void simulateOneWeek() {
        int diedOfOldAge = this.incrementAges();
        int numberRemoved = this.removeDeadGuppies();
        int starvedToDeath = this.applyNutrientCoefficient();
        numberRemoved += this.removeDeadGuppies();
        int newFry = this.spawn();
        int crowdedOut = this.adjustForCrowding();
        numberRemoved += this.removeDeadGuppies();

        if (numberRemoved != diedOfOldAge + starvedToDeath + crowdedOut) {
            System.out.println("Logic error! Those guppy deaths don't add up."
                    + "\nOld age: " + diedOfOldAge + "\nStarved: " +  starvedToDeath
                    + "Crowded: " + crowdedOut + "\nTotal removed: " + numberRemoved);
        }

        System.out.println("Deaths due to old age: " + diedOfOldAge);
        System.out.println("Deaths due to starvation: " + starvedToDeath);
        System.out.println("Deaths due to overcrowding: " + crowdedOut);
        System.out.println("New fry born this week: " + newFry);

        Iterator<Pool> it = pools.iterator();
        while (it.hasNext()) {
            Pool currentPool = it.next();
            System.out.println(currentPool.getName() + " population: "
                    + currentPool.getPopulation());
        }

        System.out.println("Total ecosystem population: " + this.getPopulation() + "\n\n");

    }

    /**
     * Simulates a given number of weeks in the Ecosystem.
     *
     * @param numOfWeeks the number of weeks to simulate.
     */
    public void simulate(final int numOfWeeks) {
        for (int i = 1; i <= numOfWeeks; i++) {
            System.out.println("~~Week " + i + " Data~~\n");
            simulateOneWeek();
        }
    }
}
