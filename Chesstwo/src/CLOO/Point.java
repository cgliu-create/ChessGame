//Chris Liu - this works
package CLOO;

public class Point {
    private int x;
    private int y;
    public Point(int yval, int xval){
        x=xval;y=yval;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
