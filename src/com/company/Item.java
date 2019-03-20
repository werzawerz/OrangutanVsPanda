package com.company;

/**
 * A nem mozgó pályaelemeket reprezentálja. Absztrakt ősosztálya az Arcade-nek, a
 * VendingMachine-nek, és a Sofa-nak.
 */
public class Item extends Thing{

    /**
     * @param o
     * @return bool
     * Amikor o, egy csempére adott Item-mel,
     * akkor visszatér false-szal.
     */
    public  boolean collidewith(Orangutan o)
    {

    }

    /**
     * @param p
     * @return bool
     * Amikor p, egy csempére adott Item-mel, akkor
     * visszatér false-szal.
     */
    public  boolean collidewith(Panda p)
    {

    }

    /**
     *Értesíti a szomszédos csempéken állókat, ha valami történik,
     * amiről tudniuk kellene.
     */
    public void notify()
    {

    }
}
