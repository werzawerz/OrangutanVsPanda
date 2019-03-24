package com.company;

/**
 * A fotelt reprezántáló osztály, a lusta pandák leülnek rá, ha mellé érnek. Nyilvántartja,
 * hogy foglalt-e.
 */
public class Sofa extends Item{

    /**
     * A foglaltságot jelzi.
     */
    private boolean empty;

    public  boolean collideWith(Panda p){
        Controller.incTab();
        Controller.writeClassAndFunction("SOFA:collideWith(p)");
        Controller.decTab();
        return true;
    }

    /**
     * Meghívja a szomszédos csempéken levő állatoknak a sit()
     * függvényét.
     */
    public  void notifyNeighbours(){
        Controller.incTab();
        Controller.writeClassAndFunction("SOFA:notifyNeighbours()");
        getPosition().getNeighbours()[0].getAnimal().sit(this.getPosition());
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
