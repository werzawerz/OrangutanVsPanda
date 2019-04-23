package com.company;

import java.io.IOException;

/**
 * Az a panda, amelyik, ha csengetést hall, megijed.
 */
public class ScaredPanda extends Panda {

    /**
     * A függvény elvégzi a sor felbontását, ha van.
     */
    void scare() throws IOException {

        if(getNextPanda()!=null)
            getNextPanda().release();
        release();

    }
}
