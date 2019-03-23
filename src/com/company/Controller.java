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
        Tile entry = new Tile();
        t.accept(o);
        t.setNeighbours(e);
        Maze.addPanda(p);
        o.setNextPanda(p);
        p.setFollowingA(o);
        p.setFollow(true);
        e.setEntry(entry);
        o.move(e);
    }

    static  public void orangutanStepsInWardrobe(){
        Orangutan o=new Orangutan();
        Tile t=new Tile();
        Wardrobe w=new Wardrobe();
        Wardrobe nw=new Wardrobe();
        w.setNeighbourWardrobe(nw);
        t.setNeighbours(w);
        t.setAnimal(o);
        o.move(w);
    }

    static public void  orangutanPicksUpPanda(){
        Orangutan o=new Orangutan();
        ScaredPanda sp=new ScaredPanda();
        Tile t=new Tile();
        t.setAnimal(sp);
        o.move(t);
    }

}
