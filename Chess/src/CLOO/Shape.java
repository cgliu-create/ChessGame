package CLOO;

import java.awt.Color;

public class Shape {
    // instance fields
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    //constructor
    private Color color;
    public Shape(int x, int y, int w, int h, Color c){
        xPos=x; yPos=y; width=w; height=h; color=c;
    }
    //methods to access fields
    public int getxPos(){return xPos;}
    public int getyPos(){return yPos;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
    public Color getColor(){return color;}
    //methods to access fields
    public void setxPos(int x){xPos=x;}
    public void setyPos(int y){yPos=y;}
    public void setWidth(int w){width=w;}
    public void setHeight(int h){height=h;}
    public void setColor(Color c){color=c;}
}