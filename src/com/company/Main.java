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
        boolean exit=false;
        while(!exit) {
            for (int i = 0; i < useCase.length; i++) {
                System.out.println(i + 1 + ". " + useCase[i]);
            }
            System.out.println((useCase.length+1)+". Exit");
            System.out.println("Enter the selected number:");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                selectedEvent = br.readLine();
            } catch (IOException e) {

            }

            System.out.println(selectedEvent);

            switch (selectedEvent) {
                case "10": Controller.orangutanCollidesWithVendingMachine();
                    break;
                case "1":
                    Controller.orangutanStepsOutOnExit();
                    break;
                case "2":
                    Controller.orangutanStepsOnWeakTile();
                    break;
                case "3":
                    Controller.orangutanStepsOnBrokenWeakTile();
                    break;
                case "4":
                    Controller.orangutanCollidesWithSofa();
                    break;
                case "5":
                    Controller.orangutanMoves();
                    break;
                case "6":
                    Controller.orangutanCollidesWithArcade();
                    break;
                case "7":
                    Controller.OrangutanCollidesWithOrangutan();
                    break;
                case "8":
                    Controller.orangutanStepsInWardrobe();
                    break;
                case "9":
                    Controller.orangutanPicksUpPanda();
                    break;
                case "12":
                    Controller.pandaCollidesWithPanda();
                    break;
                case "13":
                    Controller.scaredPandaGetsScared();
                    break;
                case "14":
                    Controller.lazyPandaSitsDown();
                    break;
                case "15":
                    Controller.JumpingPandaJumps();
                    break;
                case "16":
                    Controller.pandaStepsOnWeakTile();
                    break;
                case "17":
                    Controller.pandaStepsOnBrokenWeakTile();
                    break;
                case "18":
                    Controller.pandaCollidesWithVendingMachine();
                    break;
                case "19":
                    Controller.PandaCollidesWithArcade();
                    break;
                case "20":
                    Controller.pandaCollidesWithTakenSofa();
                    break;
                case "11":
                    Controller.PandaMoves();
                    break;
                case "21":
                    Controller.OrangutanLeadsPanda();
                    break;
                case "22":
                    exit=true;
                    break;
            }
        }

    }
}
