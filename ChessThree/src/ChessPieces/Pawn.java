package ChessPieces;

import java.util.ArrayList;

public class Pawn extends ChessPiece{
    private ArrayList<Point> output = new ArrayList<>();
    public boolean isEnemyAcross(int ya, int xa, int yb, int xb){
        String piece = getData()[ya][xa];
        String target = getData()[yb][xb];
        return piece.charAt(0) != target.charAt(0) && target.charAt(0) != 'X';
    }
    @Override
    public ArrayList<Point> checkMoves(int y, int x) {
        int yp = y;
        int xp = x;
        output.clear();
        output.add(new Point(yp, xp));
        String piece = getData()[y][x];
        if(piece.charAt(0)=='W'){
            yp--;
        }
        if(piece.charAt(0)=='B'){
            yp++;
        }
        if (xp-1>=0){
            if(isEnemyAcross(y,x,yp,xp-1)){
                output.add(new Point(yp, xp-1));
            }
        }
        if(xp+1<=7){
            if(isEnemyAcross(y,x,yp,xp+1)){
                output.add(new Point(yp, xp+1));
            }
        }
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            String target = getData()[yp][xp];
            if(target.charAt(0)=='X')
            output.add(new Point(yp, xp));
        }
        if(y==6){
            yp--;
            if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
                String target = getData()[yp][xp];
                if(target.charAt(0)=='X')
                    output.add(new Point(yp, xp));
            }
        }
        if(y==1){
            yp++;
            if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
                String target = getData()[yp][xp];
                if(target.charAt(0)=='X')
                    output.add(new Point(yp, xp));
            }
        }
        return output;
    }
}
