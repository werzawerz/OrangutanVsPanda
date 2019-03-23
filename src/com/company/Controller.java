package com.company;

public class Controller {

    static private int tab = -1;

    static public void incTab() {
        tab++;
    }

    static public void decTab() {
        tab--;
    }

    static public void writeClassAndFunction(String s) {
        for(int i = 0; i<tab; i++) {
            System.out.print("\t");
        }
        System.out.println(s);
    }
    
}
