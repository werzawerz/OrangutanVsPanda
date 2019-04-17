package com.company;

/**
 * Az a panda, amelyik, ha csengetést hall, megijed.
 */
public class ScaredPanda extends Panda {

    /**
     * A függvény elvégzi a sor felbontását, ha van.
     */
    void scare(){
        Controller.incTab();
        Controller.writeClassAndFunction("SCAREDPANDA:scare()");
        if(getNextPanda()!=null)
            getNextPanda().release();
        release();
        Controller.decTab();
    }
}
