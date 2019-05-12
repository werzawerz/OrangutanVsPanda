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
        int pandaNum = o.getPandaNum(o.getNextPanda());
        Game.addPoints(pandaNum);
        o.setPosition(this);
        o.move(entry);
        if(o.getNextPanda()!=null) {
            o.destroyPandas();
        }

    }

    /**
     * @param p p pandát eltünteti a maze pandas tömbjéből
     * @throws IOException
     */
    void exitAll(Panda p) throws IOException{
        if(p!=null)
        {

            Maze.removePanda(p);

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
