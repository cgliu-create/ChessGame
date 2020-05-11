package ChessPieces;

public class Point {
    //Coordinates
    private int x;
    private int y;
    //Constructor
    public Point(int y, int x){
        this.x = x;
        this.y = y;
    }
    //Returns coordinates
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public boolean equals(Object other){
        if(other instanceof Point){
            Point p = (Point)other;
            return this.getX() == p.getX() && this.getY() == p.getY();
        }
        return false;
    }
}
