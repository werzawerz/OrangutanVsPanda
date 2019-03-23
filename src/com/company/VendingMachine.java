package com.company;

import java.util.ArrayList;

/**
 * Sipszot ad ki a kornyezo mezokre.
 */
public class VendingMachine extends Item{

    /**
     * Ertesiti a szomszedos tile-okat a sipszorol, ha pedig van ott animal, meghivja a jump fuggvenyet.
     */
    public void Notify(){
        Controller.incTab();
        Controller.writeClassAndFunction("VENDINGMACHINE:notify()");
        Tile t = this.getPosition();
        ArrayList<Tile> tiles = t.getNeighbours();
        Animal a = tiles.get(0).getAnimal();
        a.jump();
        Controller.decTab();
    }
}
