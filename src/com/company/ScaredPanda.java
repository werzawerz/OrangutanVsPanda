package com.company;

/**
 * Az a panda, amelyik, ha csengetést hall, megijed.
 */
public class ScaredPanda extends Panda {

    /**
     * A függvény elvégzi a sor felbontását, ha van.
     */
    void scare(){
        getNextPanda().release();
        release();
    }
}
