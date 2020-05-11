package ChessGame;

import ChessPieces.*;

import java.util.ArrayList;

public class Rules {
    //Composition of the rules of each chess piece
    private King king = new King();
    private Queen queen = new Queen();
    private Bishop bishop = new Bishop();
    private Knight knight = new Knight();
    private Rook rook = new Rook();
    private Pawn pawn = new Pawn();
    //Enter Game Data and the position of interest
    //Returns the possible moves specific to that piece
    public ArrayList<Point> checkMoves(GameData gameData, int y, int x) {
        ArrayList<Point> output = new ArrayList<>();
        char test = gameData.getData()[y][x].charAt(1);
        if(test=='K'){
            king.setData(gameData.getData());
            output = king.checkMoves(y,x);
        }
        if(test=='Q'){
            queen.setData(gameData.getData());
            output = queen.checkMoves(y,x);
        }
        if(test=='B'){
            bishop.setData(gameData.getData());
            output =  bishop.checkMoves(y,x);
        }
        if(test=='N'){
            knight.setData(gameData.getData());
            output =  knight.checkMoves(y,x);
        }
        if(test=='R'){
            rook.setData(gameData.getData());
            output =  rook.checkMoves(y,x);
        }
        if(test=='P'){
            pawn.setData(gameData.getData());
            output =  pawn.checkMoves(y,x);
        }
        output.add(new Point(y, x));
        return output;
    }
    //Enter Game Data and the position of interest
    //Returns the possible moves specific to that piece
    public boolean isValidMove(GameData gameData, int ya, int xa, int yb, int xb) {
        ArrayList<Point> test = checkMoves(gameData, ya, xa);
        Point target = new Point(yb,xb);
        Point piece = new Point(ya,xa);
        for (Point position: test) {
            if(position.equals(target) && !piece.equals(target)){
                return true;
            }
        }
        return false;
    }
}
