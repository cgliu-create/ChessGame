package CLOO;

import java.util.ArrayList;
import java.util.Collections;

public class Bishop implements ChessPiece{
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
    public Bishop(){
    }
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
    public ArrayList<Integer> getDiagonalData(int yp, int xp, int onetofour ) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        int y = yp;
        int x = xp;
        if(onetofour == 1){
            while (x != 7 && y!=0) {
                y--;
                x++;
                out.add(getData(y, x));
            }
        }
        if(onetofour == 2){
            while (x != 7 && y!=7) {
                y++;
                x++;
                out.add(getData(y, x));
            }
        }
        if(onetofour == 3){
            while (x != 0 && y!=7) {
                y++;
                x--;
                out.add(getData(y, x));
            }
        }
        if(onetofour == 4){
            while (x != 0 && y!=0) {
                y--;
                x--;
                out.add(getData(y, x));
            }
        }
        return out;
    }
    @Override
    public ArrayList<Point> checkMoves(int yp, int xp, boolean white) {
        output.add(new Point(yp, xp));
        ArrayList<Point> pos = new ArrayList<Point>();
        ArrayList<Point> neg = new ArrayList<Point>();
        //pos diagonal data
        ArrayList<Integer> Pup = getDiagonalData(yp,xp,1);
        ArrayList<Integer> Pdown = getDiagonalData(yp,xp,3);
        //neg diagonal data
        ArrayList<Integer> Nup = getDiagonalData(yp,xp,4);
        ArrayList<Integer> Ndown = getDiagonalData(yp,xp,2);

        if (white) {
            //upright
            boolean upright = true;
            int ry = yp;
            int rx = xp;
            int r = 0;
            while ( r < Pup.size()-1 && upright) {
                ry--;
                rx++;
                if (Pup.get(r) < 0) {
                    pos.add(new Point(ry, rx));
                    upright = false;
                }
                if (Pup.get(r) > 0) {
                    upright = false;
                }
                if (Pup.get(r) == 0) {
                    pos.add(new Point(ry, rx));
                }
                r++;
            }
            //downleft
            boolean downleft = true;
            int ly = yp;
            int lx = xp;
            int l = 0;
            while (l < Pdown.size()-1 && upright) {
                ly++;
                lx--;
                if (Pdown.get(l) < 0) {
                    pos.add(new Point(ly, lx));
                    downleft = false;
                }
                if (Pdown.get(l) > 0) {
                    downleft = false;
                }
                if (Pdown.get(l) == 0) {
                    pos.add(new Point(ly, lx));
                }
                l++;
            }
            //upleft
            boolean upleft = true;
            int lly = yp;
            int llx = xp;
            int ll = 0;
            while (ll < Nup.size()-1 && upleft) {
                lly--;
                llx--;
                if (Nup.get(ll) < 0) {
                    neg.add(new Point(lly, llx));
                    upleft = false;
                }
                if (Nup.get(ll) > 0) {
                    upleft = false;
                }
                if (Nup.get(ll) == 0) {
                    neg.add(new Point(lly, llx));
                }
                ll++;
            }
            //downright
            boolean downright = true;
            int rry = yp;
            int rrx = xp;
            int rr = 0;
            while (rr < Ndown.size()-1 && downright) {
                rry--;
                rrx--;
                if (Ndown.get(rr) < 0) {
                    neg.add(new Point(rry, rrx));
                    downright = false;
                }
                if (Ndown.get(rr) > 0) {
                    downright = false;
                }
                if (Ndown.get(rr) == 0) {
                    neg.add(new Point(rry, rrx));
                }
                rr++;
            }
        }
        for(Point p: pos){
            output.add(p);
        }
        for(Point n: neg) {
            output.add(n);
        }
        return output;
    }
}

