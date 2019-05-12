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
    /**
     * a játékhoz tartozó panel
     */
    JPanel gamePanel;
    /**
     * a menühöz tartozó panel
     */
    JPanel menuPanel;
    /**
     * melyik orángutánnal akarunk lépni
     */
    Orangutan orangutanClicked;
    /**
     * a program JFramee
     */
    JFrame jf = new JFrame("Orangutan vs Pandas");
    /**
     * a pontokat megjelenitő label
     */
    JLabel pointLabel;
    Maze m= new Maze();
    /**
     * a játékos által szerzett pontok
     */
    static private int points;

    /**
     * @throws IOException
     * játék konstruktora, mely beállitja a játék grafikus megjelenitését
     */
    public Game() throws IOException {
        m.init();
        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        menuPanel = menu();
        pointLabel = new JLabel();
        pointLabel.setText("Pontok: "+Integer.toString(points));
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.add(gamePanel);
        pointLabel.setBounds(722,10,80,40);
        gamePanel.add(pointLabel);
        jf.add(menuPanel);
        //jf.add(gamePanel);
        jf.setSize(800, 600);
        jf.setLocationRelativeTo(null);
        jf.addMouseListener(this);
        jf.setVisible(true);
    }


    /**
     * @param i pontokat i-vel növelő fv
     */
    static void addPoints(int i) {
        points += i;

    }

    /**
     * @param orangutanWon
     * a játék végén meghivandó függvény
     */
    static void endGame(boolean orangutanWon) {
        if(orangutanWon) {
            System.out.println("Orangutans have won");
        }
        else {
            System.out.println("Panda have won");
        }
    }

    /**
     * a pályán végzett rajzolásokat megvalósitó metódus
     */
    void drawInit(){

        ArrayList<Tile> tiles = Maze.getTiles();
        ArrayList<ThingView> things = Maze.getThings();
        pointLabel.setText("Pontok: "+Integer.toString(points));
        for(Tile t : tiles){
            if(t.getStrength()<=0)
                t.getView().color=new Color(0,0,0);
            else
                t.getView().draw(gamePanel.getGraphics());
        }

        for(ThingView t:things){
            t.draw(gamePanel.getGraphics());
        }
        if (Maze.getPandaSize() == 0) jf.add(menuPanel);


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
    /**
     * @return léterhozza a menü JPaneljét
     */
    JPanel menu() throws IOException {
            JPanel menu = new JPanel();
            JButton btnPlay = new JButton("Play");
            JButton btnExit = new JButton("Exit");

            BufferedImage myPicture = ImageIO.read(new File("menu.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setBounds(272, 50, 256, 256);
            menu.add(picLabel);

            btnPlay.setBounds(100, 500, 200, 40);
            btnExit.setBounds(500, 500, 200, 40);
            menu.setLayout(null);
            menu.add(btnPlay);
            menu.add(btnExit);
            btnPlay.addActionListener(this);
            btnExit.addActionListener(this);
        return menu;
    }

    /**
     * @param e
     * kattintás esetén meghivandó függvény
     */
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
                System.out.println("Kivalaszt");
                orangutanClicked = o;
                break;
            }
        }}
        if (orangutanClicked != null) {
            ArrayList<Tile> neigh = orangutanClicked.getPosition().getNeighbours();
            for(Tile t : neigh){

                if (mouseinRect(x, y, t.getView().getX()+10, t.getView().getX()+65, t.getView().getY()+30, t.getView().getY()+85)){
                    System.out.println("Lep");
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

    /**
     * @param x
     * @param y
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * Eldönti hogy az x,y pont benne van-e a x1,y1 és x2,y2 által alakotott téglalapban
     * @return
     */
    public boolean mouseinRect(int x, int y, int x1, int x2, int y1, int y2) {
        int xfga = 3;
        if (x > x1 && x < x2)
            if (y > y1 && y < y2) return true;
        return false;
    }

    /**
     * @param e
     * gombnyomásra meghivandó metódus
     */
        @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Play" : {
                menuPanel.setVisible(false);
                jf.remove(menuPanel);
                jf.add(gamePanel);
                drawInit();
                MyTimer t = new MyTimer();
                t.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        drawInit();
                        m.moveAllPandas();
                        ArrayList<Item> items =  m.getItems();
                        for(Item i : items) {
                            try {
                                i.notifyNeighbours();
                            }catch(IOException ioe) {

                            }
                        }


                    }
                }, 0, 2000);

                break;
            }
            case "Exit" : {
                System.exit(0);
                break;
            }
        }
    }
}
