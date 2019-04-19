package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Az absztarkt osztály, amiből a különféle pandák származnak.
 */
public abstract class Panda extends Animal {
    /**
     * Nyilvántartja, hogy a panda követ-e épp egy orángutánt.
     */
    private boolean follow;
    /**
     * Az Animal, amit a Panda követ.
     */
    private Animal followingA;

    /**
     * @param o Orangutan
     * @return bool
     * Panda Orangutan-nal ütközik, a panda
     * bekerül a sorba, false-t ad vissza.
     */
    public boolean collideWith(Orangutan o) throws IOException {
        String s = this.getClass().getSimpleName().toUpperCase() + ":collideWith(o)";
        Controller.incTab();
        Controller.writeClassAndFunction(s);

        setFollow(true);
        setFollowingA(o);
        o.setNextPanda(this);
        Controller.decTab();
        return false;
    }

    public void move(Tile t) throws IOException {
        String s = this.getClass().getSimpleName().toUpperCase() + ":move(t)";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        if(t.canIMove(this)) {

            BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.out", true));
            writer.append(this.getName()+" "+this.position.getName()+"->"+t.getName()+"\n");
            writer.close();
            getPosition().remove(this);
            if(nextPanda!=null)
            {
                nextPanda.move(position);
            }
            t.accept(this);
        }
        Controller.decTab();
    }

    /**
     * @param p Panda
     * @return bool
     * Panda Panda-val ütközik, mindenki a helyén
     * marad, false-t ad vissza.
     */
    public boolean collideWith(Panda p){
        return false;
    }

    /**
     * @param b bool
     * Beállítja a follow flaget.
     */
    void setFollow(boolean b){
        String s = this.getClass().getSimpleName().toUpperCase() + ":setFollow(b)";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        Controller.decTab();

    }

    /**
     * Rekurzív, a sor felbontását végzi el.
     */
    void release() throws IOException {
        String s = this.getClass().getSimpleName().toUpperCase() + ":release()";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.out", true));
        writer.append(this.getName()+" leaves "+this.followingA.getName() +"\n");
        writer.close();
        if(getNextPanda()!=null)
            getNextPanda().setNextPanda(null);
        Controller.decTab();
    }

    void setFollowingA(Animal a) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valami.out", true));
        writer.append(this.getName()+" follow"+a.getName()+"\n");
        writer.close();
        String s = this.getClass().getSimpleName().toUpperCase() + ":setFollowingA(a)";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
        Controller.decTab();

        followingA = a;
    }



}
