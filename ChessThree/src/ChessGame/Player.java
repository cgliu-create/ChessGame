package ChessGame;

import ChessAI.SimpleAI;
import ChessPieces.Point;
import java.util.ArrayList;

public class Player {
    //Player uses rules and SimpleAI
    private Rules rules = new Rules();
    //original position
    private int xa = -1;
    private int ya = -1;
    //target position
    private int xb = -1;
    private int yb = -1;
    //Manages the record of position selections
    public void reset(){ xa = ya = xb = yb = -1; }
    public boolean pieceSelected(){
        return xa != -1 && ya != -1;
    }
    public boolean targetSelected(){
        return xb != -1 && yb != -1;
    }
    //Enter GameData
    //Records a position selection
    //Changes data when two positions have been selected
    public boolean selectPiece(GameData gameData, int y, int x){
        if(pieceSelected()){ yb = y; xb = x;}
        if(!pieceSelected() && !gameData.getData()[y][x].equals("XX")){ ya = y; xa = x;}
        if(targetSelected()){
            if(rules.isValidMove(gameData,ya, xa, yb, xb)){
                gameData.changeData(ya, xa, yb, xb);
                //Enemy AI reacts after player makes a move
                SimpleAI simpleAI = new SimpleAI(gameData);
                simpleAI.makeMove();
            }
            reset();
            return true;
        }
        return false;
    }
    //Enter Game Data
    //Gives access to rules method through player
    public ArrayList<Point> checkMoves(GameData gameData, int y, int x) {
        return rules.checkMoves(gameData,y,x);
    }
}
