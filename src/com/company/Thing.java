package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A pályáelemek összességének abszrakt ősosztálya.
 * Nyilvántartja a csempét, amin van.
 */
public abstract class Thing {

    /**
     * Az a Tile, amin aktuálisan van.
     */
    protected Tile position;
    private String name;
    /**
     * @param o
     * @return bool
     * Akkor hívódik meg, amikor egy leszármazottja találkozik egy Orangutan-nal.
     * Leszármazottban felül van írva. Itt csak false-szal tér vissza.
     */
    public boolean collideWith(Orangutan o) throws IOException {
        /*String s = this.getClass().getSimpleName().toUpperCase() + ":collideWith(o)";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        Controller.decTab();*/
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
        writer.append(this.getName()+" refuse "+ o.getName()+"\n");
        writer.close();
        System.out.print(this.getName()+" refuse "+ o.getName()+"\n");
        return false;
    }

    /**
     * @param lp LazyPanda
     * @return
     */


    /**
     * @param p
     * @return bool
     * Akkor hívódik meg, amikor egy leszármazottja találkozik egy Panda-val.
     * Leszármazottban felül van írva. Itt csak false-szal tér vissza.
     */
    public boolean collideWith(Panda p) throws IOException{
        /*String s = this.getClass().getSimpleName().toUpperCase() + ":collideWith(p)";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        Controller.decTab();*/
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
        writer.append(this.getName()+" refuse "+ p.getName()+"\n");
        writer.close();
        System.out.print(this.getName()+" refuse "+ p.getName()+"\n");
        return false;
    }

    /**
     * @return Tile
     * Visszaadja a dolog pozícióját.
     */
    public Tile getPosition(){
        return position;
    }
    public void setPosition(Tile t) {
        position =t;
    }
    public void setName(String s) {name=s;}
    public String getName() {return  name;}


}
