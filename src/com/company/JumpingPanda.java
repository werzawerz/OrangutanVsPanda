package com.company;

/**
 * Az a panda, amelyik, ha sípszót hall, ugrik egyet.
 */
public class JumpingPanda extends Panda {
    @Override
    void move(Tile t) {

    }

    /**
     * A függvény elvégzi a csempe “életének” csökkentését, ha az
     * gyenge.
     */
    void jump(){
        getPosition().decreaseStrength(5);
    }
}
