package CLOO;

import java.util.ArrayList;

public class Pawn implements  ChessPiece{
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
    public Pawn(){
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
    @Override
    public ArrayList<Point> checkMoves(int yp, int xp, boolean white){
        if(white){
            //two if at start
            if (yp == 6 && data[5][xp]==0 && data[4][xp]==0){
                output.add(new Point(5,xp));output.add(new Point(4,xp));
            }
            //one if not
            if (yp != 6 && yp != 0 && data[yp-1][xp]==0){
                output.add(new Point(yp-1,xp));
            }
            //diagonal to enemies
            if (yp != 6 && yp != 0){
                if (xp!= 0){
                    if (data[yp-1][xp-1]!=0){
                        output.add(new Point(yp-1,xp-1));
                    }
                }
                if (xp!= 7){
                    if (data[yp-1][xp+1]!=0){
                        output.add(new Point(yp-1,xp+1));
                    }
                }
            }
        }
        if(!(white)){
            if (yp == 1 && data[2][xp]==0 && data[3][xp]==0){
                output.add(new Point(2,xp));output.add(new Point(3,xp));
            }
            if (yp != 1 && yp != 7 && data[yp+1][xp]==0){
                output.add(new Point(yp+1,xp));
            }
            if (yp != 1 && yp != 7){
                if (xp!= 0){
                    if (data[yp+1][xp-1]!=0){
                        output.add(new Point(yp+1,xp-1));
                    }
                }
                if (xp!= 7){
                    if (data[yp+1][xp+1]!=0){
                        output.add(new Point(yp+1,xp+1));
                    }
                }
            }
        }
        return output;
    }
}
