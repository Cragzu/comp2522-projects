package ca.bcit.comp2522.labs.lab03;

/**
 * Creates and manages various types of trees.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Tree {
    private Species type;
    private int ageInYears;
    private double circumferenceInCentimetres;

    enum Species {
        /**
         * Maple tree.
         */
        MAPLE,

        /**
         * Arbutus tree.
         */
        ARBUTUS,

        /**
         * Blue spruce tree.
         */
        BLUE_SPRUCE
    }

    /**
     * Constructor allowing only the age and circumference of the tree to be given.
     *
     * @param ageInYears the age of the tree in years.
     * @param circumferenceInCentimetres the circumference of a cross-section of the tree in centimetres.
     */
    public Tree(int ageInYears, double circumferenceInCentimetres) {
        if (ageInYears < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0!");
        } else {
            this.ageInYears = ageInYears;
        }
        if (circumferenceInCentimetres < 0) {
            throw new IllegalArgumentException("Circumference cannot be less than 0!");
        } else {
            this.circumferenceInCentimetres = circumferenceInCentimetres;
        }
    }

    /**
     * Constructor allowing all instance variables to be given.
     *
     * @param type the type of the tree; one of the declared options in Species enum.
     * @param ageInYears the age of the tree in years.
     * @param circumferenceInCentimetres the circumference of a cross-section of the tree in centimetres.
     */
    public Tree(Species type, int ageInYears, double circumferenceInCentimetres) {
        this.type = type;
        new Tree(ageInYears, circumferenceInCentimetres);
    }




}
