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

    /**
     * Constructor.
     */
    public Guppy() {
        numberOfGuppiesBorn += 1;

        ageInWeeks = 0;
        generationNumber = 0;
        genus = DEFAULT_GENUS;
        species = DEFAULT_SPECIES;
        isFemale = true;
        isAlive = true;
        healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        identificationNumber = numberOfGuppiesBorn;
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

    public static void main(String[] args) {
        Guppy myGuppy = new Guppy();
        String test = "hello";
        System.out.println(myGuppy.toTitleCase(test));
    }

}
