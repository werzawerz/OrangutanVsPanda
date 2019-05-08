package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class Main {

    private static String selectedEvent;

    public static void main(String[] args) throws IOException {
        Game g = new Game();
        Maze m= new Maze();
        m.init();
        g.drawInit();
        MyTimer t = new MyTimer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                g.drawInit();
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



    }
}
