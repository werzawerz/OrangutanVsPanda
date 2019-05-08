package com.company;

import java.io.*;
import java.util.TimerTask;

public class Main {

    private static String selectedEvent;

    public static void main(String[] args) throws IOException {
        Game g = new Game();
        Maze m= new Maze();
        m.init();

        MyTimer t = new MyTimer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Ketmasodpercenkent");

            }
        }, 0, 2000);

        g.drawAll();

    }
}
