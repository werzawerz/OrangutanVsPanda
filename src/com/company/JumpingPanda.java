package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Az a panda, amelyik, ha sípszót hall, ugrik egyet.
 */
public class JumpingPanda extends Panda {

    JumpingPanda(){
        try {
            Maze.addThingView(new ThingView(this, ImageIO.read(new File("panda.png"))));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * A függvény elvégzi a csempe “életének” csökkentését, ha az
     * gyenge.
     */
    void jump() throws IOException {
        /*Controller.incTab();
        Controller.writeClassAndFunction("JUMPINGPANDA:jump()");*/
        getPosition().decreaseStrength(5);
        /*Controller.decTab();*/
    }
}
