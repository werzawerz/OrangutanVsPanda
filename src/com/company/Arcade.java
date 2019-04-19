package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A játékgépet modellező osztály. Felelőssége a csengetés.
 */
public class Arcade extends Item{

    /**
     * Ez a függvény értesíti a szomszédos csempéken álló
     * pandákat, hogy csengetés történt.
     */
    public void notifyNeighbours() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.out", true));
        writer.append(this.getName()+" sound\n");
        writer.close();
        Controller.incTab();
        Controller.writeClassAndFunction("ARCADE:notifyNeighbours()");
        Tile t = this.getPosition();
        ArrayList<Tile> tiles = t.getNeighbours();
        for(int i=0;i<tiles.size();i++){
            Animal a = tiles.get(i).getAnimal();
            if(a!=null)
                a.scare();}
        Controller.decTab();
    }
}
