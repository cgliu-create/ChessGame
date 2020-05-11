package ChessPieces;

import java.util.ArrayList;

public class Bishop extends ChessPiece{
    private ArrayList<Point> output = new ArrayList<>();
    @Override
    public ArrayList<Point> checkMoves(int y, int x) {
        int yp = y;
        int xp = x;
        output.clear();
        output.add(new Point(yp, xp));
        //UpRight
        yp--; xp++;
        while(isValid(yp, xp) && isClear(y, x, yp, xp)){
            output.add(new Point(yp, xp));
            if (isEnemyFound(y, x, yp, xp)){ break;}
            yp--; xp++;
        }
        yp = y; xp = x;
        //UpLeft
        yp--; xp--;
        while(isValid(yp, xp) && isClear(y, x, yp, xp)){
            output.add(new Point(yp, xp));
            if (isEnemyFound(y, x, yp, xp)){ break;}
            yp--; xp--;
        }
        yp = y; xp = x;
        //DownRight
        yp++; xp++;
        while(isValid(yp, xp) && isClear(y, x, yp, xp)){
            output.add(new Point(yp, xp));
            if (isEnemyFound(y, x, yp, xp)){ break;}
            yp++; xp++;
        }
        yp = y; xp = x;
        //DownLeft
        yp++; xp--;
        while(isValid(yp, xp) && isClear(y, x, yp, xp)){
            output.add(new Point(yp, xp));
            if (isEnemyFound(y, x, yp, xp)){ break;}
            yp++; xp--;
        }
        return output;
    }
}
