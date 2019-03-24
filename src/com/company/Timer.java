package com.company;


/**
 * Az idozitésért felelős osztály
 */
public class Timer {

    static public void tick() {
        String s = "TIMER:tick()";
        Controller.incTab();
        Controller.writeClassAndFunction(s);
    }
}
