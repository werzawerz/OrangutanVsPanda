package com.company;

import java.util.ArrayList;

/**
 * A fotelt reprezántáló osztály, a lusta pandák leülnek rá, ha mellé érnek. Nyilvántartja,
 * hogy foglalt-e.
 */
public class Sofa extends Item{

    /**
     * A foglaltságot jelzi.
     */
    private boolean empty = true;

    public  boolean collideWith(Panda p){
        Controller.incTab();
        Controller.writeClassAndFunction("SOFA:collideWith(p)");
        Controller.decTab();
        return empty;
    }



    /**
     * Meghívja a szomszédos csempéken levő állatoknak a sit()
     * függvényét.
     */
    public  void notifyNeighbours(){
        Controller.incTab();
        Controller.writeClassAndFunction("SOFA:notifyNeighbours()");
        Tile t = this.getPosition();
        ArrayList<Tile> tiles = t.getNeighbours();
        for(int i=0;i<tiles.size();i++){
            Animal a = tiles.get(0).getAnimal();
            if(a!=null)
                a.sit(this.getPosition());
        getPosition().getNeighbours().get(0).getAnimal().sit(this.getPosition());
        }
        Controller.decTab();

    }


    public  void setEmpty(boolean b)
    {
        empty = b;
    }

    /**
     * @return
     * Visszaadja a fotel foglaltságát jelző bool értékét.
     */
    public  boolean isEmpty(){
        return empty;
    }
}
