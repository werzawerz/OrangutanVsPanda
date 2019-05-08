package com.company;

import javax.naming.ldap.Control;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Olyan csempe, ami egy bizonyos rálépés után eltörik. Nyilvántartja, hogy mennyi
 * rálépés van vissza a törésig.
 */
public class WeakTile extends Tile {

    /**
     * A fenmaradó rálépés a törésig.
     */
    private int strength=20;

    /**
     * @param o : a WeakTilera lépni akaró orángután
     * Magára rakja az Orángutántt, ha “élete” 0, akkor pedig
     * törli azt.
     */
    @Override
    void accept(Orangutan o) throws IOException {

        o.setPosition(this);
        decreaseStrength(1);
        if(strength>0) {
            this.occupiedBy = o;
            o.setPosition(this);
        }
        else {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
            writer.append(o.getName()+" dead\n");
            System.out.print(o.getName()+" dead\n");
            writer.close();
            remove(o);
            Maze.removeOrangutan(o);
        }

    }

    /**
     * @param p a WeakTilera lépni akaró panda
     * Magára rakja az Pandat, ha “élete” 0, akkor pedig törli azt.
     */
    @Override
    void accept(Panda p) throws IOException {

        decreaseStrength(1);
        if(strength>0) {
            this.occupiedBy = p;
            p.setPosition(this);
        }
        else {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
            writer.append(p.getName()+" dead\n");
            System.out.print(p.getName()+" dead\n");
            writer.close();
            remove(p);
            Maze.removeOnePanda(p);
        }
    }

    /**
     * @param i
     * Csökkenti a strength attributum értékét i-vel
     */
    void decreaseStrength(int i) throws IOException {
        if(strength<1) return;
        if(i>0 && i<10000) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
            writer.append(getName() + "-" + i + "\n");
            System.out.print(getName() + "-" + i + "\n");
            writer.close();
        }
        strength -= i;
    }

    public void setStrength(int i) {
        strength = i;
    }
}
