//Chris Liu - this works
package CLOO;

import java.util.ArrayList;

public class Knight implements ChessPiece {
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
    public Knight(){
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
        output.add(new Point(yp, xp));
        int y;
        int x;
        if (white){
            //upright
            y = yp-2;
            x = xp+1;
            if (y>=0&&x<=7){
                if(getData(y,x)<=0)
                    output.add(new Point(y, x));
            }
            //upleft
            y = yp-2;
            x = xp-1;
            if (y>=0&&x>=0){
                if(getData(y,x)<=0)
                    output.add(new Point(y, x));
            }
            //rightup
            y = yp-1;
            x = xp+2;
            if (y>=0&&x<=7){
                if(getData(y,x)<=0)
                    output.add(new Point(y, x));
            }
            //leftup
            y = yp-1;
            x = xp-2;
            if (y>=0&&x>=0){
                if(getData(y,x)<=0)
                    output.add(new Point(y, x));
            }
            //downright
            y = yp+2;
            x = xp+1;
            if (y<=7&&x<=7){
                if(getData(y,x)<=0)
                    output.add(new Point(y, x));
            }
            //downleft
            y = yp+2;
            x = xp-1;
            if (y<=7&&x>=0){
                if(getData(y,x)<=0)
                    output.add(new Point(y, x));
            }
            //rightdown
            y = yp+1;
            x = xp+2;
            if (y<=7&&x<=7){
                if(getData(y,x)<=0)
                    output.add(new Point(y, x));
            }
            //leftdown
            y = yp+1;
            x = xp-2;
            if (y<=7&&x>=0){
                if(getData(y,x)<=0)
                    output.add(new Point(y, x));
            }
        }
        if (!(white)){
            //upright
            y = yp-2;
            x = xp+1;
            if (y>=0&&x<=7){
                if(getData(y,x)>=0)
                    output.add(new Point(y, x));
            }
            //upleft
            y = yp-2;
            x = xp-1;
            if (y>=0&&x>=0){
                if(getData(y,x)>=0)
                    output.add(new Point(y, x));
            }
            //rightup
            y = yp-1;
            x = xp+2;
            if (y>=0&&x<=7){
                if(getData(y,x)>=0)
                    output.add(new Point(y, x));
            }
            //leftup
            y = yp-1;
            x = xp-2;
            if (y>=0&&x>=0){
                if(getData(y,x)>=0)
                    output.add(new Point(y, x));
            }
            //downright
            y = yp+2;
            x = xp+1;
            if (y<=7&&x<=7){
                if(getData(y,x)>=0)
                    output.add(new Point(y, x));
            }
            //downleft
            y = yp+2;
            x = xp-1;
            if (y<=7&&x>=0){
                if(getData(y,x)>=0)
                    output.add(new Point(y, x));
            }
            //rightdown
            y = yp+1;
            x = xp+2;
            if (y<=7&&x<=7){
                if(getData(y,x)>=0)
                    output.add(new Point(y, x));
            }
            //leftdown
            y = yp+1;
            x = xp-2;
            if (y<=7&&x>=0){
                if(getData(y,x)>=0)
                    output.add(new Point(y, x));
            }
        }
        return output;
    }
}
