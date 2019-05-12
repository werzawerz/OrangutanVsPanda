package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ThingView extends JPanel implements Drawable {

    /**
     * az obj-ot jeleniti meg a kép
     */
    private Thing obj;
    /**
     * ezt a képet jeleniti meg
     */
    private Image img;


    /**
     * @param t
     * @param i
     * konstruktor
     */
    ThingView(Thing t, Image i){
        obj =t;
        img =i;
    }

    Thing getObj(){
        return obj;
    }

    /**
     * @param g
     * rajzolásért felelős metódus
     */
    public void draw(Graphics g){
        paintComponent(g);
    }
    public void paintComponent(Graphics g){

            g.drawImage(img, obj.getPosition().getView().getX()+12, obj.getPosition().getView().getY()+14, null);

    }




}
