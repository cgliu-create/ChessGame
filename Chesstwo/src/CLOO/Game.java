//Chris Liu - this works
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
            {2, 3, 4, 5, 6, 4, 3, 2}
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
    private Image gwk;
    private Image gwq;
    private Image gwb;
    private Image gwr;
    private Image gwn;
    private Image gwp;
    private Image gbk;
    private Image gbq;
    private Image gbb;
    private Image gbr;
    private Image gbn;
    private Image gbp;
    private Image gray;
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
            gwk = ImageIO.read(getClass().getResource("/ChessP/WKG.png"));
            gwq = ImageIO.read(getClass().getResource("/ChessP/WQG.png"));
            gwb = ImageIO.read(getClass().getResource("/ChessP/WBG.png"));
            gwr = ImageIO.read(getClass().getResource("/ChessP/WRG.png"));
            gwn = ImageIO.read(getClass().getResource("/ChessP/WNG.png"));
            gwp = ImageIO.read(getClass().getResource("/ChessP/WPG.png"));
            gbk = ImageIO.read(getClass().getResource("/ChessP/BKG.png"));
            gbq = ImageIO.read(getClass().getResource("/ChessP/BQG.png"));
            gbb = ImageIO.read(getClass().getResource("/ChessP/BBG.png"));
            gbr = ImageIO.read(getClass().getResource("/ChessP/BRG.png"));
            gbn = ImageIO.read(getClass().getResource("/ChessP/BNG.png"));
            gbp = ImageIO.read(getClass().getResource("/ChessP/BPG.png"));
            gray = ImageIO.read(getClass().getResource("/ChessP/gray.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int[][] tiles = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1}
    };
    public Image getImage(int a, int b, int w, int h) {
        if (data[a][b] == 1){
            if(tiles[a][b] == 0)
                return wp.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gwp.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }

        if (data[a][b] == 2){
            if(tiles[a][b] == 0)
                return wr.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gwr.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == 3){
            if(tiles[a][b] == 0)
                return wn.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gwn.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == 4){
            if(tiles[a][b] == 0)
                return wb.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gwb.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == 5){
            if(tiles[a][b] == 0)
                return wq.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gwq.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }

        if (data[a][b] == 6){
            if(tiles[a][b] == 0)
                return wk.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gwk.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == -1){
            if(tiles[a][b] == 0)
                return bp.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gbp.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == -2){
            if(tiles[a][b] == 0)
                return br.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gbr.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == -3){
            if(tiles[a][b] == 0)
                return bn.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gbn.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == -4){
            if(tiles[a][b] == 0)
                return bb.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gbb.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == -5){
            if(tiles[a][b] == 0)
                return bq.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gbq.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == -6){
            if(tiles[a][b] == 0)
                return bk.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gbk.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        if (data[a][b] == 0){
            if(tiles[a][b] == 0)
                return empty.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            if(tiles[a][b] == 1)
                return gray.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
        return null;
    }
    //WK=6,WQ=5,WB=4,WN=3,WR=2,WP=1
    //BK=-6,BQ=-5,BB=-4,BN=-3,BR=-2,BP=-1
    private Pawn P = new Pawn();
    private Rook R = new Rook();
    private Bishop B = new Bishop();
    private  Knight N = new Knight();
    private  Queen Q = new Queen();
    private  King K = new King();

    public ArrayList<Point> checkMoves(int a, int b) {
        if (data[a][b] == 1) {
            P.setData(data);
            return P.checkMoves(a, b, true);
        }
        if (data[a][b] == 2){
            R.setData(data);
            return R.checkMoves(a, b, true);
        }
        if (data[a][b] == 3) {
            N.setData(data);
            return N.checkMoves(a, b, true);
        }
        if (data[a][b] == 4){
            B.setData(data);
            return B.checkMoves(a, b, true);
        }
        if (data[a][b] == 5){
            Q.setData(data);
            return Q.checkMoves(a, b, true);
        }
        if (data[a][b] == 6){
            K.setData(data);
            return K.checkMoves(a, b, true);
        }
        if (data[a][b] == -1){
            P.setData(data);
            return P.checkMoves(a, b, false);
        }
        if (data[a][b] == -2){
            R.setData(data);
            return R.checkMoves(a, b, false);
        }
        if (data[a][b] == -3) {
            N.setData(data);
            return N.checkMoves(a, b, false);
        }
        if (data[a][b] == -4){
            B.setData(data);
            return B.checkMoves(a, b, false);
        }
        if (data[a][b] == -5){
            Q.setData(data);
            return Q.checkMoves(a, b, false);
        }
        if (data[a][b] == -6){
            K.setData(data);
            return K.checkMoves(a, b, false);
        }
        ArrayList<Point> output = new ArrayList<Point>();
        output.add(new Point(a,b));
        return output;
    }
}