package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A pályát, és a különböző pályaelemeket nyilvántartó osztály.
 */
public class Maze {

    /**
     * A pálya csempéit tartalmazó tömb.
     */
    static private ArrayList<Tile> tiles;

    /**
     * A pályán lévő pandákat tartalmazó tömb.
     */
    static private ArrayList<Panda> pandas ;

    /**
     * A pályán lévő Orángutánokat tartalmazó tömb.
     */
    static private ArrayList<Orangutan> orangutans;

    /**
     * A pályán lévő, nem mozgó elemek tömbje.
     */
    static private ArrayList<Item> items;

    /**
     * Betölti a hardcoded pályát, amit a proto használ.
     */
    static public void init() throws IOException {
        tiles=new ArrayList<>();
        pandas=new ArrayList<>();
        orangutans = new ArrayList<>();
        items = new ArrayList<Item>();
        for(int i=0; i<14; i++){
            tiles.add(new Tile());
        }
        tiles.add(1, new WeakTile());
        tiles.add(3, new Wardrobe());
        tiles.add(9, new WeakTile());
        tiles.add(11, new WeakTile());
        tiles.add(15, new Wardrobe());
        tiles.add(18, new Exit());
        tiles.add(20, new WeakTile());
        for(int i=0;i<21;i++){
        tiles.get(i).setName("t"+(i+1));}
        tiles.get(9).decreaseStrength(10000);
        tiles.get(18).setEntry(tiles.get(0));
        Sofa s1=new Sofa();
        s1.setName("s1");
        VendingMachine v1=new VendingMachine();
        v1.setName("v1");
        Arcade a1=new Arcade();
        a1.setName("a1");
        items.add(a1);
        items.add(v1);
        items.add(s1);
        tiles.get(8).setItem(s1);
        tiles.get(17).setItem(v1);
        tiles.get(6).setItem(a1);
        s1.setPosition(tiles.get(8));
        v1.setPosition(tiles.get(17));
        a1.setPosition(tiles.get(6));

        tiles.get(0).setNeighbours(tiles.get(1));
        tiles.get(0).setNeighbours(tiles.get(4));
        tiles.get(0).setNeighbours(tiles.get(5));

        tiles.get(1).setNeighbours(tiles.get(0));
        tiles.get(1).setNeighbours(tiles.get(2));
        tiles.get(1).setNeighbours(tiles.get(6));

        tiles.get(2).setNeighbours(tiles.get(1));
        tiles.get(2).setNeighbours(tiles.get(6));
        tiles.get(2).setNeighbours(tiles.get(3));

        tiles.get(3).setNeighbours(tiles.get(2));
        tiles.get(3).setNeighbours(tiles.get(7));
        tiles.get(3).setNeighbours(tiles.get(8));
        tiles.get(3).setNeighbourWardrobe(tiles.get(15));

        tiles.get(4).setNeighbours(tiles.get(0));
        tiles.get(4).setNeighbours(tiles.get(5));
        tiles.get(4).setNeighbours(tiles.get(9));
        tiles.get(4).setNeighbours(tiles.get(10));


        tiles.get(5).setNeighbours(tiles.get(0));
        tiles.get(5).setNeighbours(tiles.get(4));
        tiles.get(5).setNeighbours(tiles.get(6));
        tiles.get(5).setNeighbours(tiles.get(10));
        tiles.get(5).setNeighbours(tiles.get(11));

        tiles.get(6).setNeighbours(tiles.get(1));
        tiles.get(6).setNeighbours(tiles.get(2));
        tiles.get(6).setNeighbours(tiles.get(5));
        tiles.get(6).setNeighbours(tiles.get(7));
        tiles.get(6).setNeighbours(tiles.get(11));

        tiles.get(7).setNeighbours(tiles.get(3));
        tiles.get(7).setNeighbours(tiles.get(8));
        tiles.get(7).setNeighbours(tiles.get(6));
        tiles.get(7).setNeighbours(tiles.get(12));

        tiles.get(8).setNeighbours(tiles.get(3));
        tiles.get(8).setNeighbours(tiles.get(7));
        tiles.get(8).setNeighbours(tiles.get(12));

        tiles.get(9).setNeighbours(tiles.get(4));
        tiles.get(9).setNeighbours(tiles.get(15));
        tiles.get(9).setNeighbours(tiles.get(16));

        tiles.get(10).setNeighbours(tiles.get(4));
        tiles.get(10).setNeighbours(tiles.get(5));
        tiles.get(10).setNeighbours(tiles.get(11));
        tiles.get(10).setNeighbours(tiles.get(17));

        tiles.get(11).setNeighbours(tiles.get(5));
        tiles.get(11).setNeighbours(tiles.get(6));
        tiles.get(11).setNeighbours(tiles.get(12));
        tiles.get(11).setNeighbours(tiles.get(10));
        tiles.get(11).setNeighbours(tiles.get(13));
        tiles.get(11).setNeighbours(tiles.get(14));
        tiles.get(11).setNeighbours(tiles.get(17));

        tiles.get(12).setNeighbours(tiles.get(8));
        tiles.get(12).setNeighbours(tiles.get(7));
        tiles.get(12).setNeighbours(tiles.get(11));
        tiles.get(12).setNeighbours(tiles.get(13));

        tiles.get(13).setNeighbours(tiles.get(11));
        tiles.get(13).setNeighbours(tiles.get(12));
        tiles.get(13).setNeighbours(tiles.get(14));
        tiles.get(13).setNeighbours(tiles.get(18));

        tiles.get(14).setNeighbours(tiles.get(11));
        tiles.get(14).setNeighbours(tiles.get(13));
        tiles.get(14).setNeighbours(tiles.get(17));
        tiles.get(14).setNeighbours(tiles.get(18));

        tiles.get(15).setNeighbours(tiles.get(9));
        tiles.get(15).setNeighbours(tiles.get(16));
        tiles.get(15).setNeighbours(tiles.get(19));
        tiles.get(15).setNeighbourWardrobe(tiles.get(3));

        tiles.get(16).setNeighbours(tiles.get(9));
        tiles.get(16).setNeighbours(tiles.get(15));
        tiles.get(16).setNeighbours(tiles.get(19));
        tiles.get(16).setNeighbours(tiles.get(20));
        tiles.get(16).setNeighbours(tiles.get(17));

        tiles.get(17).setNeighbours(tiles.get(11));
        tiles.get(17).setNeighbours(tiles.get(10));
        tiles.get(17).setNeighbours(tiles.get(14));
        tiles.get(17).setNeighbours(tiles.get(18));
        tiles.get(17).setNeighbours(tiles.get(16));

        tiles.get(18).setNeighbours(tiles.get(13));
        tiles.get(18).setNeighbours(tiles.get(14));
        tiles.get(18).setNeighbours(tiles.get(17));
        tiles.get(18).setNeighbours(tiles.get(20));

        tiles.get(19).setNeighbours(tiles.get(15));
        tiles.get(19).setNeighbours(tiles.get(16));
        tiles.get(19).setNeighbours(tiles.get(20));

        tiles.get(20).setNeighbours(tiles.get(19));
        tiles.get(20).setNeighbours(tiles.get(16));
        tiles.get(20).setNeighbours(tiles.get(18));

        System.out.print("\b");
        System.out.print("\b");
        System.out.print("\b");
        System.out.print("\b");
    }

    /**
     * Megnézi, hogy vannak-e még pandák vagy orángutánok a
     * pályán.
     */
    static void check() {
        if(pandas.size()<=0){
            Game.endGame(true);
        }
        else if(orangutans.size()<=0){
            Game.endGame(false);
        }
    }

    /**
     * @param p A sorban lévő első panda
     * Rekurzív függvény, a panda mindig meghívja
     * a sorban következő pandára, amikor kimennek a kijáraton, vagy.
     */
    static void removePanda(Panda p) throws IOException {
        if(p.getNextPanda()!=null)
            removePanda(p.getNextPanda());
        pandas.remove(p);
    }

    /**
     * @param p A Maze-ről levevendő panda
     */
    static void removeOnePanda(Panda p) throws IOException {
/*        Controller.incTab();
        Controller.writeClassAndFunction("MAZE:removeOnePanda(p)");*/
        pandas.remove(p);
        //Controller.decTab();
    }

    /**
     * @param o
     * Kiveszi o-t az orangutans-ból.
     */
    static void removeOrangutan(Orangutan o) throws IOException {
        /*Controller.incTab();
        Controller.writeClassAndFunction("MAZE:removeOrangutan(o)");*/
        orangutans.remove(o);
        //Controller.decTab();
    }

    /**
     * @param p p-t hozzáaadja a pályán lévő pandákhoz
     */
    static void addPanda(Panda p) {
        pandas.add(p);
    }

    static Panda getPanda(int i){
        return pandas.get(i);
    }

    static int getPandaSize(){
        return pandas.size();
    }

    static int getOrangutanSize(){
        return orangutans.size();
    }

    static int getTileSize(){
        return tiles.size();
    }

    static Tile getTile(int i) {
        return tiles.get(i);
    }

    static void addOrangutan(Orangutan o) {
        orangutans.add(o);
    }

    static Orangutan getOrangutan(int i) {
        return orangutans.get(i);
    }

    static ArrayList<Item> getItems(){
        return items;
    }
}
