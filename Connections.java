import doodlepad.*;
import doodlepad.Shape.ShapeMouseEventHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Connections {
        
        public static ArrayList<YellowBlock> yellBlock = new ArrayList<YellowBlock>();
        public static ArrayList<BlueBlock> blueBlock = new ArrayList<BlueBlock>();
        public static ArrayList<GreenBlock> greeBlock = new ArrayList<GreenBlock>();
        public static ArrayList<PurpleBlock> purpBlock = new ArrayList<PurpleBlock>();
        private static RoundRect shpButton11;    // Button Shape
        private static boolean isOn;           // Button state
        
        public static void main(String[] args){
            //addGames();
            Screen myPushButton = new Screen();
        }

        public static void addGames() {
            try{
                File yellowGames = new File("yellowAns.txt");
                Scanner yellowGamesReader = new Scanner(yellowGames);
                File blueGames = new File("blueAns.txt");
                Scanner blueGamesReader = new Scanner(blueGames);
                File greenGames = new File("greenAns.txt");
                Scanner greenGamesReader = new Scanner(greenGames);
                File purpleGames = new File("purpleAns.txt");
                Scanner purpleGamesReader = new Scanner(purpleGames);
                while (yellowGamesReader.hasNextLine()){
                    String yellowRaw = yellowGamesReader.nextLine();
                    String blueRaw = blueGamesReader.nextLine();
                    String greenRaw = greenGamesReader.nextLine();
                    String purpleRaw = purpleGamesReader.nextLine();
                    String[] yellowInd = yellowRaw.split(",");
                    String[] blueInd = blueRaw.split(",");
                    String[] greenInd = greenRaw.split(",");
                    String[] purpleInd = purpleRaw.split(",");
                    YellowBlock y1 = new YellowBlock(yellowInd[0], yellowInd[1], yellowInd[2], yellowInd[3], yellowInd[4]);
                    BlueBlock b1 = new BlueBlock(blueInd[0], blueInd[1], blueInd[2], blueInd[3], blueInd[4]);
                    GreenBlock g1 = new GreenBlock(greenInd[0], greenInd[1], greenInd[2], greenInd[3], greenInd[4]);
                    PurpleBlock p1 = new PurpleBlock(purpleInd[0], purpleInd[1], purpleInd[2], purpleInd[3], purpleInd[4]);
                    yellBlock.add(y1);
                    blueBlock.add(b1);
                    greeBlock.add(g1);
                    purpBlock.add(p1);
                }
            } catch (FileNotFoundException e){
                System.out.println("An error occured.");
                e.printStackTrace();
            }
        }
        
        public static void makeScreen(){
            // Create button shape and initialize
        shpButton11 = new RoundRect(100, 100, 75, 50, 20, 20);
        shpButton11.setFillColor(255,255,222,255);

        // Starts off
        isOn = false;

        // Set button click event handler method
        shpButton11.setMouseClickedHandler(onPressedWord(11));
        }

        private static ShapeMouseEventHandler onPressedWord(int butNum) {
            // Toggle button state
            isOn = !isOn;
    
            // Set button fill color based on state
            if (isOn) {
                shpButton11.setFillColor(0, 255, 0);
            } else {
                shpButton11.setFillColor(200);
            }
            return null;
        }
}
