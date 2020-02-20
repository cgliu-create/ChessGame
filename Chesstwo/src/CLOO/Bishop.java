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
        //System.out.println(out.toString());
        return out;
    }
    public ArrayList<Point> getDiagonalPoints(int yp, int xp, int onetofour ) {
        ArrayList<Point> out = new ArrayList<Point>();
        int y = yp;
        int x = xp;
        if(onetofour == 1){
            while (x != 7 && y!=0) {
                y--;
                x++;
                out.add(new Point(y, x));
            }
        }
        if(onetofour == 2){
            while (x != 7 && y!=7) {
                y++;
                x++;
                out.add(new Point(y, x));
            }
        }
        if(onetofour == 3){
            while (x != 0 && y!=7) {
                y++;
                x--;
                out.add(new Point(y, x));
            }
        }
        if(onetofour == 4){
            while (x != 0 && y!=0) {
                y--;
                x--;
                out.add(new Point(y, x));
            }
        }
        //System.out.println(out.toString());
        return out;
    }
    @Override
    public ArrayList<Point> checkMoves(int yp, int xp, boolean white) {
        output.add(new Point(yp, xp));
        //diagonal data
        ArrayList<Integer> Pup = getDiagonalData(yp,xp,1);
        ArrayList<Integer> Pdown = getDiagonalData(yp,xp,3);
        ArrayList<Integer> Nup = getDiagonalData(yp,xp,4);
        ArrayList<Integer> Ndown = getDiagonalData(yp,xp,2);
        //diagonal points
        ArrayList<Point> DPup = getDiagonalPoints(yp,xp,1);
        ArrayList<Point> DPdown = getDiagonalPoints(yp,xp,3);
        ArrayList<Point> DNup = getDiagonalPoints(yp,xp,4);
        ArrayList<Point> DNdown = getDiagonalPoints(yp,xp,2);
        //trim
        if (white){
            int a = 0;
            boolean upp = true;
            while (a < Pup.size() && upp) {
                if (Pup.get(a)==0){
                    output.add(DPup.get(a));
                }
                if (Pup.get(a)<0){
                    output.add(DPup.get(a));
                    upp = false;
                }
                if (Pup.get(a)>0){
                    upp = false;
                }
                a++;
            }
            int b = 0;
            boolean downp = true;
            while (b < Pdown.size() && downp) {
                if (Pdown.get(b)==0){
                    output.add(DPdown.get(b));
                }
                if (Pdown.get(b)<0){
                    output.add(DPdown.get(b));
                    downp = false;
                }
                if (Pdown.get(b)>0){
                    downp = false;
                }
                b++;
            }
            int c = 0;
            boolean upn = true;
            while (c < Nup.size() && upn) {
                if (Nup.get(c)==0){
                    output.add(DNup.get(c));
                }
                if (Nup.get(c)<0){
                    output.add(DNup.get(c));
                    upn = false;
                }
                if (Nup.get(c)>0){
                    upn = false;
                }
                c++;
            }
            int d = 0;
            boolean downn = true;
            while (d < Ndown.size() && downn) {
                if (Ndown.get(d)==0){
                    output.add(DNdown.get(d));
                }
                if (Ndown.get(d)<0){
                    output.add(DNdown.get(d));
                    downn = false;
                }
                if (Ndown.get(d)>0){
                    downn = false;
                }
                d++;
            }
        }
        if (!(white)){
            int a = 0;
            boolean upp = true;
            while (a<Pup.size() && upp) {
                if (Pup.get(a)==0){
                    output.add(DPup.get(a));
                }
                if (Pup.get(a)>0){
                    output.add(DPup.get(a));
                    upp = false;
                }
                if (Pup.get(a)<0){
                    upp = false;
                }
                a++;
            }
            int b = 0;
            boolean downp = true;
            while (b<Pdown.size() && downp) {
                if (Pdown.get(b)==0){
                    output.add(DPdown.get(b));
                }
                if (Pdown.get(b)>0){
                    output.add(DPdown.get(b));
                    downp = false;
                }
                if (Pdown.get(b)<0){
                    downp = false;
                }
                b++;
            }
            int c = 0;
            boolean upn = true;
            while (c<Nup.size() && upn) {
                if (Nup.get(c)==0){
                    output.add(DNup.get(c));
                }
                if (Nup.get(c)>0){
                    output.add(DNup.get(c));
                    upn = false;
                }
                if (Nup.get(c)<0){
                    upn = false;
                }
                c++;
            }
            int d = 0;
            boolean downn = true;
            while (d<Ndown.size() && downn) {
                if (Ndown.get(d)==0){
                    output.add(DNdown.get(d));
                }
                if (Ndown.get(d)>0){
                    output.add(DNdown.get(d));
                    downn = false;
                }
                if (Ndown.get(d)<0){
                    downn = false;
                }
                d++;
            }
        }

        return output;
    }
}

