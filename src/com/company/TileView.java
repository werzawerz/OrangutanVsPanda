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
       // super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.RED);
        g.fillOval(x, y, 40, 40);
        ArrayList<Tile> tiles = Maze.getTiles();

        for(Tile t : tiles) {
            ArrayList<Tile> neigh = t.getNeighbours();
            for(Tile neighbour : neigh) {
                Line2D lin = new Line2D.Float(t.getView().getX()+20, t.getView().getY()+20, neighbour.getView().getX()+20, neighbour.getView().getY()+20);

                g2.draw(lin);
            }
        }

        //g.fillRect(25, 25, 50, 50);
    }
}
