package com.company;
import java.util.Random;
import java.util.Timer;
/**
 * Az idozitésért felelős osztály
 */
public class MyTimer extends Thread{

    public void tick() {
        for(int i=0; i<Maze.getPandaSize();i++){
            Panda temp=Maze.getPanda(i);
            int rand = new Random().nextInt(temp.getPosition().getNeighbourSize());
            temp.move(temp.getPosition().getNeighbours().get(rand));
        }
    }

}
