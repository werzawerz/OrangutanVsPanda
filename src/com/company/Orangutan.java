package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékos által irányított karaktereket szimbolizáló osztály. Felelőssége az általa
 * vezetett pandák, és a követendő út nyilvántartása.
 */
public class Orangutan extends Animal {


    Orangutan(){
        try {
            Maze.addThingView(new ThingView(this, ImageIO.read(new File("orangutan.png"))));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * A követendő út csempéi.
     */
    int timeToSteal;

    int gettimeToSteal(){
        return timeToSteal;
    }

    void settimeToSteal(int t) {
        timeToSteal = t;
    }
    /**
     * @return int
     * Visszaadja a pandas tömb hosszát.
     */
    int getPandaNum(Panda p){
        if(p==null) {
            return 0;
        }
        else
            return 1 + getPandaNum(p.getNextPanda());
    }

    public boolean collideWith(Orangutan o) throws IOException {

        if (o.getNextPanda() == null && this.getNextPanda() != null && o.gettimeToSteal() == 0) {
            o.setNextPanda(this.getNextPanda());
            o.getNextPanda().setFollowingA(o);
            this.settimeToSteal(3);
            this.setNextPanda(null);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Kiüríti a nextPanda attribútumot.
     */
    void removePanda(){

        nextPanda=null;
    }

    /**
     * A pandas tömbböt kiüríti, amikor a kijáraton ki lettek
     * vezetve.
     */
    void destroyPandas() throws IOException {
        Maze.removePanda(getNextPanda());
        removePanda();
    }

    /**
     * @param t Tile
     * Az oránugután átlép a t csempére.
     */
    public void move(Tile t) throws IOException {


        if(t.canIMove(this)){

            getPosition().remove(this);
            if(nextPanda!=null)
            {
                nextPanda.move(position);
            }
            t.accept(this);
        }
    }
}
