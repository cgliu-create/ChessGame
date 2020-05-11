package ChessPieces;

import java.util.ArrayList;

public class Knight extends ChessPiece{
    private ArrayList<Point> output = new ArrayList<>();
    @Override
    public ArrayList<Point> checkMoves(int y, int x) {
        int yp = y;
        int xp = x;
        output.clear();
        output.add(new Point(yp, xp));
        //upright
        yp = y - 2;
        xp = x + 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //upleft
        yp = y - 2;
        xp = x - 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //rightup
        yp = y - 1;
        xp = x + 2;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //leftup
        yp = y - 1;
        xp = x - 2;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //downright
        yp = y + 2;
        xp = x + 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //downleft
        yp = y + 2;
        xp = x - 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //rightdown
        yp = y + 1;
        xp = x + 2;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //leftdown
        yp = y + 1;
        xp = x - 2;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        return output;
    }
}
