package com.company;


/**
 * A pálya olyan csempéje, amire rálépve egy másik,
 * ugyanilyen szekrény típusú csempén jelenik meg az orángután.
 * Felelőssége a másik szekrény nyilvántartása.
 */
public class Wardrobe extends Tile {

    /**
     * A szomszéd szekrény, melyre át kell teleportálnia a rá lépő állatot.
     */
    private Tile neighbourWardrobe;


    /**
     * @param p Panda
     * p-t átlépteti a szomszédos szekrényre.
     */
    public void accept(Panda p){
        Controller.incTab();
        Controller.writeClassAndFunction("WARDROBE:accept(p)");
        neighbourWardrobe.accept(p);
        Controller.decTab();

    }

    /**
     * @param o Orangutan
     * o-t átlépteti a szomszédos szekrényre.
     */
    public void accept(Orangutan o){
        Controller.incTab();
        Controller.writeClassAndFunction("WARDROBE:accept(o)");
        neighbourWardrobe.accept(o);
        Controller.decTab();
    }


}
