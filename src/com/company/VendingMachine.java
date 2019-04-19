package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Sipszot ad ki a kornyezo mezokre.
 */
public class VendingMachine extends Item{

    /**
     * Ertesiti a szomszedos tile-okat a sipszorol, ha pedig van ott animal, meghivja a jump fuggvenyet.
     */
    public void notifyNeighbours() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.out", true));
        writer.append(this.getName()+" sound\n");
        writer.close();
        Controller.incTab();
        Controller.writeClassAndFunction("VENDINGMACHINE:notifyNeighbours()");
        Tile t = this.getPosition();
        ArrayList<Tile> tiles = t.getNeighbours();
        for(int i=0;i<tiles.size();i++){
        Animal a = tiles.get(0).getAnimal();
        if(a!=null)
        a.jump();}
        Controller.decTab();
    }
}
