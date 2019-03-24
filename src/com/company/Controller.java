package com.company;

import java.io.IOException;

public class Controller {

    /**
     * tabulálások száma
     */
    static private int tab = -1;

    /**
     * tabulálás növelése
     */
    static public void incTab() {
        tab++;
    }

    /**
     * tabulálás csökkentése
     */
    static public void decTab() {
        tab--;
    }

    /**
     * @param s a tabulálással együtt kiirja az osztály és függvény nevet
     *          amely az s stringben van átadva
     */
    static public void writeClassAndFunction(String s) {
        for(int i = 0; i<tab; i++) {
            System.out.print("\t");
        }
        System.out.println(s);
    }

    /**
     * inicializálások után letörli a konzol tartalmát és a tabulálást visszaállitja -1re
     */
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
        tab = -1;
    }

    /**
     * Use-case az orángután exit-re való lépésére, ahol az orángutánt követi egy panda
     */
    static public void orangutanStepsOutOnExit() {
        Orangutan o = new Orangutan();
        Tile t = new Tile();
        Exit e = new Exit();
        JumpingPanda p = new JumpingPanda();
        Tile entry = new Tile();
        t.accept(o);
        o.setPosition(t);
        t.setNeighbours(e);
        Maze.addPanda(p);
        o.setNextPanda(p);
        p.setFollowingA(o);
        p.setFollow(true);
        e.setEntry(entry);
        clearScreen();
        o.move(e);
    }

    /**
     * egy panda olyan mezőre akar lépni, ahol egy másik panda található
     */
    static public void pandaCollidesWithPanda() {
        Tile t = new Tile();
        Panda sp = new ScaredPanda();
        Panda lp = new LazyPanda();
        t.accept(lp);
        clearScreen();
        sp.move(t);
    }

    /**
     * Az Arcade hangajank hatasara a panda elengedi a pandak kezet
     */
    static public void scaredPandaGetsScared() {
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        Arcade a = new Arcade();
        ScaredPanda sc1 = new ScaredPanda();
        ScaredPanda sc2 = new ScaredPanda();
        t1.setItem(a);
        t1.setNeighbours(t2);
        t2.accept(sc1);
        sc2.setFollowingA(sc1);
        sc1.setNextPanda(sc2);
        a.setPosition(t1);
        clearScreen();
        a.notifyNeighbours();

    }

    /**
     * Ha a lazyPanda a sofaval szomszedos mezore lep, leul a sofara
     */
    static void lazyPandaSitsDown() {
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        Sofa s = new Sofa();
        LazyPanda lp = new LazyPanda();
        t1.setNeighbours(t2);
        t1.setItem(s);
        s.setPosition(t1);
        t2.accept(lp);
        lp.setPosition(t2);
        clearScreen();
        s.notifyNeighbours();
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

    static void pandaStepsOnWeakTile() {
        WeakTile wt = new WeakTile();
        JumpingPanda jp = new JumpingPanda();
        Tile t = new Tile();
        t.setAnimal(jp);
        jp.setPosition(t);
        wt.setStrength(5);
        clearScreen();
        jp.move(wt);
    }

    static void pandaStepsOnBrokenWeakTile() {
        WeakTile wt = new WeakTile();
        JumpingPanda jp = new JumpingPanda();
        Tile t = new Tile();
        t.setAnimal(jp);
        jp.setPosition(t);
        wt.setStrength(1);
        clearScreen();
        jp.move(wt);
    }


    /**
     * Az orangutan egy WeakTile-ra lep, csokkenti a tile strengthjet.
     */
    static void orangutanStepsOnWeakTile() {
        WeakTile wt = new WeakTile();
        Orangutan o = new Orangutan();
        Tile t = new Tile();
        t.setAnimal(o);
        o.setPosition(t);
        wt.setStrength(5);
        clearScreen();
        o.move(wt);
    }

    /**
     *Az orangutan ralep egy tile-ra es osszetori azt, igy el lesz tavolitva a palyarol.
     */
    static void orangutanStepsOnBrokenWeakTile() {
        WeakTile wt = new WeakTile();
        Orangutan o = new Orangutan();
        Tile t = new Tile();
        t.setAnimal(o);
        o.setPosition(t);
        wt.setStrength(1);
        clearScreen();
        o.move(wt);
    }

    /**
     * Az orangutan megprobal egy olyan tile-ra lepni, ahol egy Sofa van, de nem tud odalepni.
     */
    static void orangutanCollidesWithSofa() {
        Tile t = new Tile();
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        Sofa s = new Sofa();
        t1.setAnimal(o);
        //o.setPosition(t1);
        t.setItem(s);
        //s.setPosition(t);
        clearScreen();
        o.move(t);
    }

    /**
     * Az orangutan megprobal egy olyan tile-ra lepni, ahol egy Arcade van, de nem tud odalepni.
     */
    static void orangutanCollidesWithArcade() {
        Tile t = new Tile();
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        Arcade a = new Arcade();
        t1.setAnimal(o);
        //o.setPosition(t1);
        t.setItem(a);
        //s.setPosition(t);
        clearScreen();
        o.move(t);
    }

    /**
     * Az orangutan egyik Tile-rol a masikra lep.
     */
    static void orangutanMoves() {
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        t1.setAnimal(o);
        o.setPosition(t1);
        clearScreen();
        o.move(t2);
    }

}
