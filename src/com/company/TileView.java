package com.company;


import java.awt.*;

public class TileView implements Drawable{
    private int x;
    private int y;
    Color color;

    public TileView(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        color = c;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.drawOval(x, y, 16, 16);
    }
}
