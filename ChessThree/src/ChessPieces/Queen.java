package ChessPieces;

import java.util.ArrayList;
import java.util.Collections;

public class Queen extends ChessPiece{
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
        yp = y; xp = x;
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
