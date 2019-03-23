package com.company;

/**
 * Az a panda, amelyik, fotel mellé ér, leül rá.
 */
public class LazyPanda extends Panda {

    /**
     * @param t Tile
     * A függvény elvégzi a sor felbontását, ha van, illetve az adott
     * pandát rálépteti a fotel csempéjére, t-re, és kivonja a mozgásból.
     */
    void sit(Tile t){
        move(t);
    }
}
