package ChessPieces;

import java.util.ArrayList;

public abstract class ChessPiece {
    //Uses Game Data
    private String[][] data;
    public void setData(String[][] input){
        data = input;
    }
    public String[][] getData(){
        return data;
    }
    //Returns a list of possible moves
    public abstract ArrayList<Point> checkMoves(int y, int x);
    //Enter position
    //Returns if in bounds
    public boolean isValid(int y, int x){
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }
    //Enter position and target
    //Returns if target is not a friendly piece
    public boolean isClear(int ya, int xa, int yb, int xb){
        String piece = getData()[ya][xa];
        String target = getData()[yb][xb];
        return piece.charAt(0) != target.charAt(0);
    }
    //Enter position and target
    //Returns if target is an enemy piece
    public boolean isEnemyFound(int ya, int xa, int yb, int xb){
        String piece = getData()[ya][xa];
        String target = getData()[yb][xb];
        if(piece.charAt(0)=='W'){
            if(target.charAt(0)=='B'){ return true;}
        }
        if(piece.charAt(0)=='B'){
            if(target.charAt(0)=='W'){ return true;}
        }
        return false;
    }
}
