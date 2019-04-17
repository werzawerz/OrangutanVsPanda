package com.company;

import java.util.ArrayList;

/**
 * A játékgépet modellező osztály. Felelőssége a csengetés.
 */
public class Arcade extends Item{

    /**
     * Ez a függvény értesíti a szomszédos csempéken álló
     * pandákat, hogy csengetés történt.
     */
    public void notifyNeighbours()
    {
        Controller.incTab();
        Controller.writeClassAndFunction("ARCADE:notifyNeighbours()");
        Tile t = this.getPosition();
        ArrayList<Tile> tiles = t.getNeighbours();
        for(int i=0;i<tiles.size();i++){
            Animal a = tiles.get(0).getAnimal();
            if(a!=null)
                a.scare();}
        Controller.decTab();
    }
}
