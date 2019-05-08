package com.company;


import javax.swing.*;
import java.awt.*;

public class TileView extends JPanel implements Drawable{
    private int x;
    private int y;
    Color color;

    public TileView(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        color = c;
    }
    public void draw(Graphics g){
        paintComponent(g);
    }
    public void paintComponent(Graphics g){
       // super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawOval(x, y, 35, 35);
        //g.fillRect(25, 25, 50, 50);
        System.out.println(x);
    }
}
