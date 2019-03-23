package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String selectedEvent;

    private static String[] useCase={"Orangutan steps out on Exit",
            "Orangutan steps on WeakTile", "Orangutan steps on broken WeakTile",
            "Orangutan collides with Sofa",
            "Orangutan moves",
            "Orangutan collides with Arcade",
            "Orangutan collides with Orangutan",
            "Orangutan steps in Wardrobe",
            "Orangutan picks up Panda",
            "Orangutan collides with VendingMachine",
            "Panda moves",
            "Panda collides with Panda",
            "ScaredPanda gets scared",
            "LazyPanda sits down",
            "JumpingPanda jumps",
            "Panda steps on WeakTile",
            "Panda steps on broken WeakTile",
            "Panda collides with VendingMachine",
            "Panda collides with Arcade",
            "Panda collides with taken Sofa",
            "Orangutan leads Pandas"};

    public static void main(String[] args) {
        for(int i=0; i<useCase.length; i++){
            System.out.println(i+1 + ". " + useCase[i]);
        }
        System.out.println("Enter the selected number:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            selectedEvent = br.readLine();
        }
        catch(IOException e) {

        }

        System.out.println(selectedEvent);

        switch (selectedEvent) {
            case "1" : Controller.orangutanStepsOutOnExit(); break;
            case "8" : Controller.orangutanStepsInWardrobe(); break;
            case "9" : Controller.orangutanPicksUpPanda(); break;
        }

    }
}
