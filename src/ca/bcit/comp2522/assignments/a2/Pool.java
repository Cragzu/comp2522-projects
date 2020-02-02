package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
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
    private final Random randomNumberGenerator;
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
    public Pool(String name, double volumeLitres, double temperatureCelsius,
                double pH, double nutrientCoefficient) {
        numberOfPools++;
        identificationNumber = numberOfPools;

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = Guppy.toTitleCase(name);
        }

        this.volumeLitres = Math.max(volumeLitres, 0.0);

        if (temperatureCelsius > MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        } else {
            this.temperatureCelsius = Math.max(temperatureCelsius, MINIMUM_POOL_TEMP_CELSIUS);
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
    public double getpH() {
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
    //</editor-fold>

    //<editor-fold desc="Mutators">
    /**
     * Updates the volume of the pool.
     *
     * @param volumeLitres the new volume.
     */
    public void setVolumeLitres(double volumeLitres) {
        this.volumeLitres = volumeLitres;
    }

    /**
     * Updates the temperature of the pool.
     *
     * @param temperatureCelsius the new temperature.
     */
    public void setTemperatureCelsius(double temperatureCelsius) {
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
    public void setpH(double pH) {
        if (pH >= 0.0 && pH <= MAXIMUM_PH) {
            this.pH = pH;
        }
    }

    /**
     * Updates the nutrient coefficient of the pool.
     *
     * @param nutrientCoefficient the new nutrient coefficient.
     */
    public void setNutrientCoefficient(double nutrientCoefficient) {
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
    public void changeNutrientCoefficient(double delta) {
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
    public void changeTemperature(double delta) {
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
    public boolean addGuppy(Guppy guppy) {
        if (guppy == null) {
            return false;
        }
        guppiesInPool.add(guppy);
        return true;
    }

}
