package com.company;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Azt a csempét szimbolizálja, amin keresztül el lehet hagyni a pályát. Felelőssége a
 * bejárati csempe nyilvántartása, és a pontszám növelése.
 */
public class Exit extends Tile {

    /**
     * A kijárat nyilvántartja, hol kell beléptetni a kilépő orángutánt.
     */
    private Tile entry;

    /**
     * @param o a kijáratra lépő állat
     * Növeli a pontszámot, törli a pandákat, és átrakja az
     * orángutánt a bejárati csempére.
     */
    void accept(Orangutan o) throws IOException {

        exitAll(o.nextPanda);

        System.out.println("diumdisum");

        int pandaNum = o.getPandaNum(o.getNextPanda());
        Game.addPoints(pandaNum);
        o.setPosition(this);
        o.move(entry);
        if(o.getNextPanda()!=null) {
            o.destroyPandas();
        }

    }

    void exitAll(Panda p) throws IOException{
        if(p!=null)
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.txt", true));
            writer.append(p.getName()+" ");
            Maze.removePanda(p);
           // exitAll(p.nextPanda);
           // Maze.removeOnePanda(p);
            writer.close();
        }
        else
            return;
    }

    boolean canIMove(Orangutan o) {return true;}

    void setEntry(Tile t) {
        entry = t;
    }

    public void setUpTileView(int x, int y) {
        view = new TileView(x,y, Color.red);
    }
}
