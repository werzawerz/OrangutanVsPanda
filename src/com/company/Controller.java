package com.company;

public class Controller {

    static private int tab = -1;

    static public void incTab() {
        tab++;
    }

    static public void decTab() {
        tab--;
    }

    static public void writeClassAndFunction(String s) {
        for(int i = 0; i<tab; i++) {
            System.out.print("\t");
        }
        System.out.println(s);
    }

    static public void orangutanStepsOutOnExit() {
        Orangutan o = new Orangutan();
        Tile t = new Tile();
        Exit e = new Exit();
        JumpingPanda p = new JumpingPanda();
        t.accept(o);
        t.setNeighbours(e);
        Maze.addPanda(p);
        p.setNextPanda(p);
        p.setFollowingA(o);
        p.setFollow(true);
        o.move(e);
    }

}
