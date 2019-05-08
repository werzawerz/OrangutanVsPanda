package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Az a panda, amelyik, fotel mellé ér, leül rá.
 */
public class LazyPanda extends Panda {

    LazyPanda(){

        try {
            Maze.addThingView(new ThingView(this, ImageIO.read(new File("/sofa.png"))));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * @param t Tile
     * A függvény elvégzi a sor felbontását, ha van, illetve az adott
     * pandát rálépteti a fotel csempéjére, t-re, és kivonja a mozgásból.
     */
    void sit(Tile t) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
        writer.write(this.getName()+" sits "+t.getName()+"\n");
        System.out.print(this.getName()+" sits "+t.getName()+"\n");
        writer.close();
        move(t);

    }
}
