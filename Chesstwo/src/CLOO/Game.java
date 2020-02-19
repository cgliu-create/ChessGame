package CLOO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Game{
    //this class stores game data and images
    //WK=6,WQ=5,WB=4,WN=3,WR=2,WP=1
    //BK=-6,BQ=-5,BB=-4,BN=-3,BR=-2,BP=-1
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
    //method to make changes to data
    public void changeData(int yp, int xp, int ys, int xs) {
        int type = data[yp][xp];
        data[yp][xp] = 0;
        data[ys][xs] = type;
    }
    public int getData(int yp, int xp){
        return data[yp][xp];
    }
    //images
    private Image wk;
    private Image wq;
    private Image wb;
    private Image wr;
    private Image wn;
    private Image wp;
    private Image bk;
    private Image bq;
    private Image bb;
    private Image br;
    private Image bn;
    private Image bp;
    private Image empty;
    //constructor
    public Game() {
        try {//https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659
            wk = ImageIO.read(getClass().getResource("/ChessP/WK.png"));
            wq = ImageIO.read(getClass().getResource("/ChessP/WQ.png"));
            wb = ImageIO.read(getClass().getResource("/ChessP/WB.png"));
            wr = ImageIO.read(getClass().getResource("/ChessP/WR.png"));
            wn = ImageIO.read(getClass().getResource("/ChessP/WN.png"));
            wp = ImageIO.read(getClass().getResource("/ChessP/WP.png"));
            bk = ImageIO.read(getClass().getResource("/ChessP/BK.png"));
            bq = ImageIO.read(getClass().getResource("/ChessP/BQ.png"));
            bb = ImageIO.read(getClass().getResource("/ChessP/BB.png"));
            br = ImageIO.read(getClass().getResource("/ChessP/BR.png"));
            bn = ImageIO.read(getClass().getResource("/ChessP/BN.png"));
            bp = ImageIO.read(getClass().getResource("/ChessP/BP.png"));
            empty = ImageIO.read(getClass().getResource("/ChessP/empty.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Image getImage(int a, int b, int w, int h) {
        if (data[a][b] == 1)
            return wp.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == 2)
            return wr.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == 3)
            return wn.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == 4)
            return wb.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == 5)
            return wq.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == 6)
            return wk.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == -1)
            return bp.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == -2)
            return br.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == -3)
            return bn.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == -4)
            return bb.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == -5)
            return bq.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == -6)
            return bk.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        if (data[a][b] == 0)
            return empty.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return null;
    }
    //pawn
    public ArrayList<Point> pawn(int yp, int xp, boolean white){
        ArrayList<Point> output = new ArrayList<Point>();
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
    //piece rules
    /*private int[][] data = {
    // y,x
            cr 0  1  2  3  4  5  6  7
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
    //rook
    public ArrayList<Point> rook(int yp, int xp , boolean white){
        ArrayList<Point> output = new ArrayList<Point>();
            //vertical and horizontal any distance
            boolean hita = true;
            ArrayList<Integer> horizontal = new ArrayList<Integer>();
            for (int i = 0; i < data[yp].length; i++) {
                horizontal.add(data[yp][i]);
            }
            System.out.println(horizontal.toString());
            ArrayList<Integer> vertical = new ArrayList<Integer>();
            vertical.add( getData(0,xp));
            vertical.add( getData(1,xp));
            vertical.add( getData(2,xp));
            vertical.add( getData(3,xp));
            vertical.add( getData(4,xp));
            vertical.add( getData(5,xp));
            vertical.add( getData(6,xp));
            vertical.add( getData(7,xp));
            System.out.println(vertical.toString());
            int enda=0;
            int endb=0;
            //trim vertical
            for (int i = yp; i <8 ; i++) { //above
                if (vertical.get(i)<0)
                    enda=i;
                if (vertical.get(i)>0)
                    enda=i-1;
                if (yp==7)
                    enda = yp;
            }
            for (int i = 0; i < yp ; i++) { //below
                if (vertical.get(i)<0)
                    endb=i;
                if (vertical.get(i)>0)
                    endb=i+1;
                if (yp==0)
                    endb = yp;
            }
        System.out.println(enda);
        System.out.println(endb);
            for (int i = 7; i >= enda; i--) {
                vertical.remove(i);
            }
            for (int i = 0; i <= endb; i++) {
                vertical.remove(0);
            }
        System.out.println(vertical.toString());
            int endc=0;
            int endd=0;
            //trim horizontal
            for (int i = xp; i <8 ; i++) {
                if (horizontal.get(i)<0)
                    endc=i;
                if (horizontal.get(i)>0)
                    endc=i-1;
                if (xp==7)
                    endc = xp;
            }
            for (int i = 0; i < yp ; i++) {
                if (horizontal.get(i)<0)
                    endd=i;
                if (horizontal.get(i)>0)
                    endd=i+1;
                if (xp==0)
                    endd = xp;
            }
        System.out.println(endc);
        System.out.println(endd);
            for (int i = 7; i >= enda; i--) {
                horizontal.remove(i);
            }
            for (int i = 0; i <= endb; i++) {
                horizontal.remove(0);
            }
        System.out.println(horizontal.toString());
            //add up points
            for (int y:vertical) {
                output.add(new Point(y,xp));
            }
            for (int x:horizontal) {
                output.add(new Point(yp,x));
            }
            output.add(new Point(yp,xp));
            System.out.println(output.toString());
        return output;
    }
    //WK=6,WQ=5,WB=4,WN=3,WR=2,WP=1
    //BK=-6,BQ=-5,BB=-4,BN=-3,BR=-2,BP=-1
    public ArrayList<Point> checkMoves(int a, int b) {
        if (data[a][b] == 1)
            return pawn(a, b, true);

        if (data[a][b] == 2)
            return rook(a, b, true);
        /*
        if (data[a][b] == 3)
            return
        if (data[a][b] == 4)
            return
        if (data[a][b] == 5)
            return
        if (data[a][b] == 6)
            return
         */
        if (data[a][b] == -1)
            return pawn(a, b, false);
        if (data[a][b] == -2)
            return rook(a, b, false);
        /*
        if (data[a][b] == -3)
            return
        if (data[a][b] == -4)
            return
        if (data[a][b] == -5)
            return
        if (data[a][b] == -6)
            return
         */
        ArrayList<Point> output = new ArrayList<Point>();
        output.add(new Point(a,b));
        return output;
    }

}