package com.company;

import javax.swing.*;
import java.io.*;

public class Main {

    private static String selectedEvent;

    public static void main(String[] args) throws IOException {
        boolean exit=false;
        Maze m= new Maze();
        m.init();

        JFrame f=new JFrame();
        JButton b=new JButton("Play");
        b.setBounds(130,100,100, 40);

        f.add(b);

        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
        /*while(!exit) {


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
        }*/

    }
}
