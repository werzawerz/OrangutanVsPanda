package com.company;

/**
 * Az a panda, amelyik, ha sípszót hall, ugrik egyet.
 */
public class JumpingPanda extends Panda {

    /**
     * A függvény elvégzi a csempe “életének” csökkentését, ha az
     * gyenge.
     */
    void jump(){
        Controller.incTab();
        Controller.writeClassAndFunction("JUMPINGPANDA:jump()");
        getPosition().decreaseStrength(5);
        Controller.decTab();
    }
}
