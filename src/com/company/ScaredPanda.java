package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Az a panda, amelyik, ha csengetést hall, megijed.
 */
public class ScaredPanda extends Panda {

    ScaredPanda(){
        try {
            Maze.addThingView(new ThingView(this, ImageIO.read(new File("/sofa.png"))));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * A függvény elvégzi a sor felbontását, ha van.
     */
    void scare() throws IOException {

        if(getNextPanda()!=null)
            getNextPanda().release();
        release();

    }
}
