package com.company;

import javax.naming.ldap.Control;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Olyan csempe, ami egy bizonyos rálépés után eltörik. Nyilvántartja, hogy mennyi
 * rálépés van vissza a törésig.
 */
public class WeakTile extends Tile {

    /**
     * A fenmaradó rálépés a törésig.
     */
    private int strength=3;

    /**
     * @param o : a WeakTilera lépni akaró orángután
     * Magára rakja az Orángutántt, ha “élete” 0, akkor pedig
     * törli azt.
     */
    @Override
    void accept(Orangutan o) throws IOException {

        o.setPosition(this);
        decreaseStrength(1);
        if(strength>0) {
            this.occupiedBy = o;
            o.setPosition(this);
        }
        else {
            Maze.removeOrangutan(o);
            remove(o);
        }

    }

    /**
     * @param p a WeakTilera lépni akaró panda
     * Magára rakja az Pandat, ha “élete” 0, akkor pedig törli azt.
     */
    @Override
    void accept(Panda p) throws IOException {

        decreaseStrength(1);
        if(strength>0) {
            this.occupiedBy = p;
            p.setPosition(this);
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
    void decreaseStrength(int i) throws IOException {
        if(strength<1) return;
        strength -= i;
    }

    public int getStrength() {return strength;}

    public void setStrength(int i) {
        strength = i;
    }
}
