//Chris Liu - this works
package CLOO;

import java.util.ArrayList;

public class Rook implements ChessPiece {
    ArrayList<Point> output = new ArrayList<>();
    private int[][] data = {
            {-2, -3, -4, -5, -6, -4, -3, -2},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {2, 3, 4, 5, 6, 4, 3, 2}
    };
    public Rook(){
    }
    @Override
    public void setData(int[][] input) {
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(input[i], 0, data[i], 0, data[i].length);
        }
        output.clear();
    }

    @Override
    public int getData(int yp, int xp) {
        return data[yp][xp];
    }
    @Override
    public ArrayList<Point> checkMoves(int yp, int xp, boolean white) {
        output.add(new Point(yp,xp));
        ArrayList<Point> vertical = new ArrayList<>();
        ArrayList<Point> horizontal = new ArrayList<>();
        //horizontal data
        int[] x = new int[8];
        for (int i = 0; i < x.length; i++) {
            x[i] = getData(yp, i);
        }
        //vertical data
        int[] y = new int[8];
        for (int i = 0; i < y.length; i++) {
            y[i] =  getData(i, xp);
        }
        if (white) {
            //right
            boolean right = true;
            int r = xp;
            while (r < x.length - 1 && right) {
                r++;
                if (x[r] < 0) {
                    horizontal.add(new Point(yp, r));
                    right = false;
                }
                if (x[r] > 0) {
                    right = false;
                }
                if (x[r] == 0) {
                    horizontal.add(new Point(yp, r));
                }
            }
            //left
            boolean left = true;
            int l = xp;
            while (l>0&&left) {
                l--;
                if (x[l] < 0) {
                    horizontal.add(new Point(yp, l));
                    left = false;
                }
                if (x[l] > 0) {
                    left = false;
                }
                if (x[l] == 0) {
                    horizontal.add(new Point(yp, l));
                }
            }
            //down
            boolean down = true;
            int d = yp;
            while (d<y.length-1&&down) {
                d++;
                if (y[d] < 0) {
                    vertical.add(new Point(d, xp));
                    down = false;
                }
                if (y[d] > 0) {
                    down = false;
                }
                if (y[d] == 0) {
                    vertical.add(new Point(d, xp));
                }
            }
            //up
            boolean up = true;
            int u = yp;
            while (u > 0 && up) {
                u--;
                if (y[u] < 0) {
                    vertical.add(new Point(u, xp));
                    up = false;
                }
                if (y[u] > 0) {
                    up = false;
                }
                if (y[u] == 0) {
                    vertical.add(new Point(u, xp));
                }
            }
            output.addAll(horizontal);
            output.addAll(vertical);
        }
        if (!(white)) {
            //right
            boolean right = true;
            int r = xp;
            while (r < 7 && right) {
                r++;
                if (x[r] > 0) {
                    horizontal.add(new Point(yp, r));
                    right = false;
                }
                if (x[r] < 0) {
                    right = false;
                }
                if (x[r] == 0) {
                    horizontal.add(new Point(yp, r));
                }
            }
            //left
            boolean left = true;
            int l = xp;
            while (l > 0 && left) {
                l--;
                if (x[l] > 0) {
                    horizontal.add(new Point(yp, l));
                    left = false;
                }
                if (x[l] < 0) {
                    left = false;
                }
                if (x[l] == 0) {
                    horizontal.add(new Point(yp, l));
                }
            }
            //down
            boolean down = true;
            int d = yp;
            while (d < 7 && down) {
                d++;
                if (y[d] > 0) {
                    down = false;
                    vertical.add(new Point(d, xp));
                }
                if (y[d] < 0) {
                    down = false;
                }
                if (y[d] == 0) {
                    vertical.add(new Point(d, xp));
                }
            }
            //up
            boolean up = true;
            int u = yp;
            while (u>0&&up) {
                u--;
                if (y[u] > 0) {
                    vertical.add(new Point(u, xp));
                    up = false;
                }
                if (y[u] < 0) {
                    up = false;
                }
                if (y[u] == 0) {
                    vertical.add(new Point(u, xp));
                }
            }
            output.addAll(horizontal);
            output.addAll(vertical);
        }
        return output;
    }
}
