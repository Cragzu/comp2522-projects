package ca.bcit.comp2522.labs.lab03;

import java.util.Objects;

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
     * @param circumferenceInCentimetres the circumference of a cross-section of the tree
     * in centimetres.
     */
    public Tree(int ageInYears, double circumferenceInCentimetres) {
        this(Species.MAPLE, ageInYears, circumferenceInCentimetres);
    }

    /**
     * Constructor allowing all instance variables to be given.
     *
     * @param type the type of the tree; one of the declared options in Species enum.
     * @param ageInYears the age of the tree in years.
     * @param circumferenceInCentimetres the circumference of a cross-section of the tree
     * in centimetres.
     */
    public Tree(Species type, int ageInYears, double circumferenceInCentimetres) {
        this.type = type;
        if (ageInYears < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0!");
        } else {
            this.ageInYears = ageInYears;
        }

        if (Double.compare(circumferenceInCentimetres, 0.0) < 0) {
            throw new IllegalArgumentException("Circumference cannot be less than 0!");
        } else {
            this.circumferenceInCentimetres = circumferenceInCentimetres;
        }
    }

    /**
     * Returns the species of the tree.
     *
     * @return the species.
     */
    public Species getType() {
        return type;
    }

    /**
     * Returns the age of the tree in years.
     *
     * @return the age.
     */
    public int getAgeInYears() {
        return ageInYears;
    }

    /**
     * Increments the age of the tree by 1 year.
     */
    public void incrementAgeInYears() {
        ageInYears++;
    }

    /**
     * Returns the circumference of a cross section of the tree in centimetres.
     *
     * @return the circumference.
     */
    public double getCircumferenceInCentimetres() {
        return circumferenceInCentimetres;
    }

    /**
     * Updates the circumference of a cross section of the tree in centimetres
     * to a greater value than the current.
     *
     * @param circumferenceInCentimetres the new circumference.
     */
    public void setCircumferenceInCentimetres(double circumferenceInCentimetres) {
        if (circumferenceInCentimetres >= this.circumferenceInCentimetres) {
            this.circumferenceInCentimetres = circumferenceInCentimetres;
        }
    }

    /**
     * Compares the tree to another object and determines whether they are equal.
     *
     * @param o object to compare to this tree
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Tree)) {
            return false;
        }
        Tree tree = (Tree) o;
        return getAgeInYears()
                == tree.getAgeInYears()
                && Double.compare(
                        tree.getCircumferenceInCentimetres(),
                        getCircumferenceInCentimetres()
                ) == 0
                && getType() == tree.getType();
    }

    /**
     * Generates a hash code for this tree.
     *
     * @return the hash code of this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType(), getAgeInYears(), getCircumferenceInCentimetres());
    }

    /**
     * Creates a string providing information about the tree.
     *
     * @return a formatted string describing the tree.
     */
    @Override
    public String toString() {
        return "Tree{"
                + "type=" + type
                + ", ageInYears=" + ageInYears
                + ", circumferenceInCentimetres=" + circumferenceInCentimetres
                + '}';
    }
}
