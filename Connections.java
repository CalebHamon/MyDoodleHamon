import doodlepad.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Connections {
    public static ArrayList<YellowBlock> yellBlock = new ArrayList<YellowBlock>();
    public static ArrayList<BlueBlock> blueBlock = new ArrayList<BlueBlock>();
    public static ArrayList<GreenBlock> greeBlock = new ArrayList<GreenBlock>();
    public static ArrayList<PurpleBlock> purpBlock = new ArrayList<PurpleBlock>();
    public static ArrayList<Integer> avail = new ArrayList<Integer>();
    public static ArrayList<String> selected = new ArrayList<String>();
    private static RoundRect[][] buttons; // Array to store button shapes
    private RoundRect finishBtn;
    private Image im;
    private static boolean isOn; // Button state
    private static int gamePlayed = (int) (Math.random() * 18);
    private static int timesGuessed = 0;

    public Connections() {
        im = new Image("gamein.png", 500, 500);
        
        buttons = new RoundRect[4][4]; // Create a 4x4 array of buttons
        finishBtn = new RoundRect(200, 400, 75, 50, 20, 20);
        finishBtn.setFillColor(200);
        finishBtn.setText("Submit");
        finishBtn.setMouseClickedHandler((shp, x, y, button) -> onPressedFinish());

        // Initialize buttons and set event handlers
        for (int i = 0; i < buttons.length; i++) {
            int p = i;
            for (int j = 0; j < buttons[i].length; j++) {
                int q = j;
                buttons[i][j] = new RoundRect(100 + j * 75, 100 + i * 50, 75, 50, 20, 20);
                buttons[i][j].setFillColor(200);
                buttons[i][j].setText(fillText());
                buttons[i][j].setMousePressedHandler((shp, x, y, button) -> onPressed(p, q));
            }
        }

        // Starts off
        isOn = false;
    }

    private static void onPressedFinish() {
        // check the arraylist
        isOn = !isOn;

        // Set button fill color based on state
        if (isOn) {
            if(timesGuessed == 4){
                for (int i = 0; i < buttons.length; i++) {
                    for (int j = 0; j < buttons[i].length; j++) {
                        buttons[i][j].setFillColor(200);
                        buttons[i][j].setText("Game Over");
                    }
                }
            }
            if (yellBlock.get(gamePlayed).matching(selected.get(0), selected.get(1), selected.get(2), selected.get(3))) {
                remFinish(0);
            }
            else if (blueBlock.get(gamePlayed).matching(selected.get(0), selected.get(1), selected.get(2), selected.get(3))) {
                remFinish(1);
            }
            else if (greeBlock.get(gamePlayed).matching(selected.get(0), selected.get(1), selected.get(2), selected.get(3))) {
                remFinish(2);
            }
            else if (purpBlock.get(gamePlayed).matching(selected.get(0), selected.get(1), selected.get(2), selected.get(3))) {
                remFinish(3);
            }
            isOn = !isOn;
            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[i].length; j++) {
                    buttons[i][j].setFillColor(200);
                }
            }
            timesGuessed++;
        } else {
        }
    }

    private static void remFinish(int key) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (key == 0) {
                    if (yellBlock.get(gamePlayed).retYe1().equals(buttons[i][j].getText()) || yellBlock.get(gamePlayed).retYe2().equals(buttons[i][j].getText()) || yellBlock.get(gamePlayed).retYe3().equals(buttons[i][j].getText()) || yellBlock.get(gamePlayed).retYe4().equals(buttons[i][j].getText())) {
                        buttons[i][j].setText(yellBlock.get(gamePlayed).retTop());
                        buttons[i][j].setFontSize(5);
                    }
                }
                else if(key == 1){
                    if (blueBlock.get(gamePlayed).retYe1().equals(buttons[i][j].getText()) || blueBlock.get(gamePlayed).retYe2().equals(buttons[i][j].getText()) || blueBlock.get(gamePlayed).retYe3().equals(buttons[i][j].getText()) || blueBlock.get(gamePlayed).retYe4().equals(buttons[i][j].getText())) {
                        buttons[i][j].setText(blueBlock.get(gamePlayed).retTop());
                        buttons[i][j].setFontSize(5);
                    }
                }
                else if(key == 2){
                    if (greeBlock.get(gamePlayed).retYe1().equals(buttons[i][j].getText()) || greeBlock.get(gamePlayed).retYe2().equals(buttons[i][j].getText()) || greeBlock.get(gamePlayed).retYe3().equals(buttons[i][j].getText()) || greeBlock.get(gamePlayed).retYe4().equals(buttons[i][j].getText())) {
                        buttons[i][j].setText(greeBlock.get(gamePlayed).retTop());
                        buttons[i][j].setFontSize(5);
                    }
                }
                else if(key == 3){
                    if (purpBlock.get(gamePlayed).retYe1().equals(buttons[i][j].getText()) || purpBlock.get(gamePlayed).retYe2().equals(buttons[i][j].getText()) || purpBlock.get(gamePlayed).retYe3().equals(buttons[i][j].getText()) || purpBlock.get(gamePlayed).retYe4().equals(buttons[i][j].getText())) {
                        buttons[i][j].setText(purpBlock.get(gamePlayed).retTop());
                        buttons[i][j].setFontSize(5);
                    }
                }
            }
        }
        selected.clear();
    }

    private String fillText() {
        int possible = avail.size();
        int getrandNum = (int) (Math.random() * possible);
        int retrievePos = avail.get(getrandNum);
        if (retrievePos == 1) {
            avail.remove(getrandNum);
            return yellBlock.get(gamePlayed).retYe1();
        } else if (retrievePos == 2) {
            avail.remove(getrandNum);
            return yellBlock.get(gamePlayed).retYe2();
        } else if (retrievePos == 3) {
            avail.remove(getrandNum);
            return yellBlock.get(gamePlayed).retYe3();
        } else if (retrievePos == 4) {
            avail.remove(getrandNum);
            return yellBlock.get(gamePlayed).retYe4(); // yelDone
        } else if (retrievePos == 5) {
            avail.remove(getrandNum);
            return greeBlock.get(gamePlayed).retYe1();
        } else if (retrievePos == 6) {
            avail.remove(getrandNum);
            return greeBlock.get(gamePlayed).retYe2();
        } else if (retrievePos == 7) {
            avail.remove(getrandNum);
            return greeBlock.get(gamePlayed).retYe3();
        } else if (retrievePos == 8) {
            avail.remove(getrandNum);
            return greeBlock.get(gamePlayed).retYe4(); // greDone
        } else if (retrievePos == 9) {
            avail.remove(getrandNum);
            return blueBlock.get(gamePlayed).retYe1();
        } else if (retrievePos == 10) {
            avail.remove(getrandNum);
            return blueBlock.get(gamePlayed).retYe2();
        } else if (retrievePos == 11) {
            avail.remove(getrandNum);
            return blueBlock.get(gamePlayed).retYe3();
        } else if (retrievePos == 12) {
            avail.remove(getrandNum);
            return blueBlock.get(gamePlayed).retYe4(); // bluDone
        } else if (retrievePos == 13) {
            avail.remove(getrandNum);
            return purpBlock.get(gamePlayed).retYe1();
        } else if (retrievePos == 14) {
            avail.remove(getrandNum);
            return purpBlock.get(gamePlayed).retYe2();
        } else if (retrievePos == 15) {
            avail.remove(getrandNum);
            return purpBlock.get(gamePlayed).retYe3();
        } else {
            avail.remove(getrandNum);
            return purpBlock.get(gamePlayed).retYe4(); // purDone
        }
    }

    private void onPressed(int row, int col) {
        // Toggle button state
        isOn = !isOn;

        // Set button fill color based on state
        if (isOn) {
            buttons[row][col].setFillColor(0, 255, 0);
            selected.add(buttons[row][col].getText());
        } else {
            buttons[row][col].setFillColor(200);
            findIndex(buttons[row][col].getText());
        }
    }

    public void findIndex(String p) {
        for (int i = 0; i < selected.size(); i++) {
            if (selected.get(i).equals(p)) {
                selected.remove(i);
            }
        }
    }

    public static void addGames() {
        for (int i = 1; i <= 16; i++) {
            avail.add(i);
        }
        try {
            File yellowGames = new File("yellowAns.txt");
            Scanner yellowGamesReader = new Scanner(yellowGames);
            File blueGames = new File("blueAns.txt");
            Scanner blueGamesReader = new Scanner(blueGames);
            File greenGames = new File("greenAns.txt");
            Scanner greenGamesReader = new Scanner(greenGames);
            File purpleGames = new File("purpleAns.txt");
            Scanner purpleGamesReader = new Scanner(purpleGames);
            while (yellowGamesReader.hasNextLine()) {
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
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        addGames();
        // Create an instance of ConnectionsGame
        Connections game = new Connections();
    }
}
