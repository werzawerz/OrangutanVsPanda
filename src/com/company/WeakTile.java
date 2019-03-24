package com.company;

import javax.naming.ldap.Control;

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
        Controller.incTab();
        Controller.writeClassAndFunction("WEAKTILE:accept(o)");
        decreaseStrength(1);
        if(strength>0) {
            //TODO
        }
        else {
            remove(o);
            Maze.removeOrangutan(o);
        }
        Controller.decTab();
    }

    /**
     * @param p a WeakTilera lépni akaró panda
     * Magára rakja az Pandat, ha “élete” 0, akkor pedig törli azt.
     */
    @Override
    void accept(Panda p) {
        Controller.incTab();
        Controller.writeClassAndFunction("WEAKTILE:accept(p)");
        decreaseStrength(1);
        if(strength>0) {
            //todo
        }
        else {
            remove(p);
            Maze.removeOnePanda(p);
        }
        Controller.decTab();
    }

    /**
     * @param i
     * Csökkenti a strength attributum értékét i-vel
     */
    void decreaseStrength(int i) {
        Controller.incTab();
        Controller.writeClassAndFunction("WEAKTILE:decreaseStrength(i)");
        strength -= i;
        Controller.decTab();
    }

    public void setStrength(int i) {
        strength = i;
    }
}
