package com.company;

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
        getPosition().getNeighbours()[0].getAnimal().scare();
    }
}
