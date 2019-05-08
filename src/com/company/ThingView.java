package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ThingView extends JPanel implements Drawable {

    private Thing obj;
    private Image img;


    ThingView(Thing t, Image i){
        obj =t;
        img =i;
    }

    public void draw(Graphics g){
        paintComponent(g);
    }
    public void paintComponent(Graphics g){

        Tile x = obj.getPosition();

            g.drawImage(img, obj.getPosition().getView().getX()+15, obj.getPosition().getView().getY()+18, null);

    }




}
