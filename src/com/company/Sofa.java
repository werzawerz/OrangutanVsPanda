package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    Sofa(){
        try {
            Maze.addThingView(new ThingView(this, ImageIO.read(new File("sofa.png"))));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public  boolean collideWith(Panda p){

        return empty;
    }



    /**
     * Meghívja a szomszédos csempéken levő állatoknak a sit()
     * függvényét.
     */
    public  void notifyNeighbours() throws IOException {

        Tile t = this.getPosition();
        ArrayList<Tile> tiles = t.getNeighbours();
        for(int i=0;i<tiles.size();i++){
            Animal a = tiles.get(i).getAnimal();
            if(a!=null)
                a.sit(this.getPosition());

        }


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
