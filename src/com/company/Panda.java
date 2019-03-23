package com.company;

/**
 * Az absztarkt osztály, amiből a különféle pandák származnak.
 */
public abstract class Panda extends Animal {
    /**
     * Nyilvántartja, hogy a panda követ-e épp egy orángutánt.
     */
    private boolean follow;
    /**
     * Az Animal, amit a Panda követ.
     */
    private Animal followingA;

    /**
     * @param o Orangutan
     * @return bool
     * Panda Orangutan-nal ütközik, a panda
     * bekerül a sorba, false-t ad vissza.
     */
    boolean collideWidth(Orangutan o){
        setFollow(true);
        setFollowingA(o);
        o.setNextPanda(this);
        return false;
    }

    public void move(Tile t){
        t.canIMove(this);
    }

    /**
     * @param p Panda
     * @return bool
     * Panda Panda-val ütközik, mindenki a helyén
     * marad, false-t ad vissza.
     */
    boolean collideWidth(Panda p){
        return false;
    }

    /**
     * @param b bool
     * Beállítja a follow flaget.
     */
    void setFollow(boolean b){

    }

    /**
     * Rekurzív, a sor felbontását végzi el.
     */
    void release(){
        getNextPanda().setNextPanda(null);
    }

    void setFollowingA(Animal a) {
        followingA = a;
    }


}
