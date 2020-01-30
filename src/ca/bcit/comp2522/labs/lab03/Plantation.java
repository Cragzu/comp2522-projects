package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;

/**
 * Creates and manages a Plantation containing Trees.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Plantation {
    private ArrayList<Tree> farm = new ArrayList<>();

    /**
     * Returns the current size of the farm; the number of trees there are.
     * @return the number of trees in the farm.
     */
    public int size() {
        return farm.size();
    }

    /**
     * Adds a tree to the farm.
     * @param sapling the new tree to be added.
     */
    public void add(Tree sapling) {
        if (sapling == null) {
            throw new NullPointerException("That sapling doesn't exist!");
        } else {
            farm.add(sapling);
        }
    }

}
