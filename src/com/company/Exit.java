package com.company;

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
        Controller.incTab();
        Controller.writeClassAndFunction("EXIT:accept(o)");
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.out", true));
        writer.append(o.getName()+" exits");
        if(o.nextPanda!=null)
        {
            Panda pa=o.nextPanda;
            writer.append(pa.getName()+" ");
            while(pa.nextPanda!=null)
            {
                pa=pa.nextPanda;
                writer.append(pa.getName()+" ");
            }
        }
        writer.append("\n");
        writer.close();
        int pandaNum = o.getPandaNum(o.getNextPanda());
        Game.addPoints(pandaNum);
        o.setPosition(this);
        o.move(entry);
        if(o.getNextPanda()!=null) {
            o.destroyPandas();
        }
        Controller.decTab();
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("Valami.out", true));
        writer.append("\n");
        writer2.close();
    }

    void setEntry(Tile t) {
        entry = t;
    }
}
