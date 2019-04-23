package com.company;

import java.io.*;

/**
 * A use-caseket intéző osztály, ami a tabulálásért is felel.
 */
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
/*        for(int i = 0; i<tab; i++) {
            System.out.print("\t");
        }
        System.out.println(s);*/
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

    public static void readFile(String text) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(text));
            String line = br.readLine();

            while (line != null) {

                doWork(line);
                line = br.readLine();
            }
        }
        catch(IOException e) {

        }
    }

    public static void doWork(String line) throws IOException {
        String lineArr[] = line.split(" ");
        switch(lineArr[0]) {
            case "load":
                BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt"));
                writer.write("");
                writer.close();
                Maze.init();
                readFile(lineArr[1]);
                break;
            case "put" :
                putAnim(lineArr[1], lineArr[2]);
                break;
            case "step" :
                moveAnim(lineArr[1], lineArr[2]);
                break;
            default:
                System.out.println("Wrong command");
                break;
        }
        if(lineArr.length>1) {
            switch (lineArr[1]) {
                case "follow":
                    makeFollow(lineArr[0], lineArr[2]);
                    break;
                case "sound":
                    makeSound(lineArr[0]);
                default:
                    break;
            }
        }
    }

    public static void putAnim(String animal, String tile) throws IOException {
        tile = tile.substring(1);
        int tileNum = Integer.parseInt(tile);
        Tile t = Maze.getTile(tileNum-1);
        if(animal.charAt(0) == 'o') {
            Orangutan o = new Orangutan();
            o.setName(animal);
            t.accept(o);
            o.setPosition(t);
            Maze.addOrangutan(o);
        }
        if(animal.charAt(0) == 'l') {
            LazyPanda lp = new LazyPanda();
            lp.setName(animal);
            t.accept(lp);
            lp.setPosition(t);
            Maze.addPanda(lp);
        }
        if(animal.charAt(0) == 's') {
            ScaredPanda sp = new ScaredPanda();
            sp.setName(animal);
            t.accept(sp);
            sp.setPosition(t);
            Maze.addPanda(sp);
        }
        if(animal.charAt(0) == 'j') {
            JumpingPanda jp = new JumpingPanda();
            jp.setName(animal);
            t.accept(jp);
            jp.setPosition(t);
            Maze.addPanda(jp);
        }
    }

    static void makeFollow(String a1, String a2) throws IOException {
        Orangutan o;
        Panda pFollowing;
        Panda pFollower;
        int PNum = Integer. parseInt(a1.substring(2));
        pFollower = Maze.getPanda(PNum-1);
        pFollower.setFollow(true);
        if(a2.charAt(0)=='o') {
            int ONum = Integer.parseInt(a2.substring(1));
            o = Maze.getOrangutan(ONum-1);
            o.setNextPanda(pFollower);
            pFollower.setFollowingA(o);
        }
        else {
            PNum = Integer.parseInt(a2.substring(2));
            pFollowing = Maze.getPanda(PNum-1);
            pFollowing.setNextPanda(pFollower);
            pFollower.setFollowingA(pFollowing);
        }
    }

    static void moveAnim(String a, String t) throws IOException {
        Animal anim;
        int TileNum = Integer.parseInt(t.substring(1));
        Tile tile = Maze.getTile(TileNum-1);
        if(a.charAt(0)=='o') {
            int ONum = Integer.parseInt(a.substring(1));
            anim = Maze.getOrangutan(ONum-1);
        }
        else {
            int PNum = Integer.parseInt(a.substring(2));
            anim = Maze.getPanda(PNum-1);
        }
        anim.move(tile);
    }

    static void makeSound(String t) throws IOException {
        int TileNum = Integer.parseInt(t.substring(1));
        Tile tile = Maze.getTile(TileNum-1);
        Item i = tile.getItem();
        i.notifyNeighbours();
    }

    /**
     * Use-case az orángután exit-re való lépésére, ahol az orángutánt követi egy panda
     */
    static public void orangutanStepsOutOnExit() {

        readFile("Test1.txt");
    }

    /**
     * egy panda olyan mezőre akar lépni, ahol egy másik panda található
     */
    static public void pandaCollidesWithPanda() {
        readFile("Test12.txt");
    }

    /**
     * Az Arcade hangajank hatasara a panda elengedi a pandak kezet
     */
    static public void scaredPandaGetsScared() {
        readFile("Test13.txt");

    }

    /**
     * Egy Orangutan egy VendingMachine-nel egy mezőre próbál lépni.
     */
    static public void orangutanCollidesWithVendingMachine(){
        readFile("Test10.txt");
    };

    /**
     * Ha a lazyPanda a sofaval szomszedos mezore lep, leul a sofara
     */
    static void lazyPandaSitsDown() {
        readFile("Test14.txt");
    }

    static  public void orangutanStepsInWardrobe(){
        readFile("Test8.txt");
    }

    static public void  orangutanPicksUpPanda() throws IOException {
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

    static void pandaStepsOnWeakTile() throws IOException {
        WeakTile wt = new WeakTile();
        JumpingPanda jp = new JumpingPanda();
        Tile t = new Tile();
        t.setAnimal(jp);
        jp.setPosition(t);
        wt.setStrength(5);
        clearScreen();
        jp.move(wt);
    }

    static void pandaStepsOnBrokenWeakTile() throws IOException {
        WeakTile wt = new WeakTile();
        JumpingPanda jp = new JumpingPanda();
        Tile t = new Tile();
        t.setAnimal(jp);
        jp.setPosition(t);
        wt.setStrength(1);
        clearScreen();
        jp.move(wt);
    }

    static public void pandaCollidesWithTakenSofa() throws IOException {
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

    static  public  void  pandaCollidesWithVendingMachine() throws IOException {
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

    static public void PandaCollidesWithArcade() throws IOException {
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

    /**
     * Orángután orángutánnal ütközik.
     */
    static  public  void  OrangutanCollidesWithOrangutan()
    {
        readFile("Test7.txt");
    }

    /**
     * JumpingPanda ugrik a VendingMachine jelzésére.
     */
    static  public  void JumpingPandaJumps() throws IOException {
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
        v.notifyNeighbours();
    }

    /**
     * Panda egy mezőről a másikra lép.
     */
    static public void PandaMoves() throws IOException {
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

    /**
     * Az orángután lép, és vezeti a pandákat.
     */
    static public void OrangutanLeadsPanda() throws IOException {
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
        readFile("Test2.txt");
    }

    /**
     *Az orangutan ralep egy tile-ra es osszetori azt, igy el lesz tavolitva a palyarol.
     */
    static void orangutanStepsOnBrokenWeakTile() {
        readFile("Test3.txt");
    }

    /**
     * Az orangutan megprobal egy olyan tile-ra lepni, ahol egy Sofa van, de nem tud odalepni.
     */
    static void orangutanCollidesWithSofa() {
        readFile("Test4.txt");
    }

    /**
     * Az orangutan megprobal egy olyan tile-ra lepni, ahol egy Arcade van, de nem tud odalepni.
     */
    static void orangutanCollidesWithArcade() {
        readFile("Test6.txt");
    }

    /**
     * Az orangutan egyik Tile-rol a masikra lep.
     */
    static void orangutanMoves() {
        readFile("Test5.txt");
    }
    


}
