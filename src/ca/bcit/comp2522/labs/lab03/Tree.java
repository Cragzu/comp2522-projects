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
     * Constructor allowing all instance variables to be given.
     *
     * @param type the type of the tree; one of the declared options in Species enum.
     * @param ageInYears the age of the tree in years.
     * @param circumferenceInCentimetres the circumference of a cross-section of the tree in centimetres.
     */
    public Tree(Species type, int ageInYears, double circumferenceInCentimetres) {
        this.type = type;
        this.ageInYears = ageInYears;
        this.circumferenceInCentimetres = circumferenceInCentimetres;
    }
}
