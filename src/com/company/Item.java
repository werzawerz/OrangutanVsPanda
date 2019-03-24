package com.company;



/**
 * A nem mozgó pályaelemeket reprezentálja. Absztrakt ősosztálya az Arcade-nek, a
 * VendingMachine-nek, és a Sofa-nak.
 */
public class Item extends Thing {

    /**
     * @param o
     * @return bool
     * Amikor o, egy csempére adott Item-mel,
     * akkor visszatér false-szal.
     */
   /* public boolean collidewith(Orangutan o) {
        Controller.incTab();
        Controller.writeClassAndFunction("ITEM:collideWith(o)");
        Controller.decTab();
        return false;
    } */

    /**
     * @param p
     * @return bool
     * Amikor p, egy csempére adott Item-mel, akkor
     * visszatér false-szal.
     */
    /*public boolean collidewith(Panda p) {
        String s = this.getClass().getName().toUpperCase() + ":collideWith(p)"
        Controller.incTab();
        Controller.writeClassAndFunction("ITEM:collideWith(p)");
        Controller.decTab();
        return false;
    } */

    /**
     * Értesíti a szomszédos csempéken állókat, ha valami történik
     * amiről tudniuk kellene.
     */
    public void notifyNeighbours() {
        String s = this.getClass().getName().toUpperCase() + ":notifyNeighbours()";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        Controller.decTab();
    }
}
