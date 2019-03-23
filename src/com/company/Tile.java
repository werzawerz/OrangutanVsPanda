package com.company;

import java.util.ArrayList;

/**
 * A pályát alkotó csempéket modellező osztály. Nyilván tartja a szomszédos
 * csempéket, illetve a rajta lévő állatot, vagy egyéb pályaelemet.
 */
public class Tile {

    /**
     * A szomszédos csempéket tartalmazó tömb.
     */
    private ArrayList<Tile> neighbours = new ArrayList<Tile>();
    /**
     * A csempén tartózkodó Animal.
     */
    private Animal occupiedBy;
    /**
     * A csempén lévő pályaelem.
     */
    private Item item;

    /**
     * @param o Orangutan: a Tile-ra lépni akaró Orangutan
     * @return bool
     * A megfelelő collideWith metódusokkal megnézi,
     * hogy Animal a léphet-e rá, ennek megfelelő a visszatérési érték.
     */
    boolean canIMove(Orangutan o){
        if(occupiedBy!=null)
            return occupiedBy.collideWith(o);
        if(item!=null)
            return item.collideWith(o);
        return false;
    }

    /**
     * @param p ?????????????????????????????????????
     * @return ?????????????????????????? Kérdéses cucc
     */
    boolean canIMove(Panda p){
        if(occupiedBy!=null)
            return occupiedBy.collideWith(p);
        if(item!=null)
            return item.collideWith(p);
        return false;
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
    void decreaseStrength(int i){}

    /**
     * @return Tile[]
     * Visszaadja a szomszédos csempéket tartalmazó
     * tömböt.
     */
    Tile[] getNeighbours(){
        return null;
    }

    /**
     * @return Animal
     * Visszaadja a a Tile-on levő Animal-t.
     */
    Animal getAnimal(){
        return null;
    }

    /**
     * @param t t-t hozzáadja a szomszédos tileok közé
     */
    void setNeighbours(Tile t) {
        neighbours.add(t);
    }
}
