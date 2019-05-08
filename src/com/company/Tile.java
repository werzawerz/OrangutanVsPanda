package com.company;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A pályát alkotó csempéket modellező osztály. Nyilván tartja a szomszédos
 * csempéket, illetve a rajta lévő állatot, vagy egyéb pályaelemet.
 */
public class Tile {

    private String name;

    protected TileView view;

    /**
     * A szomszédos csempéket tartalmazó tömb.
     */
    private ArrayList<Tile> neighbours = new ArrayList<Tile>();
    /**
     * A csempén tartózkodó Animal.
     */
    protected Animal occupiedBy;
    /**
     * A csempén lévő pályaelem.
     */
    private Item item;


    /**
     * @param o Orangutan: a Tile-ra lépni akaró Orangutan
     * @return bool
     * A megfelelő collideWith metódusokkal megnézi,
     * hogy Animal a léphet-e rá, ennek megfelelő a visszatérési érték.
     */
    boolean canIMove(Orangutan o) throws IOException {

        boolean bul = true;
        if(occupiedBy!=null) {
            bul = occupiedBy.collideWith(o);
            if (!bul) {
                return false;
            }
        }
        if(item!=null)
            bul = item.collideWith(o);
        //Controller.decTab();
        return bul;
    }

    /**
     * @param p ?????????????????????????????????????
     * @return ?????????????????????????? Kérdéses cucc
     */
    boolean canIMove(Panda p) throws IOException{

        boolean bul = true;
        if(occupiedBy!=null) {
            bul = occupiedBy.collideWith(p);
            if (!bul) {
                return false;
            }
        }

        if(item!=null) {
           bul = item.collideWith(p);
        }


        return bul;
    }

    /**
     * @param o Orangutan
     * Az o-t rálépteti magára.
     */
    void accept(Orangutan o) throws IOException {
        /*String s = this.getClass().getSimpleName().toUpperCase() +  ":accept(o)";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        Controller.decTab();*/
        occupiedBy = o;
        /*
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.out", true));
        writer.append(o.getName()+" "+o.position.getName()+"->"+this.getName()+"\n");
        writer.close();
        System.out.print(o.getName()+" "+o.position.getName()+"->"+this.getName()+"\n");
        */
        o.setPosition(this);
    }

    /**
     * @param p Panda
     * A p-t rálépteti magára.
     */
    void accept(Panda p) throws IOException {
        /*String s = this.getClass().getSimpleName().toUpperCase() +  ":accept(p)";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        Controller.decTab();*/
        occupiedBy = p;
        /*
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.out", true));
        writer.append(p.getName()+" "+p.position.getName()+"->"+this.getName()+"\n");
        writer.close();
        System.out.print(p.getName()+" "+p.position.getName()+"->"+this.getName()+"\n");
        */
        p.setPosition(this);
    }

    /**
     * @param a Animal
     * Az a-t leveszi magáról.
     */
    void remove(Animal a)
    {
        /*String s = this.getClass().getSimpleName().toUpperCase() + ":remove(a)";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        Controller.decTab();**/
        occupiedBy = null;


    }

    /**
     * Üres függvény, a WeakTile-nál van
     * törzse.
     */
    void decreaseStrength(int i) throws IOException {}

    /**
     * @return Tile[]
     * Visszaadja a szomszédos csempéket tartalmazó
     * tömböt.
     */
    ArrayList<Tile> getNeighbours(){
        /*String s = this.getClass().getSimpleName().toUpperCase() + ":getNeighbours()";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        Controller.decTab();*/
        return neighbours;
    }

    /**
     * @return Animal
     * Visszaadja a a Tile-on levő Animal-t.
     */
     Animal getAnimal(){
        /* String s = this.getClass().getSimpleName().toUpperCase() + ":getAnimal()";
         Controller.incTab();
         Controller.writeClassAndFunction(s);
         Controller.decTab();*/
        return occupiedBy;
    }

    Item getItem() {
         return item;
    }



    /**
     * @param t t-t hozzáadja a szomszédos tileok közé
     */
    void setNeighbours(Tile[] t) {

        for(int i=0; i<t.length; i++){
            neighbours.add(t[i]);
        }
    }

    public void setItem(Item i) {
        item = i;
    }

    public void setAnimal(Animal occupiedBy) {
        this.occupiedBy = occupiedBy;
    }

    public int getNeighbourSize(){
        return neighbours.size();
    }

    void setEntry(Tile t) {}
    public void setNeighbourWardrobe(Tile neighbourWardrobe) {}

    public String getName() {return  name;}
    public void setName(String s) {name=s;}
    public TileView getView(){return view;}

    public void setUpTileView(int x, int y) {
        view = new TileView(x,y, Color.green);
    }
}
