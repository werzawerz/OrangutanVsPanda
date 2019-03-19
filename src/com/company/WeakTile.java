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
     * @param o : a WeakTilera lépni akaró orángután
     * Magára rakja az Orángutántt, ha “élete” 0, akkor pedig
     * törli azt.
     */
    @Override
    void accept(Orangutan o) {
        decreaseStrength(1);
        if(strength>0) {
            //TODO
        }
        else {
            remove(o);
            Maze.removeOrangutan(o);
        }
    }

    /**
     * @param p a WeakTilera lépni akaró panda
     * Magára rakja az Pandat, ha “élete” 0, akkor pedig törli azt.
     */
    @Override
    void accept(Panda p) {
        decreaseStrength(1);
        if(strength>0) {
            //TODO
        }
        else {
            remove(p);
            Maze.removeOnePanda(p);
        }
    }

    /**
     * @param i
     * Csökkenti a strength attributum értékét i-vel
     */
    void decreaseStrength(int i) {
        strength -= i;
    }
}
