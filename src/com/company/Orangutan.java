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

    /**
     * @return int
     * Visszaadja a pandas tömb hosszát.
     */
    int getPandaNum(){
        Controller.incTab();
        Controller.writeClassAndFunction("ORANGUTAN:getPandaNum()");
        Controller.decTab();
        return 0;
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
