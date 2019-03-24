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
        Tile pt = new Tile();
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
        p.setPosition(pt);
        pt.setAnimal(p);
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
     * Egy Orangutan egy VendingMachine-nel egy mezőre próbál lépni.
     */
    static public void orangutanCollidesWithVendingMachine(){
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        VendingMachine v1 = new VendingMachine();
        t1.setItem(v1);
        t2.setAnimal(o);
        o.setPosition(t2);
        t2.setNeighbours(t1);
        clearScreen();
        o.move(t1);
    };

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
        Tile ot=new Tile();
        Wardrobe w=new Wardrobe();
        Wardrobe nw=new Wardrobe();
        w.setNeighbourWardrobe(nw);
        t.setNeighbours(w);
        nw.setNeighbours(ot);
        t.setAnimal(o);
        o.setPosition(t);
        clearScreen();
        o.move(w);
    }

    static public void  orangutanPicksUpPanda(){
        Orangutan o=new Orangutan();
        ScaredPanda sp=new ScaredPanda();
        Tile t=new Tile();
        Tile ot=new Tile();
        t.setAnimal(sp);
        sp.setPosition(t);
        o.setPosition(ot);
        ot.setAnimal(o);
        clearScreen();
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

    static public void pandaCollidesWithTakenSofa(){
        ScaredPanda p1 = new ScaredPanda();
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        Sofa s1 = new Sofa();
        t1.setItem(s1);
        s1.setEmpty(false);
        t2.setAnimal(p1);
        p1.setPosition(t2);
        t2.setNeighbours(t1);
        clearScreen();
        p1.move(t1);
    }

    static  public  void  pandaCollidesWithVendingMachine(){
        ScaredPanda p1 = new ScaredPanda();
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        VendingMachine v1 = new VendingMachine();
        t1.setItem(v1);
        t2.setAnimal(p1);
        p1.setPosition(t2);
        t2.setNeighbours(t1);
        clearScreen();
        p1.move(t1);
    }

    static public void PandaCollidesWithArcade()
    {
        ScaredPanda p1 = new ScaredPanda();
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        Arcade a1 = new Arcade();
        t1.setItem(a1);
        t2.setAnimal(p1);
        p1.setPosition(t2);
        t2.setNeighbours(t1);
        clearScreen();
        p1.move(t2);
    }

    static  public  void  OrangutanCollidesWithOrangutan()
    {
        Orangutan o1 = new Orangutan();
        Orangutan o2 = new Orangutan();
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        t1.setAnimal(o1);
        t2.setAnimal(o2);
        o1.setPosition(t1);
        o2.setPosition(t2);
        t1.setNeighbours(t2);
        clearScreen();
        o1.move(t2);
    }

    static  public  void JumpingPandaJumps()
    {
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        JumpingPanda j = new JumpingPanda();
        VendingMachine v = new VendingMachine();
        t1.setAnimal(j);
        t2.setItem(v);
        j.setPosition(t1);
        v.setPosition(t2);
        t2.setNeighbours(t1);
        clearScreen();
        v.Notify();
    }

    static public void PandaMoves()
    {
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        ScaredPanda p = new ScaredPanda();
        t1.setAnimal(p);
        p.setPosition(t1);
        t2.setNeighbours(t1);
        t1.setNeighbours(t2);
        clearScreen();
        p.move(t2);
    }

    static public void OrangutanLeadsPanda()
    {
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        Tile t3 = new Tile();
        Orangutan o = new Orangutan();
        o.setPosition(t1);
        ScaredPanda sc = new ScaredPanda();
        sc.setPosition(t2);
        JumpingPanda jp = new JumpingPanda();
        jp.setPosition(t3);
        t1.setAnimal(o);
        t2.setAnimal(sc);
        t3.setAnimal(jp);

        Tile t4 = new Tile();
        o.setNextPanda(sc);
        sc.setFollow(true);
        sc.setFollowingA(o);
        sc.setNextPanda(jp);
        jp.setFollow(true);
        jp.setFollowingA(sc);
        clearScreen();


        o.move(t4);
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
