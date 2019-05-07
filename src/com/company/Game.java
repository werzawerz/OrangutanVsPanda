package com.company;

public class Game {

    static private int points;

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

    static void drawAll(){

    }
}
