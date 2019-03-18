package com.company;

/**
 * A játékos által irányított karaktereket szimbolizáló osztály. Felelőssége az általa
 * vezetett pandák, és a követendő út nyilvántartása.
 */
public class Orangutan extends Animal {
    /**
     * A követendő út csempéi.
     */
    private Tile[] path;

    /**
     * @return int
     * Visszaadja a pandas tömb hosszát.
     */
    int getPandaNum(){

    }

    /**
     * @param o Orangutan
     * @return boolean
     * Orangutan Orangutan-nal ütközik, false-szal
     * tér vissza.
     */
    boolean collideWidth(Orangutan o){

    }

    /**
     * @param p Panda
     * @return boolean
     * Orangutan Panda-val ütközik, p bekerül a sorba,
     * amennyiben nem egy másik sor tagja, false-t ad vissza.
     */
    boolean collideWidth(Panda p){

    }

    /**
     * Kiüríti a nextPanda attribútumot.
     */
    void removePanda(){

    }

    /**
     * A pandas tömbböt kiüríti, amikor a kijáraton ki lettek
     * vezetve.
     */
    void destroyPandas(){

    }

    /**
     * @param t Tile
     * Az oránugután átlép a t csempére.
     */
    void move(Tile t){

    }
}
