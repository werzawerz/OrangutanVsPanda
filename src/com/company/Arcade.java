package com.company;

import javax.imageio.ImageIO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A játékgépet modellező osztály. Felelőssége a csengetés.
 */
public class Arcade extends Item{

    Arcade(){
        try {
            Maze.addThingView(new ThingView(this, ImageIO.read(new File("arcade.png"))));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Ez a függvény értesíti a szomszédos csempéken álló
     * pandákat, hogy csengetés történt.
     */
    public void notifyNeighbours() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
        writer.write(this.getName()+" sound\n");
        System.out.print(this.getName()+" sound\n");
        writer.close();
        Tile t = this.getPosition();
        ArrayList<Tile> tiles = t.getNeighbours();
        for(int i=0;i<tiles.size();i++){
            Animal a = tiles.get(i).getAnimal();
            if(a!=null)
                a.scare();}
    }
}
