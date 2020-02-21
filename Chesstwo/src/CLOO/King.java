//Chris Liu - this works
package CLOO;

import java.util.ArrayList;

public class King implements  ChessPiece{
    ArrayList<Point> output = new ArrayList<Point>();
    private int[][] data = {
            {-2, -3, -4, -5, -6, -4, -3, -2},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {2, 3, 4, 5, 6, 4, 3, 2},
    };
    @Override
    public void setData(int[][] input) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = input[i][j];
            }
        }
        output.clear();
    }

    @Override
    public int getData(int yp, int xp) {
        return data[yp][xp];
    }

    @Override
    public ArrayList<Point> checkMoves(int yp, int xp, boolean white) {
        output.add(new Point(yp, xp));
        int y;
        int x;
        if (white) {
            //up
            y = yp - 1;
            x = xp;
            if (y >= 0) {
                if (getData(y, x) <= 0)
                    output.add(new Point(y, x));
            }
            //left
            y = yp;
            x = xp - 1;
            if (x >= 0) {
                if (getData(y, x) <= 0)
                    output.add(new Point(y, x));
            }
            //right
            y = yp;
            x = xp + 1;
            if (x <= 7) {
                if (getData(y, x) <= 0)
                    output.add(new Point(y, x));
            }
            //down
            y = yp + 1;
            x = xp;
            if (y <= 7) {
                if (getData(y, x) <= 0)
                    output.add(new Point(y, x));
            }
            //upleft
            y = yp - 1;
            x = xp - 1;
            if (y >= 0 && x >= 0) {
                if (getData(y, x) <= 0)
                    output.add(new Point(y, x));
            }
            //upright
            y = yp - 1;
            x = xp + 1;
            if (y >= 0 && x <= 7) {
                if (getData(y, x) <= 0)
                    output.add(new Point(y, x));
            }
            //downleft
            y = yp + 1;
            x = xp - 1;
            if (y <= 7 && x >= 0) {
                if (getData(y, x) <= 0)
                    output.add(new Point(y, x));
            }
            //downright
            y = yp + 1;
            x = xp + 1;
            if (y <= 7 && x <= 7) {
                if (getData(y, x) <= 0)
                    output.add(new Point(y, x));
            }
        }
        if (!(white)) {
            //up
            y = yp - 1;
            x = xp;
            if (y >= 0) {
                if (getData(y, x) >= 0)
                    output.add(new Point(y, x));
            }
            //left
            y = yp;
            x = xp - 1;
            if (x >= 0) {
                if (getData(y, x) >= 0)
                    output.add(new Point(y, x));
            }
            //right
            y = yp;
            x = xp + 1;
            if (x <= 7) {
                if (getData(y, x) >= 0)
                    output.add(new Point(y, x));
            }
            //down
            y = yp + 1;
            x = xp;
            if (y <= 7) {
                if (getData(y, x) >= 0)
                    output.add(new Point(y, x));
            }
            //upleft
            y = yp - 1;
            x = xp - 1;
            if (y >= 0 && x >= 0) {
                if (getData(y, x) >= 0)
                    output.add(new Point(y, x));
            }
            //upright
            y = yp - 1;
            x = xp + 1;
            if (y >= 0 && x <= 7) {
                if (getData(y, x) >= 0)
                    output.add(new Point(y, x));
            }
            //downleft
            y = yp + 1;
            x = xp - 1;
            if (y <= 7 && x >= 0) {
                if (getData(y, x) >= 0)
                    output.add(new Point(y, x));
            }
            //downright
            y = yp + 1;
            x = xp + 1;
            if (y <= 7 && x <= 7) {
                if (getData(y, x) >= 0)
                    output.add(new Point(y, x));
            }
        }
        return output;
    }
}
