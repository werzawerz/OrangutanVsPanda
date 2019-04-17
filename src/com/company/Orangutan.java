package com.company;

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

    public boolean collideWith(Orangutan o){
       // String s = this.getClass().getSimpleName().toUpperCase() + ":collideWith(o)";
        if (o.getNextPanda() == null && this.getNextPanda() != null && o.gettimeToSteal() == 0) {
            o.setNextPanda(this.getNextPanda());
            o.getNextPanda().setFollowingA(o);
            this.settimeToSteal(3);
            this.setNextPanda(null);
        }
      //  Controller.incTab();
     //   Controller.writeClassAndFunction(s);
    //    Controller.decTab();
        return false;
    }

    /**
     * Kiüríti a nextPanda attribútumot.
     */
    void removePanda(){
        Controller.incTab();
        Controller.writeClassAndFunction("ORANGUTAN:removePanda()");
        Controller.decTab();
    }

    /**
     * A pandas tömbböt kiüríti, amikor a kijáraton ki lettek
     * vezetve.
     */
    void destroyPandas(){
        Controller.incTab();
        Controller.writeClassAndFunction("ORANGUTAN:destroyPandas()");
        Maze.removePanda(getNextPanda());
        removePanda();
        Controller.decTab();
    }

    /**
     * @param t Tile
     * Az oránugután átlép a t csempére.
     */
    public void move(Tile t){

        Controller.incTab();
        Controller.writeClassAndFunction("ORANGUTAN:move(t)");
        if(t.canIMove(this)){
            getPosition().remove(this);
            if(nextPanda!=null)
            {
                nextPanda.move(position);
            }
            t.accept(this);
        }
        Controller.decTab();
    }
}
