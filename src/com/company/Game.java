package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

public class Game extends JFrame implements ActionListener {
    JPanel gamePanel;
    JPanel menuPanel;
    static private int points;
    public Game() {
        super();

        gamePanel = new JPanel();
        menuPanel = menu();
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.add(gamePanel);
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

    void drawInit(){

        ArrayList<Tile> tiles = Maze.getTiles();
        ArrayList<ThingView> things = Maze.getThings();

        int cnt=0;
        for(Tile t : tiles){
            t.getView().draw(gamePanel.getGraphics());
        }

        for(ThingView t:things){
            t.draw(gamePanel.getGraphics());
        }

    }
    void drawAll(){
        ArrayList<Panda> pandas = Maze.getPandas();
        ArrayList<ThingView> things = Maze.getThings();
        for (Panda p : pandas) {
            for(ThingView t:things) {
                if (p.getPosition().equals(t.getObj().getPosition())) t.draw(gamePanel.getGraphics());
            }
        }
    }
    JPanel menu(){
        JPanel menu = new JPanel();
            JButton btnPlay = new JButton("Play");
            JButton btnExit = new JButton("Exit");

            btnPlay.setBounds(100, 500, 200, 40);
            btnExit.setBounds(500, 500, 200, 40);
            menu.setLayout(null);
            menu.add(btnPlay);
            menu.add(btnExit);
            btnPlay.addActionListener(this);
            btnExit.addActionListener(this);
        return menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Play" : {
                menuPanel.setVisible(false);
                this.remove(menuPanel);
                this.add(gamePanel);
                gamePanel.setBackground(Color.DARK_GRAY);
                this.drawAll();

                break;
            }
            case "Exit" : {
                System.exit(0);
                break;
            }
        }
    }
}
