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

    Thing getObj(){
        return obj;
    }

    public void draw(Graphics g){
        paintComponent(g);
    }
    public void paintComponent(Graphics g){

            g.drawImage(img, obj.getPosition().getView().getX()+12, obj.getPosition().getView().getY()+14, null);

    }




}
