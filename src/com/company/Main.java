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
                System.out.println("Ketmasodpercenkent");
                g.drawAll();
            }
        }, 0, 2000);

       // g.drawAll();

    }
}
