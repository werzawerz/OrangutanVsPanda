package com.company;

/**
 * Sipszot ad ki a kornyezo mezokre.
 */
public class VendingMachine extends Item{

    /**
     * Ertesiti a szomszedos tile-okat a sipszorol, ha pedig van ott animal, meghivja a jump fuggvenyet.
     */
    public void Notify(){
        Tile t = this.getPosition();
        Tile tiles[] = t.getNeighbours();
        Animal a = tiles[0].getAnimal();
        a.jump();
    }
}
