package com.company;


import java.util.Random;
/**
 * Az idozitésért felelős osztály
 */
public class Timer{

    static public void tick() {
        for(int i=0; i<Maze.getPandaSize();i++){
            Panda temp=Maze.getPanda(i);
            int rand = new Random().nextInt(temp.getPosition().getNeighbourSize());
            temp.move(temp.getPosition().getNeighbours().get(rand));
        }
    }
}
