package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    public boolean collideWith(Orangutan o) throws IOException {

        if(!follow)
        {   setFollow(true);
            setFollowingA(o);
            Animal a = o;
            while(a.getNextPanda()!=null) {
                a = a.getNextPanda();
            }
            a.setNextPanda(this);
        }

        return false;
    }

    public void move(Tile t) throws IOException {

        if(t.canIMove(this)) {

            getPosition().remove(this);
            if(nextPanda!=null)
            {
                nextPanda.move(position);
            }
            t.accept(this);
        }
    }

    /**
     * @param p Panda
     * @return bool
     * Panda Panda-val ütközik, mindenki a helyén
     * marad, false-t ad vissza.
     */
    public boolean collideWith(Panda p) throws IOException{
        return false;
    }

    /**
     * @param b bool
     * Beállítja a follow flaget.
     */
    void setFollow(boolean b){
        follow=b;

    }

    /**
     * Rekurzív, a sor felbontását végzi el.
     */
    void release() throws IOException {

        if(getNextPanda()!=null)
            getNextPanda().setNextPanda(null);

    }

    void setFollowingA(Animal a) throws IOException {

        followingA = a;
    }

    boolean isFollowing(){return follow;}



}
