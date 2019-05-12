package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Sipszot ad ki a kornyezo mezokre.
 */
public class VendingMachine extends Item{

    VendingMachine(){
        try {
            Maze.addThingView(new ThingView(this, ImageIO.read(new File("vending.png"))));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Ertesiti a szomszedos tile-okat a sipszorol, ha pedig van ott animal, meghivja a jump fuggvenyet.
     */
    public void notifyNeighbours() throws IOException {

        Tile t = this.getPosition();
        ArrayList<Tile> tiles = t.getNeighbours();
        for(int i=0;i<tiles.size();i++){
            Animal a = tiles.get(i).getAnimal();
        if(a!=null)
        a.jump();}

    }
}
