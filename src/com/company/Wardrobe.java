package com.company;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A pálya olyan csempéje, amire rálépve egy másik,
 * ugyanilyen szekrény típusú csempén jelenik meg az orángután.
 * Felelőssége a másik szekrény nyilvántartása.
 */
public class Wardrobe extends Tile {

    /**
     * A szomszéd szekrény, melyre át kell teleportálnia a rá lépő állatot.
     */
    private Tile neighbourWardrobe;


    /**
     * @param p Panda
     * p-t átlépteti a szomszédos szekrényre.
     */
    public void accept(Panda p) throws IOException {
        /*Controller.incTab();
        Controller.writeClassAndFunction("WARDROBE:accept(p)");*/
        neighbourWardrobe.getNeighbours().get(0).accept(p);
        /*Controller.decTab();*/
    }

    /**
     * @param o Orangutan
     * o-t átlépteti a szomszédos szekrényre.
     */
    public void accept(Orangutan o) throws IOException {
/*        Controller.incTab();
        Controller.writeClassAndFunction("WARDROBE:accept(o)");*/
        o.setPosition(this);
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.out", true));
        writer.append(o.getName()+" "+this.getName()+"->"+this.neighbourWardrobe.getName()+"\n");
        writer.close();
        System.out.print(o.getName()+" "+this.getName()+"->"+this.neighbourWardrobe.getName()+"\n");
        o.setPosition(this.neighbourWardrobe);
        o.move(neighbourWardrobe.getNeighbours().get(0));

        //Controller.decTab();
    }


    public void setNeighbourWardrobe(Tile neighbourWardrobe) {
        this.neighbourWardrobe = neighbourWardrobe;
    }
}
