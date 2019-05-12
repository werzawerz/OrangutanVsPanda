package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class TileView extends JPanel implements Drawable{
    private int x;
    private int y;
    Color color;

    public TileView(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        color = c;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


    public void draw(Graphics g){
        paintComponent(g);
    }
    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        g.setColor(color);
        g.fillOval(x, y, 55, 55);
        ArrayList<Tile> tiles = Maze.getTiles();

        for(Tile t : tiles) {
            ArrayList<Tile> neigh = t.getNeighbours();
            for(Tile neighbour : neigh) {
                Line2D lin = new Line2D.Float(t.getView().getX()+27, t.getView().getY()+27, neighbour.getView().getX()+27, neighbour.getView().getY()+27);

                g2.draw(lin);
            }
        }


    }
}
