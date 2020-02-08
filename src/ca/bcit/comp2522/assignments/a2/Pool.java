package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Creates a Pool object to house Guppies.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Pool {
    //<editor-fold desc="Constants">
    /**The default name for a pool.*/
    static final String DEFAULT_POOL_NAME = "Unnamed";

    /**The default pool temperature in degrees Celsius.*/
    static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;

    /**The minimum temperature a pool can be in degrees Celsius.*/
    static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;

    /**The maximum temperature a pool can be in degrees Celsius.*/
    static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;

    /**The value of a neutral pH level.*/
    static final double NEUTRAL_PH = 7.0;

    /**The value of the highest possible pH level.*/
    static final double MAXIMUM_PH = 14.0;

    /**The default nutrient coefficient in a pool.*/
    static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;

    /**The minimum nutrient coefficient a pool can have.*/
    static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;

    /**The maximum nutrient coefficient a pool can have.*/
    static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

    /**The number of millilitres in one litre.*/
    static final double ML_TO_L_CONVERSION = 1000.0;
    //</editor-fold>

    //<editor-fold desc="Instance variables">
    private static int numberOfPools = 0;
    private final String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private final int identificationNumber;
    private final ArrayList<Guppy> guppiesInPool;
    private Random randomNumberGenerator;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    /**
     * Default constructor.
     */
    public Pool() {
        /*Call multi-param constructor, passing default values.*/
        this(DEFAULT_POOL_NAME, 0.0, DEFAULT_POOL_TEMP_CELSIUS,
                NEUTRAL_PH, DEFAULT_NUTRIENT_COEFFICIENT);
    }

    /**
     * Multi-parameter constructor.
     *
     * @param name the name of the pool.
     * @param volumeLitres the volume of water in the pool in litres.
     * @param temperatureCelsius the temperature of the pool in degrees Celsius.
     * @param pH the pH level of the pool.
     * @param nutrientCoefficient the nutrient coefficient of the pool.
     */
    public Pool(final String name, final double volumeLitres, final double temperatureCelsius,
                final double pH, final double nutrientCoefficient) {
        numberOfPools++;
        identificationNumber = numberOfPools;

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = Guppy.toTitleCase(name);
        }

        this.volumeLitres = Math.max(volumeLitres, 0.0);

        if (temperatureCelsius > MAXIMUM_POOL_TEMP_CELSIUS
        || temperatureCelsius < MINIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        } else {
            this.temperatureCelsius = temperatureCelsius;
        }

        if (pH < 0.0 || pH > MAXIMUM_PH) {
            this.pH = NEUTRAL_PH;
        } else {
            this.pH = pH;
        }

        if (nutrientCoefficient < MINIMUM_NUTRIENT_COEFFICIENT
                || nutrientCoefficient > MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        } else {
            this.nutrientCoefficient = nutrientCoefficient;
        }

        guppiesInPool = new ArrayList<Guppy>();
        randomNumberGenerator = new Random();
    }
    //</editor-fold>

    //<editor-fold desc="Accessors">
    /**
     * Returns the name of the pool.
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the volume of water in the pool in litres.
     *
     * @return the pool volume.
     */
    public double getVolumeLitres() {
        return volumeLitres;
    }

    /**
     * Returns the temperature of the pool in degrees Celsius.
     *
     * @return the temperature.
     */
    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     * Returns the pH level of the pool.
     *
     * @return the pH.
     */
    public double getPH() {
        return pH;
    }

    /**
     * Returns the nutrient coefficient of the pool.
     *
     * @return the nutrient coefficient.
     */
    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    /**
     * Returns the identification number of the pool.
     *
     * @return the ID number.
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Returns the total number of pools created.
     *
     * @return the number of pools.
     */
    public static int getNumberCreated() {
        return numberOfPools;
    }

    /**
     * Returns the number of guppies currently in the pool.
     *
     * @return the number of guppies in the pool.
     */
    public int getPopulation() {
        int population = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) {
            Guppy currentGuppy = it.next();
            if (currentGuppy.getIsAlive()) {
                population++;
            }
        }
        return population;
    }

    /**
     * Calculates the average age in weeks of guppies in the pool.
     *
     * @return the average age of the pool inhabitants.
     */
    public double getAverageAgeInWeeks() {
        double cumulativeAges = 0.0;
        int population = this.getPopulation();
        if (guppiesInPool.size() == 0) { /*check for divide by 0 issue*/
            return cumulativeAges;
        }
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) {
            Guppy currentGuppy = it.next();
            cumulativeAges += currentGuppy.getAgeInWeeks();
        }
        return (population == 0) ? population : cumulativeAges / this.getPopulation();
    }

    /**
     * Calculates the average health coefficient of guppies in the pool.
     *
     * @return the average health coefficient of the pool inhabitants.
     */
    public double getAverageHealthCoefficient() {
        double cumulativeHealth = 0.0;
        int population = this.getPopulation();
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) {
            Guppy currentGuppy = it.next();
            if (currentGuppy.getIsAlive()) {
                cumulativeHealth += currentGuppy.getHealthCoefficient();
            }
        }
        return (population == 0) ? population : cumulativeHealth / population;
    }

    /**
     * Calculates the percentage of female guppies out of the total population.
     *
     * @return the percentage of guppies that are female.
     */
    public double getFemalePercentage() {
        double numberOfFemales = 0;
        int population = this.getPopulation();
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) {
            Guppy currentGuppy = it.next();
            if (currentGuppy.getIsFemale()) {
                numberOfFemales++;
            }
        }
        return (population == 0) ? population : numberOfFemales / population;
    }

    /**
     * Determines the median age of guppies in the pool.
     *
     * @return the median age of the pool inhabitants.
     */
    public double getMedianAge() {
        ArrayList<Integer> guppyAges = new ArrayList<>();

        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy currentGuppy = it.next();
            guppyAges.add(currentGuppy.getAgeInWeeks());
        }
        System.out.println(guppyAges);

        int middleOfList = Math.floorDiv(guppyAges.size(), 2);

        return guppyAges.get(middleOfList);

    }
    //</editor-fold>

    //<editor-fold desc="Mutators">
    /**
     * Updates the volume of the pool.
     *
     * @param volumeLitres the new volume.
     */
    public void setVolumeLitres(final double volumeLitres) {
        if (volumeLitres >= 0.0) {
            this.volumeLitres = volumeLitres;
        }
    }

    /**
     * Updates the temperature of the pool.
     *
     * @param temperatureCelsius the new temperature.
     */
    public void setTemperatureCelsius(final double temperatureCelsius) {
        if (temperatureCelsius >= MINIMUM_POOL_TEMP_CELSIUS
        && temperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = temperatureCelsius;
        }
    }

    /**
     * Updates the pH level of the pool.
     *
     * @param pH the new pH.
     */
    public void setPH(final double pH) {
        if (pH >= 0.0 && pH <= MAXIMUM_PH) {
            this.pH = pH;
        }
    }

    /**
     * Updates the nutrient coefficient of the pool.
     *
     * @param nutrientCoefficient the new nutrient coefficient.
     */
    public void setNutrientCoefficient(final double nutrientCoefficient) {
        if (nutrientCoefficient >= MINIMUM_NUTRIENT_COEFFICIENT
        && nutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = nutrientCoefficient;
        }
    }
    //</editor-fold>

    /**
     * Modifies the nutrient coefficient by the given value delta.
     *
     * @param delta the value to add to the current nutrient coefficient.
     */
    public void changeNutrientCoefficient(final double delta) {
        if (getNutrientCoefficient() + delta > MAXIMUM_NUTRIENT_COEFFICIENT) {
            setNutrientCoefficient(MAXIMUM_NUTRIENT_COEFFICIENT);
        } else {
            setNutrientCoefficient(Math.max(getNutrientCoefficient() + delta,
                    MINIMUM_NUTRIENT_COEFFICIENT));
        }
    }

    /**
     * Modifies the temperature by the given value delta.
     *
     * @param delta the value to add to the current temperature.
     */
    public void changeTemperature(final double delta) {
        if (getTemperatureCelsius() + delta > MAXIMUM_POOL_TEMP_CELSIUS) {
            setTemperatureCelsius(MAXIMUM_POOL_TEMP_CELSIUS);
        } else {
            setTemperatureCelsius(Math.max(getTemperatureCelsius() + delta,
                    MINIMUM_POOL_TEMP_CELSIUS));
        }
    }

    /**
     * Adds a guppy to the pool.
     *
     * @param guppy the new guppy to be added to the pool.
     * @return a bool representing whether the addition was successful.
     */
    public boolean addGuppy(final Guppy guppy) {
        if (guppy == null) {
            return false;
        }
        guppiesInPool.add(guppy);
        return true;
    }

    /**
     * Calculates which guppies in the pool have died from malnutrition.
     * Generates a random double for each guppy and compares it to the pool's nutrient coefficient
     * to determine whether that guppy lives.
     *
     * @return the number of guppies that have perished.
     */
    public int applyNutrientCoefficient() {
        int deadGuppyCount = 0;

        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy currentGuppy = it.next();

            randomNumberGenerator = new Random();
            double generatedDouble = randomNumberGenerator.nextDouble();

            if (generatedDouble > this.getNutrientCoefficient()) {
                currentGuppy.setIsAlive(false);
                deadGuppyCount++;
            }
        }
        return deadGuppyCount;
    }

    /**
     * Removes all dead guppies from the pool.
     *
     * @return the number of removed corpses.
     */
    public int removeDeadGuppies() {
        int removedGuppiesCount = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) {
            Guppy currentGuppy = it.next();

            if (!currentGuppy.getIsAlive()) {
                it.remove();
                removedGuppiesCount++;
            }
        }
        return removedGuppiesCount;
    }

    /**
     * Calculates the total volume of water in litres required by all guppies in the pool.
     *
     * @return the required volume of water.
     */
    public double getGuppyVolumeRequirementInLitres() {
        double volumeNeededInML = 0.0;
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) { /*get volume in mL for each guppy*/
            Guppy currentGuppy = it.next();
            volumeNeededInML += currentGuppy.getVolumeNeeded();
        }
        return volumeNeededInML / ML_TO_L_CONVERSION; /*convert to litres*/
    }

    /**
     * Attempts to spawn all guppies in the pool.
     * Spawns each eligible guppy in the pool, and adds all newborn fry into the pool.
     *
     * @return the number of fry born.
     */
    public int spawn() {
        int totalNumOfFryBorn = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) {
            Guppy mother = it.next();
            ArrayList<Guppy> newBabies = mother.spawn();
            if (newBabies != null) {
                totalNumOfFryBorn += newBabies.size();
                guppiesInPool.addAll(newBabies);
            }
        }
        return totalNumOfFryBorn;
    }

    /**
     * Increments the age of every guppy in the pool.
     *
     * @return the number of guppies that have died of old age.
     */
    public int incrementAges() {
        int deadGuppyCount = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) {
            Guppy currentGuppy = it.next();
            currentGuppy.incrementAge();
            if (!currentGuppy.getIsAlive()) {
                deadGuppyCount++;
            }
        }
        return deadGuppyCount;
    }

    /**
     * Finds the weakest guppy in the pool; the one with the lowest health coefficient.
     *
     * @return the weakest Guppy.
     */
    public Guppy getWeakestGuppy() { // todo: unit tests for this
        Guppy weakestGuppy = guppiesInPool.get(0);
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) {
            Guppy currentGuppy = it.next();
            if (currentGuppy.getHealthCoefficient() < weakestGuppy.getHealthCoefficient()
            && currentGuppy.getIsAlive()) {
                weakestGuppy = currentGuppy;
            }
        }
        return weakestGuppy;
    }

    /**
     * Extinguishes the weakest guppies that have died from overcrowding.
     *
     * @return the number of guppies that have perished.
     */
    public int adjustForCrowding() {
        int deadGuppyCount = 0;
        Guppy weakestGuppy;

        double volumeNeeded = this.getGuppyVolumeRequirementInLitres();
        while (volumeNeeded > this.getVolumeLitres()) {
            weakestGuppy = getWeakestGuppy();
            weakestGuppy.setIsAlive(false);

            deadGuppyCount++;
            volumeNeeded = this.getGuppyVolumeRequirementInLitres();
        }
        return deadGuppyCount;
    }

    //<editor-fold desc="toString">
    @Override
    public String toString() {
        return "Pool{"
                + "name='" + name + '\''
                + ", volumeLitres=" + volumeLitres
                + ", temperatureCelsius=" + temperatureCelsius
                + ", pH=" + pH
                + ", nutrientCoefficient=" + nutrientCoefficient
                + ", identificationNumber=" + identificationNumber
                + ", guppiesInPool=" + guppiesInPool
                + ", randomNumberGenerator=" + randomNumberGenerator
                + '}';
    }
    //</editor-fold>

    public static void main(final String[] args) {
        Pool myPool = new Pool();
        Guppy myGuppy = new Guppy();
        myPool.addGuppy(myGuppy);
        System.out.println(myPool.getMedianAge());
    }


}
