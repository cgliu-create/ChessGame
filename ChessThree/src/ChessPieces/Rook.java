package ChessPieces;

import java.util.ArrayList;

public class Rook extends ChessPiece{
    private ArrayList<Point> output = new ArrayList<>();
    @Override
    public ArrayList<Point> checkMoves(int y, int x) {
        int yp = y;
        int xp = x;
        output.clear();
        output.add(new Point(yp, xp));
        //Up
        yp--;
        while(isValid(yp, xp) && isClear(y, x, yp, xp)){
            output.add(new Point(yp, xp));
            if (isEnemyFound(y, x, yp, xp)){ break;}
            yp--;
        }
        yp = y; xp = x;
        //Left
        xp--;
        while(isValid(yp, xp) && isClear(y, x, yp, xp)){
            output.add(new Point(yp, xp));
            if (isEnemyFound(y, x, yp, xp)){ break;}
            xp--;
        }
        yp = y; xp = x;
        //Right
        xp++;
        while(isValid(yp, xp) && isClear(y, x, yp, xp)){
            output.add(new Point(yp, xp));
            if (isEnemyFound(y, x, yp, xp)){ break;}
            xp++;
        }
        yp = y; xp = x;
        //Down
        yp++;
        while(isValid(yp, xp) && isClear(y, x, yp, xp)){
            output.add(new Point(yp, xp));
            if (isEnemyFound(y, x, yp, xp)){ break;}
            yp++;
        }
        return output;
    }

}
