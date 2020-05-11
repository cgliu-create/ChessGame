package ChessGame;

import javax.swing.*;
import java.io.IOException;

public class Game {
    //Uses GameData and Gui
    private GameData gameData;
    private Gui gui;
    //Constructor
    public Game() throws IOException {
        gameData = new GameData();
        gui = new Gui(gameData);
        run();
    }
    public void run(){
        boolean playing = true;
        while (playing){
            boolean WKisAlive = checkKing("WK");
            boolean BKisAlive = checkKing("BK");
            if(!WKisAlive ||!BKisAlive){
                playagain();
            }
        }
    }
    //Enter which king to look for
    //Returns if king is in game data or on board
    public boolean checkKing(String king){
        for (String[] data: gameData.getData()) {
            for (String spot: data) {
                if(spot.equals(king)){
                    return true;
                }
            }
        }
        return false;
    }
    //Creates a GameOver prompts to the user
    //Resets the game/data to default
    public void playagain() {
        JFrame end = new JFrame();
        JOptionPane.showMessageDialog(end, "Game Over");
        String again = JOptionPane.showInputDialog(end, "Would you like to play again");
        if(again.equalsIgnoreCase("yes")||again.equalsIgnoreCase("y")){
            // game reset
            gameData.resetData();
            try {
                gui.Update();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {
        Game run = new Game();
    }
}
