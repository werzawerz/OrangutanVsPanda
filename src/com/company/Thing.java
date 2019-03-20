package com.company;

/**
 * A pályáelemek összességének abszrakt ősosztálya.
 * Nyilvántartja a csempét, amin van.
 */
public abstract class Thing {

    /**
     * Az a Tile, amin aktuálisan van.
     */
    private Tile position;

    /**
     * @param o
     * @return bool
     * Akkor hívódik meg, amikor egy leszármazottja találkozik egy Orangutan-nal.
     * Leszármazottban felül van írva. Itt csak false-szal tér vissza.
     */
    public boolean collideWith(Orangutan o){

    }

    /**
     * @param p
     * @return bool
     * Akkor hívódik meg, amikor egy leszármazottja találkozik egy Panda-val.
     * Leszármazottban felül van írva. Itt csak false-szal tér vissza.
     */
    public boolean collideWith(Panda p){

    }

    /**
     * @return Tile
     * Visszaadja a dolog pozícióját.
     */
    public Tile getPosition(){
        return position;
    }


}
