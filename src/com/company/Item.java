package com.company;



/**
 * A nem mozgó pályaelemeket reprezentálja. Absztrakt ősosztálya az Arcade-nek, a
 * VendingMachine-nek, és a Sofa-nak.
 */
public class Item extends Thing {


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
