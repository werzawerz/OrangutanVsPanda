package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A játékos által irányított karaktereket szimbolizáló osztály. Felelőssége az általa
 * vezetett pandák, és a követendő út nyilvántartása.
 */
public class Orangutan extends Animal {
    /**
     * A követendő út csempéi.
     */
    private Tile[] path;
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
            writer.append(this.getName()+" refuse "+ o.getName()+"\n");
            writer.close();
            System.out.print(this.getName()+" refuse "+ o.getName()+"\n");
            return false;
        }
    }

    /**
     * Kiüríti a nextPanda attribútumot.
     */
    void removePanda(){
/*        Controller.incTab();
        Controller.writeClassAndFunction("ORANGUTAN:removePanda()");
        Controller.decTab();*/
        nextPanda=null;
    }

    /**
     * A pandas tömbböt kiüríti, amikor a kijáraton ki lettek
     * vezetve.
     */
    void destroyPandas() throws IOException {
/*        Controller.incTab();
        Controller.writeClassAndFunction("ORANGUTAN:destroyPandas()");*/
        Maze.removePanda(getNextPanda());
        removePanda();
/*        Controller.decTab();*/
    }

    /**
     * @param t Tile
     * Az oránugután átlép a t csempére.
     */
    public void move(Tile t) throws IOException {

/*        Controller.incTab();
        Controller.writeClassAndFunction("ORANGUTAN:move(t)");*/
        if(t.canIMove(this)){

            BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
            writer.write(this.getName()+" "+this.position.getName()+"->"+t.getName()+"\n");
            writer.close();
            System.out.print(this.getName()+" "+this.position.getName()+"->"+t.getName()+"\n");
            getPosition().remove(this);
            if(nextPanda!=null)
            {
                nextPanda.move(position);
            }
            t.accept(this);
        }
        //Controller.decTab();
    }
}
