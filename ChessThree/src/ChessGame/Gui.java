package ChessGame;

import ChessPieces.Point;
import Images.ImageGetter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Gui extends JFrame {
    //Gui is a composition of a JFrame, JButtons, and Images
    //Gui uses Player and GameData
    private ImageGetter imageGetter = new ImageGetter();
    private JButton[][] jButtons = new JButton[8][8];
    private Player player = new Player();
    private GameData gameData;
    //Dimensions
    private int frameWidth = 800;
    private int frameHeight = 800;
    private int w = frameWidth/8 - 6;
    private int h = frameHeight/8 - 6;
    //Constructor
    public Gui(GameData gameData) throws IOException {
        super("Chess");
        this.gameData = gameData;
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(8, 8));
        for (int y = 0; y <  jButtons.length; y++) {
            for (int x = 0; x <  jButtons[y].length; x++) {
                jButtons[y][x] = new JButton();
            }
        }
        addButtons(gameData);
    }
    //update buttons
    public void UpdateButtons() throws IOException {
        for (int y = 0; y < jButtons.length; y++) {
            for (int x = 0; x < jButtons[y].length; x++) {
                jButtons[y][x].setSize(w, h);
                jButtons[y][x].setIcon(new ImageIcon(imageGetter.getImage(gameData,y,x,w,h)));
            }
        }
    }
    //updates frame
    public void Update() throws IOException {
        int width = this.getSize().width;
        int height = this.getSize().height;
        if (frameWidth != w || frameHeight != h) {
            frameWidth = width;
            frameHeight = height;
            w = width / 8 - 6;
            h = height / 8 - 6;
            UpdateButtons();
            revalidate();
        }
    }
    public void markPossibleMoves(int y, int x){
        ArrayList<Point> moves = player.checkMoves(gameData,y,x);
        for (Point move: moves) {
            jButtons[move.getY()][move.getX()].setBackground(Color.red);
        }
    }
    public void removeMoveMarks(){
        for (JButton[] jButton : jButtons) {
            for (JButton button : jButton) {
                button.setBackground(Color.black);
            }
        }
    }
    //Enter Game Data
    //Creates Buttons with Icons based off data
    public void addButtons(GameData gameData) throws IOException {
        for (int y = 0; y <  jButtons.length; y++) {
            for (int x = 0; x <  jButtons[y].length; x++) {
                jButtons[y][x].setSize(w,h);
                jButtons[y][x].setBackground(Color.black);
                jButtons[y][x].setOpaque(true);
                jButtons[y][x].setIcon(new ImageIcon(imageGetter.getImage(gameData,y,x,w,h)));
                int finalY = y;
                int finalX = x;
                jButtons[y][x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        markPossibleMoves(finalY, finalX);
                        if(player.selectPiece(gameData, finalY, finalX)){
                            removeMoveMarks();
                        }
                        try {
                            Update();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                this.getContentPane().add(jButtons[y][x]);
                revalidate();
            }
        }
    }
    //Returns the GameData manipulated by the gui
    //Gives access to the game data
    public GameData getGameData(){
        return gameData;
    }
}
