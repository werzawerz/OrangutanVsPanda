package com.company;


import java.awt.*;

public class TileView implements Drawable{
    private int x;
    private int y;

    public TileView(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.drawOval(x, y, 16, 16);
    }
}
