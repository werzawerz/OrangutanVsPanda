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


    static private ArrayList<ThingView> thingViews;

    /**
     * Betölti a hardcoded pályát, amit a proto használ.
     */
    static public void init() throws IOException {
        tiles=new ArrayList<>();
        pandas=new ArrayList<>();
        orangutans = new ArrayList<>();
        items = new ArrayList<Item>();

        for(int i=0; i<37; i++){
            tiles.add(new Tile());
        }
        tiles.add(29, new WeakTile());
        tiles.add(25, new WeakTile());
        tiles.add(34, new Wardrobe());
        tiles.add(40, new Wardrobe());
        tiles.add(23, new Exit());

        //Tileok pozicioja 0 es 8 kozott
        for(int i=0; i<=8; i++) {
            tiles.get(i).setUpTileView(i*80+20, 20);
        }

        for(int i=9; i<=14;i++) {
            tiles.get(i).setUpTileView(640-(i-9)*100, 140);
        }

        for(int i=15; i<=23; i++) {
            tiles.get(i).setUpTileView((i-15)*80+20, 260);
        }

        for(int i=24; i<=32;i++) {
            tiles.get(i).setUpTileView(690-(i-24)*80, 380);
        }

        for(int i=33; i<=41; i++) {
            tiles.get(i).setUpTileView((i-33)*80+20, 500);
        }

        tiles.get(34).setNeighbourWardrobe(tiles.get(40));
        tiles.get(40).setNeighbourWardrobe(tiles.get(34));

        tiles.get(23).setEntry(tiles.get(15));

        tiles.get(0).setNeighbours(new Tile[]{tiles.get(1),
                tiles.get(15)});
        tiles.get(1).setNeighbours(new Tile[]{tiles.get(0),
                tiles.get(15), tiles.get(14)});
        tiles.get(2).setNeighbours(new Tile[]{tiles.get(3),
                tiles.get(13), tiles.get(14)});
        tiles.get(3).setNeighbours(new Tile[]{tiles.get(2),
                tiles.get(13), tiles.get(4)});
        tiles.get(4).setNeighbours(new Tile[]{tiles.get(3),
                tiles.get(5), tiles.get(13)});
        tiles.get(5).setNeighbours(new Tile[]{tiles.get(4),
                tiles.get(6), tiles.get(12)});
        tiles.get(6).setNeighbours(new Tile[]{tiles.get(5),
                tiles.get(6), tiles.get(12), tiles.get(11)});
        tiles.get(7).setNeighbours(new Tile[]{tiles.get(6),
                tiles.get(8), tiles.get(10)});
        tiles.get(8).setNeighbours(new Tile[]{tiles.get(7),
                tiles.get(9)});
        tiles.get(9).setNeighbours(new Tile[]{tiles.get(8),
                tiles.get(10), tiles.get(23)});
        tiles.get(10).setNeighbours(new Tile[]{tiles.get(7),
                tiles.get(9), tiles.get(11), tiles.get(23)});
        tiles.get(11).setNeighbours(new Tile[]{tiles.get(10),
                tiles.get(6), tiles.get(23), tiles.get(22), tiles.get(12)});
        tiles.get(12).setNeighbours(new Tile[]{tiles.get(6),
                tiles.get(11), tiles.get(21), tiles.get(22), tiles.get(10),
                tiles.get(19), tiles.get(13), tiles.get(4), tiles.get(5)});
        tiles.get(13).setNeighbours(new Tile[]{tiles.get(2),
                tiles.get(3), tiles.get(4), tiles.get(12), tiles.get(19),
                tiles.get(18), tiles.get(17), tiles.get(16), tiles.get(14)});
        tiles.get(14).setNeighbours(new Tile[]{tiles.get(1),
                tiles.get(15), tiles.get(16), tiles.get(13), tiles.get(2)});
        tiles.get(15).setNeighbours(new Tile[]{tiles.get(0),
                tiles.get(1), tiles.get(14), tiles.get(16), tiles.get(30),
                tiles.get(32), tiles.get(31)});
        tiles.get(16).setNeighbours(new Tile[]{tiles.get(13),
                tiles.get(14), tiles.get(15), tiles.get(17), tiles.get(30)});
        tiles.get(17).setNeighbours(new Tile[]{tiles.get(13),
                tiles.get(16), tiles.get(18), tiles.get(29)});
        tiles.get(18).setNeighbours(new Tile[]{tiles.get(13),
                tiles.get(17), tiles.get(19), tiles.get(27), tiles.get(28)});
        tiles.get(19).setNeighbours(new Tile[]{tiles.get(12),
                tiles.get(13), tiles.get(18), tiles.get(20), tiles.get(27)});
        tiles.get(20).setNeighbours(new Tile[]{tiles.get(12),
                tiles.get(19), tiles.get(21), tiles.get(26), tiles.get(27)});
        tiles.get(31).setNeighbours(new Tile[]{tiles.get(15),
                tiles.get(32)});
        tiles.get(32).setNeighbours(new Tile[]{tiles.get(15),
                tiles.get(30), tiles.get(31), tiles.get(33)});
        tiles.get(33).setNeighbours(new Tile[]{tiles.get(29),
                tiles.get(32)});
        tiles.get(34).setNeighbours(new Tile[]{tiles.get(28),
                tiles.get(29), tiles.get(35)});
        tiles.get(35).setNeighbours(new Tile[]{tiles.get(27),
                tiles.get(28), tiles.get(34)});
        tiles.get(21).setNeighbours(new Tile[]{tiles.get(20), tiles.get(22), tiles.get(25),tiles.get(12)});
        tiles.get(22).setNeighbours(new Tile[] {tiles.get(21), tiles.get(11), tiles.get(23), tiles.get(12), tiles.get(24)});
        tiles.get(23).setNeighbours(new Tile[] {tiles.get(9), tiles.get(10),tiles.get(11),tiles.get(22), tiles.get(24), tiles.get(39), tiles.get(40)});
        tiles.get(24).setNeighbours(new Tile[]{tiles.get(22), tiles.get(25),tiles.get(39),tiles.get(23)});
        tiles.get(25).setNeighbours(new Tile[]{tiles.get(21),tiles.get(26),tiles.get(37),tiles.get(38),tiles.get(24)});
        tiles.get(26).setNeighbours(new Tile[]{tiles.get(20),tiles.get(27),tiles.get(36),tiles.get(25)});
        tiles.get(27).setNeighbours(new Tile[]{tiles.get(19),tiles.get(18),tiles.get(28),tiles.get(35),tiles.get(36),tiles.get(26),tiles.get(20)});
        tiles.get(28).setNeighbours(new Tile[]{tiles.get(18),tiles.get(29),tiles.get(34),tiles.get(35),tiles.get(27)});
        tiles.get(29).setNeighbours(new Tile[]{tiles.get(17),tiles.get(30),tiles.get(33),tiles.get(34),tiles.get(28)});
        tiles.get(30).setNeighbours(new Tile[]{tiles.get(16),tiles.get(32),tiles.get(15),tiles.get(29)});
        tiles.get(36).setNeighbours(new Tile[]{tiles.get(26),
                tiles.get(27), tiles.get(37)});
        tiles.get(37).setNeighbours(new Tile[]{tiles.get(36),
                tiles.get(25), tiles.get(41)});
        tiles.get(38).setNeighbours(new Tile[]{tiles.get(25),
                tiles.get(39), tiles.get(41)});
        tiles.get(39).setNeighbours(new Tile[]{tiles.get(23),
                tiles.get(24), tiles.get(38), tiles.get(40)});
        tiles.get(40).setNeighbours(new Tile[]{tiles.get(23),
                tiles.get(39)});
        tiles.get(41).setNeighbours(new Tile[]{tiles.get(37),
                tiles.get(38)});

        pandas.add(new JumpingPanda());
        pandas.add(new JumpingPanda());
        pandas.add(new LazyPanda());
        pandas.add(new LazyPanda());
        pandas.add(new ScaredPanda());
        pandas.add(new ScaredPanda());

        tiles.get(2).accept(pandas.get(0));
        tiles.get(18).accept(pandas.get(1));
        tiles.get(4).accept(pandas.get(2));
        tiles.get(9).accept(pandas.get(3));
        tiles.get(10).accept(pandas.get(4));
        tiles.get(37).accept(pandas.get(5));

        tiles.get(12).setItem(new Arcade());
        items.add(tiles.get(12).getItem());

        tiles.get(41).setItem(new Sofa());
        items.add(tiles.get(41).getItem());

        tiles.get(27).setItem(new VendingMachine());
        items.add(tiles.get(27).getItem());

        /*for(int i=0; i<14; i++){
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

        tiles.get(15).setNeighbours(tiles.get(16));
        tiles.get(15).setNeighbours(tiles.get(9));
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
*/

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

    static ArrayList<Tile> getTiles(){return tiles;}

    static ArrayList<ThingView> getThings() {return thingViews;}
}
