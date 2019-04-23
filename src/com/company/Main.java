package com.company;

import java.io.*;

public class Main {

    private static String selectedEvent;

    public static void main(String[] args) throws IOException {
        boolean exit=false;
        Maze m= new Maze();
        m.init();

        while(!exit) {


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                selectedEvent = br.readLine();
            } catch (IOException e) { }
            if(selectedEvent.equals("exit")) {
                exit=true;
            }
            else if(selectedEvent.equals("reset")){
                m.init();
            }
            else {
                Controller.doWork(selectedEvent);
            }
        }

    }
}
