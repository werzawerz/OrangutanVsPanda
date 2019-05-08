package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
/**
 * Az idozitésért felelős osztály
 */
public class MyTimer extends Timer{

    public void tick() throws IOException {
        for(int i=0; i<Maze.getPandaSize();i++){
            Panda temp=Maze.getPanda(i);
            int rand = new Random().nextInt(temp.getPosition().getNeighbourSize());
            temp.move(temp.getPosition().getNeighbours().get(rand));
        }
        ArrayList<Item> items = Maze.getItems();

        int rand = new Random().nextInt(3);
        if(rand==1){
            for(int i=0; i<items.size();i++){
                items.get(0).notifyNeighbours();
            }
        }

       // Game.drawAll();


    }

}
