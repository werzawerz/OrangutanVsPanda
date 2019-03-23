package com.company;

public class Game {

    static private int points;

    static void addPoints(int i) {
        Controller.incTab();
        Controller.writeClassAndFunction("GAME:addPoints(i)");
        points += i;
        Controller.decTab();
    }
}
