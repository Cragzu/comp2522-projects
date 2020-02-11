package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Creates a Guppy object with instance variables, constructors, and methods.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Guppy {
    //<editor-fold desc="Constants">
    /**Age of a young fish in weeks.*/
    static final int YOUNG_FISH_AGE_IN_WEEKS = 10;

    /**Age of a mature fish in weeks.*/
    static final int MATURE_FISH_AGE_IN_WEEKS = 30;

    /**Maximum age a fish can be before dying.*/
    static final int MAXIMUM_AGE_IN_WEEKS = 50;

    /**The minimum age of a female fish able to reproduce.*/
    static final int FEMALE_REPRODUCTIVE_AGE = 8;

    /**Minimum water volume needed to house a fish in mL.*/
    static final double MINIMUM_WATER_VOLUME_ML = 250.0;

    /**Coefficient of water needed to house an adult fish in mL.*/
    static final double ADULT_FISH_WATER_COEFFICIENT = 1.5;

    /**Dead fish need no water.*/
    static final double DEAD_FISH_WATER_VOLUME = 0.0;

    /**Default genus of a standard guppy.*/
    static final String DEFAULT_GENUS = "Poecilia";

    /**Default species of a standard guppy.*/
    static final String DEFAULT_SPECIES = "reticulata";

    /**Default health coefficient of a moderately healthy guppy.*/
    static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;

    /**Minimum health coefficient that a living guppy can have.*/
    static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;

    /**Maximum health coefficient that a guppy can have.*/
    static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    /**Minimum number of babies a female guppy can produce at one time.*/
    static final int MINIMUM_POSSIBLE_NUM_OF_FRY = 1;

    /**Maximum number of babies a female guppy can produce at one time.*/
    static final int MAXIMUM_POSSIBLE_NUM_OF_FRY = 100;
    //</editor-fold>

    //<editor-fold desc="Instance variables">
    private static int numberOfGuppiesBorn = 0;
    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    /**
     * Constructor for a guppy with non-default values.
     *
     * @param newGenus the guppy's genus.
     * @param newSpecies the guppy's species.
     * @param newAgeInWeeks the guppy's age.
     * @param newIsFemale whether or not the guppy is female.
     * @param newGenerationNumber the generation number the guppy belongs to.
     * @param newHealthCoefficient a coefficient representing how healthy the guppy is.
     */
    public Guppy(final String newGenus, final String newSpecies,
                 final int newAgeInWeeks, final boolean newIsFemale, final int newGenerationNumber,
                 final double newHealthCoefficient) {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;

        if (newGenus == null || newGenus.isBlank()) {
            throw new IllegalArgumentException("Genus cannot be empty.");
        } else {
            genus = toTitleCase(newGenus);
        }

        if (newSpecies == null || newSpecies.isBlank()) {
            throw new IllegalArgumentException("Species cannot be empty.");
        } else {
            species = (newSpecies.toLowerCase()).strip();
        }

        if (newAgeInWeeks >= MAXIMUM_AGE_IN_WEEKS) {
            throw new IllegalArgumentException("Age cannot be 50+ weeks!");
        } else if (newAgeInWeeks < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        } else {
            ageInWeeks = newAgeInWeeks;
        }

        isFemale = newIsFemale;

        if (newGenerationNumber < 0) {
            throw new IllegalArgumentException("Generation number cannot be negative.");
        } else {
            generationNumber = newGenerationNumber;
        }

        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT
                || newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            throw new IllegalArgumentException("Health coefficient is out of bounds!");
        } else {
            healthCoefficient = newHealthCoefficient;
        }

        isAlive = true; /*guppies always start out as alive*/
    }


    /**
     * Constructor for a default guppy.
     */
    public Guppy() {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;

        ageInWeeks = 0;
        generationNumber = 0;
        genus = DEFAULT_GENUS;
        species = DEFAULT_SPECIES;
        isFemale = true;
        isAlive = true;
        healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
    }
    //</editor-fold>

    //<editor-fold desc="Accessors">
    /**
     * Returns the genus of the guppy.
     * @return the genus
     */
    public String getGenus() {
        return genus;
    }

    /**
     * Returns the species of the guppy.
     * @return the species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Returns the age of the guppy in weeks.
     * @return the age
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Returns whether or not the guppy is female (true = female, false = male).
     * @return whether the guppy is female
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Returns the generation number of the guppy; how many generations have come before it.
     * @return the generation number
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Returns whether or not the guppy is alive (true = alive, false = dead).
     * @return the living/dead status of the guppy
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Returns the health coefficient of the guppy, indicating how healthy it is.
     * @return the health coefficient
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * Returns the ID number of the guppy.
     * @return the identification number
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Returns the total number of guppies that have ever been born.
     * @return the number of guppies born.
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }
    //</editor-fold>

    //<editor-fold desc="Mutators">
    /**
     * Updates the age of the guppy in weeks, staying within allowable bounds.
     * @param newAgeInWeeks the new age of the guppy.
     */
    public void setAgeInWeeks(final int newAgeInWeeks) {
        if (newAgeInWeeks >= 0 && newAgeInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            ageInWeeks = newAgeInWeeks;
        }
    }

    /**
     * Updates whether or not the guppy is alive.
     *
     * @param alive the new value for the life status of the guppy
     */
    public void setIsAlive(final boolean alive) {
        isAlive = alive;
    }

    /**
     * Updates the health coefficient of the guppy, staying within allowable bounds.
     *
     * @param newHealthCoefficient the new health coefficient
     */
    public void setHealthCoefficient(final double newHealthCoefficient) {
        if (newHealthCoefficient >= MINIMUM_HEALTH_COEFFICIENT
                && newHealthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = newHealthCoefficient;
        }
    }

    /**
     * Converts a string to title case; the first letter capitalized and the rest lowercase.
     *
     * @param originalString the string to be converted.
     * @return the capitalized string.
     */
    public static String toTitleCase(final String originalString) {
        String newString = originalString.toLowerCase();
        newString = newString.strip();
        char firstLetter = newString.charAt(0);
        newString = Character.toUpperCase(firstLetter) + newString.substring(1);
        return newString;
    }

    /**
     * Increases the guppy's age by 1 week,
     * setting isAlive to false if this brings the age above the maximum.
     */
    public void incrementAge() {
        setAgeInWeeks(getAgeInWeeks() + 1);
        if (ageInWeeks >= MAXIMUM_AGE_IN_WEEKS) {
            setIsAlive(false);
        }
    }
    //</editor-fold>

    /**
     * Calculates the volume of water in mL that a guppy needs based on its age.
     *
     * @return the required volume of water in mL
     */
    public double getVolumeNeeded() {
        if (!this.getIsAlive()) {
            return DEAD_FISH_WATER_VOLUME;
        } else if (this.getAgeInWeeks() < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (this.getAgeInWeeks() <= MATURE_FISH_AGE_IN_WEEKS) {
            return (MINIMUM_WATER_VOLUME_ML * this.getAgeInWeeks()) / YOUNG_FISH_AGE_IN_WEEKS;
        } else {
            return (MINIMUM_WATER_VOLUME_ML * ADULT_FISH_WATER_COEFFICIENT);
        }
    }

    /**
     * Modifies the health coefficient by a given amount, staying within acceptable bounds.
     *
     * @param delta the amount to modify the health coefficient by
     */
    public void changeHealthCoefficient(final double delta) {
        if (getHealthCoefficient() + delta <= MINIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(0.0);
            setIsAlive(false);
        } else if (getHealthCoefficient() + delta > MAXIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(MAXIMUM_HEALTH_COEFFICIENT);
        } else {
            setHealthCoefficient(getHealthCoefficient() + delta);
        }
    }

    /**
     * Spawns a guppy, potentially creating an assortment of baby fry.
     *
     * @return the ArrayList of newborn fry.
     */
    public ArrayList<Guppy> spawn() {
        if (!this.getIsFemale() || this.getAgeInWeeks() < FEMALE_REPRODUCTIVE_AGE) {
            return null; /*this guppy is unable to reproduce*/
        }
        ArrayList<Guppy> babyGuppies = new ArrayList<>();

        boolean willSpawn = new Random().nextBoolean();
        if (willSpawn) { /*female guppy has 50% chance to spawn*/

            Random numOfFryGenerator = new Random();
            int numOfFryBorn = numOfFryGenerator.nextInt(MAXIMUM_POSSIBLE_NUM_OF_FRY
                    - MINIMUM_POSSIBLE_NUM_OF_FRY) + MINIMUM_POSSIBLE_NUM_OF_FRY;

            int fryAgeInWeeks = 0;
            boolean fryIsFemale;
            double fryHealthCoefficient;
            int fryGenerationNumber = this.getGenerationNumber() + 1;

            for (int i = 0; i < numOfFryBorn; i++) {
                fryIsFemale = new Random().nextBoolean();
                fryHealthCoefficient = (1.0 + this.getHealthCoefficient()) / 2.0;
                Guppy fry = new Guppy(this.getGenus(), this.getSpecies(), fryAgeInWeeks,
                        fryIsFemale, fryGenerationNumber, fryHealthCoefficient);

                babyGuppies.add(fry);
            }
        }
        return babyGuppies;
    }

    //<editor-fold desc="toString, hashCode and equals">
    /**
     * Creates a string providing information about the guppy.
     *
     * @return a formatted string describing the guppy
     */
    @Override
    public String toString() {
        return "Guppy{"
                + "genus='" + genus + '\''
                + ", species='" + species + '\''
                + ", ageInWeeks=" + ageInWeeks
                + ", isFemale=" + isFemale
                + ", generationNumber=" + generationNumber
                + ", isAlive=" + isAlive
                + ", healthCoefficient=" + healthCoefficient
                + ", identificationNumber=" + identificationNumber
                + '}';
    }

    /**
     * Generates a hash code for this guppy.
     *
     * @return the hash code of this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getGenus(), getSpecies(), getAgeInWeeks(), getIsFemale(),
                getGenerationNumber(), getIsAlive(), getHealthCoefficient(),
                getIdentificationNumber());
    }

    /**
     * Compares the guppy to another object and determines whether they are equal.
     *
     * @param o object to compare to this guppy
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Guppy)) {
            return false;
        }
        Guppy guppy = (Guppy) o;
        return getAgeInWeeks() == guppy.getAgeInWeeks()
                && isFemale == guppy.isFemale
                && getGenerationNumber() == guppy.getGenerationNumber()
                && isAlive == guppy.isAlive
                && Double.compare(guppy.getHealthCoefficient(), getHealthCoefficient()) == 0
                && getIdentificationNumber() == guppy.getIdentificationNumber()
                && getGenus().equals(guppy.getGenus())
                && getSpecies().equals(guppy.getSpecies());
    }
    //</editor-fold>
}
