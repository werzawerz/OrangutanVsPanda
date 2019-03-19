package com.company;

/**
 * A pályát alkotó csempéket modellező osztály. Nyilván tartja a szomszédos
 * csempéket, illetve a rajta lévő állatot, vagy egyéb pályaelemet.
 */
public class Tile {

    /**
     * A szomszédos csempéket tartalmazó tömb.
     */
    private Tile[] neighbours;
    /**
     * A csempén tartózkodó Animal.
     */
    private Animal occupiedBy;
    /**
     * A csempén lévő pályaelem.
     */
    private Item item;

    /**
     * @param a Animal: a Tile-ra lépni akaró Animal
     * @return bool
     * A megfelelő collideWith metódusokkal megnézi,
     * hogy Animal a léphet-e rá, ennek megfelelő a visszatérési érték.
     */
    boolean canIMove(Animal a){
        if(occupiedBy!=null)
            return occupiedBy.collideWidth(a);
        if(item!=null)
            return item.collideWidth(a);

    }

    /**
     * @param o Orangutan
     * Az o-t rálépteti magára.
     */
    void accept(Orangutan o){

    }

    /**
     * @param p Panda
     * A p-t rálépteti magára.
     */
    void accept(Panda p) {

    }

    /**
     * @param a Animal
     * Az a-t leveszi magáról.
     */
    void remove(Animal a)
    {

    }

    /**
     * Üres függvény, a WeakTile-nál van
     * törzse.
     */
    void decreaseStrength(){}

    /**
     * @return Tile[]
     * Visszaadja a szomszédos csempéket tartalmazó
     * tömböt.
     */
    Tile[] getNeighbours(){

    }

    /**
     * @return Animal
     * Visszaadja a a Tile-on levő Animal-t.
     */
    Animal getAnimal(){

    }
}
