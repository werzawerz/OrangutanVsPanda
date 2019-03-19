package com.company;

/**
 * A helyváltoztatásra képes játékelemeket reprezentálja. Absztrakt osztály, konkrét
 * példányai lehetnek az orángutánok, és különböző pandák.
 */
public abstract class Animal extends Thing {
    /**
     * A sorban következő Panda.
     */
    private Panda nextPanda;

    /**
     * Absztrakt függvény, felüldefiniálandó, állatokként
     * változó. Leszármazottaknál bővebben lesz tárgyalva.
     */
    abstract void move(Tile t);

    /**
     * Üres függvény.
     */
    void jump(){}

    /**
     * Üres függvény.
     */
    void scare(){}

    /**
     * Üres függvény.
     */
    void sit(Tile t){}

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



}
