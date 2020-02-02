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
    private String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private int identificationNumber;
    private ArrayList<Guppy> guppiesInPool;
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
}
