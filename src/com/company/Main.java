package com.company;

import java.io.*;

public class Main {

    private static String selectedEvent;

    public static void main(String[] args) throws IOException {
        Game g = new Game();
        Maze m= new Maze();
        m.init();

        g.drawAll();


    }
}
