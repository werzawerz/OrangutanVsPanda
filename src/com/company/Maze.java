package com.company;

import java.util.ArrayList;

/**
 * A pályát, és a különböző pályaelemeket nyilvántartó osztály.
 */
public class Maze {

    /**
     * A pálya csempéit tartalmazó tömb.
     */
    static private ArrayList<Tile> tiles;

    /**
     * A pályán lévő pandákat tartalmazó tömb.
     */
    static private ArrayList<Panda> pandas;

    /**
     * A pályán lévő Orángutánokat tartalmazó tömb.
     */
    static private ArrayList<Orangutan> orangutans;

    /**
     * A pályán lévő, nem mozgó elemek tömbje.
     */
    static private ArrayList<Item> items;

    /**
     * Megnézi, hogy vannak-e még pandák vagy orángutánok a
     * pályán.
     */
    static void check() {
        //TODO
    }

    /**
     * @param p A sorban lévő első panda
     * Rekurzív függvény, a panda mindig meghívja
     * a sorban következő pandára, amikor kimennek a kijáraton, vagy.
     */
    static void removePanda(Panda p) {
        Controller.incTab();
        Controller.writeClassAndFunction("MAZE:removePanda(p)");
        if(p.getNextPanda()!=null)
            removePanda(p.getNextPanda());
        pandas.remove(p);
        Controller.decTab();
    }

    /**
     * @param p A Maze-ről levevendő panda
     */
    static void removeOnePanda(Panda p) {
        Controller.incTab();
        Controller.writeClassAndFunction("MAZE:removeOnePanda(p)");
        pandas.remove(p);
        Controller.decTab();
    }

    /**
     * @param o
     * Kiveszi o-t az orangutans-ból.
     */
    static void removeOrangutan(Orangutan o) {
        Controller.incTab();
        Controller.writeClassAndFunction("MAZE:removeOrangutan(o)");
        orangutans.remove(o);
        Controller.decTab();
    }
}
