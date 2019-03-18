package com.company;

/**
 * Olyan csempe, ami egy bizonyos rálépés után eltörik. Nyilvántartja, hogy mennyi
 * rálépés van vissza a törésig.
 */
public class WeakTile extends Tile {

    /**
     * A fenmaradó rálépés a törésig.
     */
    private int strength;

    /**
     * @param a : a WeakTilera lépni akaró állat
     * Magára rakja az Animal-t, ha “élete” 0, akkor pedig
     * törli azt.
     */
    void accept(Animal a) {

    }

    /**
     * @param i
     * Csökkenti a strength attributum értékét i-vel
     */
    void decreaseStrength(int i) {

    }
}
