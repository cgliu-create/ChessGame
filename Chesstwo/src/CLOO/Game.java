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
    public ArrayList<int[]> pawn(int yp, int xp, boolean white){
        ArrayList<int[]> output = new ArrayList<int[]>();
        if(white){
            //two if at start
            if (yp == 6 && data[5][xp]==0 && data[4][xp]==0){
                int[] a = {5,xp};int[] b = {4,xp};output.add(a);output.add(b);
            }
            //one if not
            if (yp != 6 && yp != 0 && data[yp-1][xp]==0){
                int[] a = {yp-1,xp};output.add(a);
            }
            //diagonal to enemies
            if (yp != 6 && yp != 0){
                if (xp!= 0){
                    if (data[yp-1][xp-1]!=0){
                        int[] a = {yp-1,xp-1};output.add(a);
                    }
                }
                if (xp!= 7){
                    if (data[yp-1][xp+1]!=0){
                        int[] b = {yp-1,xp+1};output.add(b);
                    }
                }
            }
        }
        if(!(white)){
            if (yp == 1 && data[2][xp]==0 && data[3][xp]==0){
                int[] a = {2,xp};int[] b = {3,xp};
                output.add(a);output.add(b);
            }
            if (yp != 1 && yp != 7 && data[yp+1][xp]==0){
                int[] a = {yp+1,xp};
                output.add(a);
            }
            if (yp != 1 && yp != 7){
                if (xp!= 0){
                    if (data[yp+1][xp-1]!=0){
                        int[] a = {yp+1,xp-1};output.add(a);
                    }
                }
                if (xp!= 7){
                    if (data[yp+1][xp+1]!=0){
                        int[] b = {yp+1,xp+1};output.add(b);
                    }
                }
            }
        }
        return output;
    }
    public ArrayList<int[]> checkMoves(int a, int b) {
        if (data[a][b] == 1)
            return pawn(a, b, true);
        /*
        if (data[a][b] == 2)
            return
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
        /*
        if (data[a][b] == -2)
            return
        if (data[a][b] == -3)
            return
        if (data[a][b] == -4)
            return
        if (data[a][b] == -5)
            return
        if (data[a][b] == -6)
            return
         */
        if (data[a][b] == 0){
            ArrayList<int[]> output = new ArrayList<int[]>();
            int[] x = {a,b};output.add(x);return output;
        }
        return null;
    }

}