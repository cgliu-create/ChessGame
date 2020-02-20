package CLOO;

import java.util.ArrayList;

public class Queen implements ChessPiece{
    ArrayList<Point> output = new ArrayList<Point>();
    Bishop d = new Bishop();
    Rook hv = new Rook();
    public Queen(){
    }
    @Override
    public void setData(int[][] input) {
        d.setData(input);
        hv.setData(input);
        output.clear();
    }

    @Override
    public int getData(int yp, int xp) {
        return 0;
    }

    @Override
    public ArrayList<Point> checkMoves(int yp, int xp, boolean white) {
        ArrayList<Point> dp = d.checkMoves(yp, xp, white);
        ArrayList<Point> hvp = hv.checkMoves(yp, xp, white);
        for (Point p: dp) {
            output.add(p);
        }
        for (Point p: hvp) {
            output.add(p);
        }
        return output;
    }
}
