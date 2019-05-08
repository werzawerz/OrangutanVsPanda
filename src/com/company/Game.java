package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JFrame {
    JPanel gamePanel ;
    static private int points;
    public Game() {
        super();
        gamePanel = new JPanel();
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setContentPane(gamePanel);

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    static void addPoints(int i) {
        points += i;

    }

    static void endGame(boolean orangutanWon) {
        if(orangutanWon) {
            System.out.println("Orangutans have won");
        }
        else {
            System.out.println("Panda have won");
        }
    }

    void drawAll(){

        ArrayList<Tile> tiles = Maze.getTiles();
        ArrayList<ThingView> things = Maze.getThings();

        int cnt=0;
        for(Tile t : tiles){
            t.getView().draw(gamePanel.getGraphics());
        }

//        for(ThingView t:things){
     //       t.draw(this.getGraphics());
     //   }

    }
}
