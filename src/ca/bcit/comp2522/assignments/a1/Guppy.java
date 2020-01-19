package ca.bcit.comp2522.assignments.a1;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class Guppy {
    /*Constants*/
    final static int YOUNG_FISH_AGE_IN_WEEKS = 10;
    final static int MATURE_FISH_AGE_IN_WEEKS = 30;
    final static int MAXIMUM_AGE_IN_WEEKS = 50;
    final static double MINIMUM_WATER_VOLUME_ML = 250.0;
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

    public String getGenus() {
        return genus;
    }

    public String getSpecies() {
        return species;
    }

    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public int getGenerationNumber() {
        return generationNumber;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setAgeInWeeks(int ageInWeeks) {
        this.ageInWeeks = ageInWeeks;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setHealthCoefficient(double healthCoefficient) {
        this.healthCoefficient = healthCoefficient;
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
        species = newSpecies.toLowerCase();
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

    public static void main(String[] args) {
        Guppy myGuppy = new Guppy();
        String test = "hello";
        System.out.println(myGuppy.toTitleCase(test));
    }

}
