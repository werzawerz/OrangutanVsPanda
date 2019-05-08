package com.company;

import javax.swing.*;
import java.awt.*;

public class ThingView implements Drawable {

    private Thing obj;
    private Image img;

    ThingView(Thing t, Image i){
        obj =t;
        img =i;
    }

    public void draw(Graphics g){

    }
}
