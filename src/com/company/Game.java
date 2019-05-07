package com.company;

import java.util.ArrayList;

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

        ArrayList<Tile> tiles = Maze.getTiles();
        ArrayList<ThingView> things = Maze.getThings();

        int cnt=0;
        for(Tile t : tiles){
            tiles.get(cnt).getView().draw();
        }

        for(ThingView t:things){
            t.draw();
        }

    }
}
