package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game extends JFrame {
    JPanel gamePanel;
    JPanel menuPanel;
    static private int points;
    public Game() {
        super();
        
        gamePanel = new JPanel();
        menuPanel = menu();
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        getContentPane().add(gamePanel);
        //getContentPane().add(menuPanel);
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
    JPanel menu(){
        JPanel menu = new JPanel();
            JButton play = new JButton("Play");
            JButton exit = new JButton("Exit");

            play.setBounds(100, 500, 200, 40);
            exit.setBounds(500, 500, 200, 40);
            menu.setLayout(null);
            menu.add(play);
            menu.add(exit);
        return menu;
    }
}
