package ca.bcit.comp2522.assignments.a1;

import java.util.Objects;

/**
 * todo: implement the given unit tests
 * @author Chloe Glave
 * @version 2020
 */
public class Guppy {
    /*Constants*/
    final static int YOUNG_FISH_AGE_IN_WEEKS = 10;
    final static int MATURE_FISH_AGE_IN_WEEKS = 30;
    final static int MAXIMUM_AGE_IN_WEEKS = 50;
    final static double MINIMUM_WATER_VOLUME_ML = 250.0;
    final static double ADULT_FISH_WATER_COEFFICIENT = 1.5;
    final static double DEAD_FISH_WATER_VOLUME = 0.0;
    final static String DEFAULT_GENUS = "Poecilia";
    final static String DEFAULT_SPECIES = "reticulata";
    final static double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    final static double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    final static double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;
    private static int numberOfGuppiesBorn = 0;

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

    /**
     * Updates the age of the guppy in weeks, staying within allowable bounds.
     * @param newAgeInWeeks the new age of the guppy.
     */
    public void setAgeInWeeks(int newAgeInWeeks) {
        if (newAgeInWeeks > 0 && newAgeInWeeks < MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = newAgeInWeeks;
        }
    }

    /**
     * Updates whether or not the guppy is alive. todo: is it OK to change from false to true (zombie fish)??
     *
     * @param alive the new value for the life status of the guppy
     */
    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Updates the health coefficient of the guppy, staying within allowable bounds.
     *
     * @param newHealthCoefficient the new health coefficient
     */
    public void setHealthCoefficient(double newHealthCoefficient) {
        if (newHealthCoefficient > MINIMUM_HEALTH_COEFFICIENT && newHealthCoefficient < MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = newHealthCoefficient;
        }
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
    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks, boolean newIsFemale, int newGenerationNumber,
                 double newHealthCoefficient) {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;

        genus = toTitleCase(newGenus);
        species = (newSpecies.toLowerCase()).strip();
        ageInWeeks = Math.max(newAgeInWeeks, 0); /*set age to 0 if given age is invalid (negative)*/
        isFemale = newIsFemale;
        generationNumber = (newGenerationNumber < 0) ? 1 : newGenerationNumber; /*set to 1 if given is invalid*/

        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) { /*ensure given is between min and max*/
            healthCoefficient = MINIMUM_HEALTH_COEFFICIENT; /*if not, set to closest*/
        }
        else healthCoefficient = Math.min(newHealthCoefficient, MAXIMUM_HEALTH_COEFFICIENT);

        isAlive = true; /*guppies always start out as alive*/
    }

    /**
     * Converts a string to title case; the first letter capitalized and the rest lowercase.
     *
     * @param originalString the string to be converted.
     * @return the capitalized string.
     */
    public String toTitleCase(String originalString) {
        String newString = originalString.toLowerCase();
        newString = newString.strip();
        char firstLetter = newString.charAt(0);
        newString = newString.replace(firstLetter, Character.toUpperCase(firstLetter));
        return newString;
    }

    /**
     * Increases the guppy's age by 1 week, setting isAlive to false if this brings the age above the maximum.
     */
    public void incrementAge() {
        ageInWeeks++;
        if(ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            isAlive = false;
        }
    }

    /**
     * Calculates the volume of water in mL that a guppy needs based on its age.
     *
     * @return the required volume of water in mL
     */
    public double getVolumeNeeded() {
        if (ageInWeeks < 10) {
            return MINIMUM_WATER_VOLUME_ML;
        }
        else if (ageInWeeks > 10 && ageInWeeks <= 30) {
            return (MINIMUM_WATER_VOLUME_ML*ageInWeeks)/YOUNG_FISH_AGE_IN_WEEKS;
        }
        else if (ageInWeeks > 30 && ageInWeeks <= 50) {
            return (MINIMUM_WATER_VOLUME_ML*ADULT_FISH_WATER_COEFFICIENT);
        }
        else {
            return DEAD_FISH_WATER_VOLUME;
        }
    }

    /**
     * Modifies the health coefficient by a given amount, staying within acceptable bounds.
     *
     * @param delta the amount to modify the health coefficient by
     */
    public void changeHealthCoefficient(double delta) {
        if (getHealthCoefficient() + delta <= MINIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(0.0);
            setIsAlive(false);
        }
        else if (getHealthCoefficient() + delta > MAXIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(MAXIMUM_HEALTH_COEFFICIENT);
        }
        else {
            setHealthCoefficient(getHealthCoefficient() + delta);
        }
    }

    /**
     * Creates a string providing information about the guppy.
     *
     * @return a formatted string describing the guppy
     */
    @Override
    public String toString() {
        return "Guppy{" +
                "genus='" + genus + '\'' +
                ", species='" + species + '\'' +
                ", ageInWeeks=" + ageInWeeks +
                ", isFemale=" + isFemale +
                ", generationNumber=" + generationNumber +
                ", isAlive=" + isAlive +
                ", healthCoefficient=" + healthCoefficient +
                ", identificationNumber=" + identificationNumber +
                '}';
    }

    /**
     * Compares the guppy to another object and determines whether they are equal.
     *
     * @param o object to compare to this guppy
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Guppy)) return false;
        Guppy guppy = (Guppy) o;
        return getAgeInWeeks() == guppy.getAgeInWeeks() &&
                isFemale == guppy.isFemale &&
                getGenerationNumber() == guppy.getGenerationNumber() &&
                isAlive == guppy.isAlive &&
                Double.compare(guppy.getHealthCoefficient(), getHealthCoefficient()) == 0 &&
                getIdentificationNumber() == guppy.getIdentificationNumber() &&
                getGenus().equals(guppy.getGenus()) &&
                getSpecies().equals(guppy.getSpecies());
    }

    public static void main(String[] args) {
        Guppy fry = new Guppy("  poECILIA    ",
                "  ELEgans   ",
                1,
                true,
                3,
                0.75);
        System.out.println(fry.toString());
    }

}
