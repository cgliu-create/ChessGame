package CLOO;

import java.util.ArrayList;

public interface ChessPiece {
    /*
    private int[][] data = {
    // y,x
               0  1  2  3  4  5  6  7
            0{-2,-3,-4,-5,-6,-4,-3,-2},
            1{-1,-1,-1,-1,-1,-1,-1,-1},
            2{ 0, 0, 0, 0, 0, 0, 0, 0},
            3{ 0, 0, 0, 0, 0, 0, 0, 0},
            4{ 0, 0, 0, 0, 0, 0, 0, 0},
            5{ 0, 0, 0, 0, 0, 0, 0, 0},
            6{ 1, 1, 1, 1, 1, 1, 1, 1},
            7{ 2, 3, 4, 5, 6, 4, 3, 2},
    };
    */
    public void setData(int[][] input);
    public int getData(int yp, int xp);
    public ArrayList<Point> checkMoves(int yp, int xp, boolean white);
}
