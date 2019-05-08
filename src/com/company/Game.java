package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

public class Game extends MouseAdapter implements ActionListener {
    JPanel gamePanel;
    JPanel menuPanel;
    Orangutan orangutanClicked;
    JFrame jf = new JFrame("Orangutan vs Pandas");
    static private int points;
    public Game() {
        //jf.super("OrangutanVSPandas");

        gamePanel = new JPanel();
        menuPanel = menu();
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.add(gamePanel);
        jf.setSize(800, 600);
        jf.setLocationRelativeTo(null);
        jf.addMouseListener(this);
        jf.setVisible(true);
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
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        ArrayList<Orangutan> os = Maze.getOrangutans();
        if(orangutanClicked == null){
        for(Orangutan o : os){
           // gamePanel.getGraphics().setColor(Color.BLACK);
           // gamePanel.getGraphics().drawRect(o.getPosition().getView().getX(), o.getPosition().getView().getY(), 55, 55);
            if (mouseinRect(x, y, o.getPosition().getView().getX()+10, o.getPosition().getView().getX()+65, o.getPosition().getView().getY()+30, o.getPosition().getView().getY()+85)){
                System.out.println("GECCIII");
                orangutanClicked = o;
                break;
            }
        }}
        if (orangutanClicked != null) {
            ArrayList<Tile> neigh = orangutanClicked.getPosition().getNeighbours();
            for(Tile t : neigh){

                if (mouseinRect(x, y, t.getView().getX()+10, t.getView().getX()+65, t.getView().getY()+30, t.getView().getY()+85)){
                    System.out.println("FASZOM");
                    try {
                        orangutanClicked.move(t);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    orangutanClicked = null;
                    break;
                }
            }
        }
    }

    public boolean mouseinRect(int x, int y, int x1, int x2, int y1, int y2) {
        if (x > x1 && x < x2)
            if (y > y1 && y < y2) return true;
        return false;
    }

        @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Play" : {
                menuPanel.setVisible(false);
                jf.remove(menuPanel);
                jf.add(gamePanel);
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
