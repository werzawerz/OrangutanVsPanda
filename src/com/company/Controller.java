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
     * @param text a beolvasandó text fájl neve
     * a függvény elvégzi a teszfájl beolvasását
     */
    public static void readFile(String text) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(text));
            String line = br.readLine();

            while (line != null) {
                //a beolvasott parancsra végre hajtja a megfelelő paarancsot
                doWork(line);
                line = br.readLine();
            }
        }
        catch(IOException e) {

        }
    }

    /**
     * @param line a beolvasott parancs
     * @throws IOException a fájlba irás miatt IOExceptiont dobhat
     * a bemeneti nyelv alapján elvégzi a megfelelő inicializálásokat
     */
    public static void doWork(String line) throws IOException {
        String lineArr[] = line.split(" ");
        switch(lineArr[0]) {
            case "load":
                BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt"));
                writer.write("");
                writer.close();
                Maze.init();
                readFile(lineArr[1]);
                int n= Integer. parseInt(lineArr[1].substring(4,lineArr[1].length()-4));
                ProcessBuilder builder = new ProcessBuilder(
                        "cmd.exe", "/c", "fc C:\\Users\\Downloads\\com\\company\\Valami.txt " +
                        "C:\\Users\\Downloads\\com\\company\\Req"+n+".txt");
                builder.redirectErrorStream(true);
                Process p = builder.start();
                break;
            case "put" :
                putAnim(lineArr[1], lineArr[2]);
                break;
            case "step" :
                moveAnim(lineArr[1], lineArr[2]);
                break;
            default:
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

    /**
     * @param animal egy állat (panda vagy orángután)
     * @param tile a tile amelyre az állat kerülni fog
     * @throws IOException a fájlba irás miatt IOExceptiont dobhat
     */
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

    /**
     * @param a1 panda
     * @param a2 orángután vagy panda
     * @throws IOException a fájlba irás miatt IOExceptiont dobhat
     * a1 elkezdi követni a2-t s megtörténnek a megfelelő inicializációk
     */
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

    /**
     * @param a orángután vagy panda
     * @param t egy tile
     * @throws IOException a fájlba irás miatt IOExceptiont dobhat
     * az "a" Stringből név alapján létehozza az Anim állatot, mely a t-ből kiszámitott tilera próbál majd elmozogni
     */
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

    /**
     * @param t a t tileból kiszámitott Tileon lévő item jelzést ad
     * @throws IOException a fájlba irás miatt IOExceptiont dobhat
     */
    static void makeSound(String t) throws IOException {
        int TileNum = Integer.parseInt(t.substring(1));
        Tile tile = Maze.getTile(TileNum-1);
        Item i = tile.getItem();
        i.notifyNeighbours();
    }
    


}
