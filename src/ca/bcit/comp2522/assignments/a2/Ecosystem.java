package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

/**
 * Simulates an ecosystem of Guppies and Pools.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Ecosystem {

    //<editor-fold desc="Instance variable and constructor">
    private ArrayList<Pool> pools;

    public Ecosystem() {
        this.pools = new ArrayList<>();
    }
    //</editor-fold>

    /**
     * Adds a pool to the pools in the ecosystem, as long as it is not null.
     *
     * @param newPool the pool to be added.
     */
    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    /**
     * Resets the ecosystem, clearing out all existing pools.
     */
    public void reset() {
        pools.clear();
    }

    public static void main(String[] args) {
        Ecosystem myEco = new Ecosystem();
        Pool myPool = new Pool();
    }


}
