package com.company;

import java.io.IOException;

/**
 * A helyváltoztatásra képes játékelemeket reprezentálja. Absztrakt osztály, konkrét
 * példányai lehetnek az orángutánok, és különböző pandák.
 */
public abstract class Animal extends Thing {
    /**
     * A sorban következő Panda.
     */
    protected Panda nextPanda;

    /**
     * Üres függvény, felüldefiniálandó, állatokként
     * változó. Leszármazottaknál bővebben lesz tárgyalva.
     */
    public void move(Tile t) throws IOException {}

    /**
     * Üres függvény.
     */
    void jump() throws IOException {}

    /**
     * Üres függvény.
     */
    void scare() throws IOException {}

    /**
     * Üres függvény.
     */
    void sit(Tile t) throws IOException {}

    /**
     * @return Visszaadja a sorban következő Panda-t.
     */
    Panda getNextPanda(){
        return nextPanda;
    }

    /**
     * @param p Panda
     * Rekurzív függvény, a p-t beteszi a sor
     * végére.
     */
    void putPandaToEnd(Panda p){

    }


    /**
     * @param p Panda
     * A p-t beteszi a nextPanda változóba.
     */
    protected void setNextPanda(Panda p) {

        nextPanda=p;}
}
