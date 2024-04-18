import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Connections {
    
    public Connections(){
        
        public static ArrayList<YellowBlock> yellBlock = new ArrayList<YellowBlock>();
        public static ArrayList<BlueBlock> blueBlock = new ArrayList<BlueBlock>();
        public static ArrayList<GreenBlock> greeBlock = new ArrayList<GreenBlock>();
        public static ArrayList<PurpleBlock> purpBlock = new ArrayList<PurpleBlock>();

        public static void main(String[] args){
            addGames();

        }

        public static void addGames() {
            try{
                File yellowGames = new File(yellowAns.txt);
                Scanner yellowGamesReader = new Scanner(yellowGames);
                File blueGames = new File(blueAns.txt);
                Scanner blueGamesReader = new Scanner(blueGames);
                File greenGames = new File(greenAns.txt);
                Scanner greenGamesReader = new Scanner(greenGames);
                File purpleGames = new File(purpleAns.txt);
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
}
