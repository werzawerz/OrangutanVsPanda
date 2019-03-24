package com.company;

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
    void accept(Orangutan o) {
        Controller.incTab();
        Controller.writeClassAndFunction("EXIT:accept(o)");
        int pandaNum = o.getPandaNum();
        Game.addPoints(pandaNum);
        o.setPosition(this);
        o.move(entry);
        if(o.getNextPanda()!=null) {
            o.destroyPandas();
        }
        Controller.decTab();
    }

    void setEntry(Tile t) {
        entry = t;
    }
}
