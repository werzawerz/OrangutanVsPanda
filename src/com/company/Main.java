package com.company;

import java.io.*;
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
                g.drawAll();
                m.moveAllPandas();


            }
        }, 0, 2000);



    }
}
