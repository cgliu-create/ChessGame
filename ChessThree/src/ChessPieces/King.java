package ChessPieces;

import java.util.ArrayList;

public class King extends ChessPiece{
    private ArrayList<Point> output = new ArrayList<>();
    @Override
    public ArrayList<Point> checkMoves(int y, int x) {
        int yp = y;
        int xp = x;
        output.clear();
        output.add(new Point(yp, xp));
        //up
        yp = y - 1;
        xp = x;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //left
        yp = y;
        xp = x - 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //right
        yp = y;
        xp = x + 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //down
        yp = y + 1;
        xp = x;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //upright
        yp = y - 1;
        xp = x + 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //upleft
        yp = y - 1;
        xp = x - 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //downleft
        yp = y + 1;
        xp = x - 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        //downright
        yp = y + 1;
        xp = x + 1;
        if (isValid(yp, xp) && isClear(y, x, yp, xp)) {
            output.add(new Point(yp, xp));
        }
        return output;
    }
}
