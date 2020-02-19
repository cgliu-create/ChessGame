package CLOO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel{
    //WK=6,WQ=5,WB=4,WN=3,WR=2,WP=1
    //BK=-6,BQ=-5,BB=-4,BN=-3,BR=-2,BP=-1
    int[][] backbone ={
            {-2,-1,0,0,0,0,1,2},
            {-3,-1,0,0,0,0,1,3},
            {-4,-1,0,0,0,0,1,4},
            {-5,-1,0,0,0,0,1,5},
            {-6,-1,0,0,0,0,1,6},
            {-4,-1,0,0,0,0,1,4},
            {-3,-1,0,0,0,0,1,3},
            {-2,-1,0,0,0,0,1,2}
    };
    //frame size
    private static int WIDTH=800;
    private static int HEIGHT=800;
    //shapes
    private Shape[][] grid = new Shape[8][8];
    //constructor for
    public Game() {
        setVisible(true);
        setBackground(Color.BLACK);
    }
    public void update(Graphics window){
        paint(window);
    }
    //sets up shapes
    public void paint(Graphics window){
        for (int c=0;c<grid.length;c++){
            for (int r=0;r<grid[c].length;r++){
                //alternating colors
                if(c%2==0&&r%2==0) {
                    grid[c][r] = new Shape(c*getWIDTH()/8, r*getHEIGHT()/8, getWIDTH()/8, getHEIGHT()/8, Color.gray);
                }else if (c%2==1&&r%2==1){
                    grid[c][r] = new Shape(c*getWIDTH()/8, r*getHEIGHT()/8, getWIDTH()/8, getHEIGHT()/8, Color.gray);
                }else{
                    grid[c][r]=new Shape(c*getWIDTH()/8,r*getHEIGHT()/8,getWIDTH()/8,getHEIGHT()/8,Color.white);
                }
            }
        }
        //draws grid
        for (Shape[] column: grid) {
            for (Shape row: column) {
                window.setColor(row.getColor());
                window.fillRect(row.getxPos(),row.getyPos(),row.getWidth(),row.getHeight());
                window.setColor(Color.BLACK);
                window.drawRect(row.getxPos(),row.getyPos(),row.getWidth(),row.getHeight());
            }
        }
        //adds numbers and letters to grid
        window.drawString("8",2, getHEIGHT()/8-2);
        window.drawString("7",2,getHEIGHT()/8*2-2);
        window.drawString("6",2,getHEIGHT()/8*3-2);
        window.drawString("5",2,getHEIGHT()/8*4-2);
        window.drawString("4",2,getHEIGHT()/8*5-2);
        window.drawString("3",2,getHEIGHT()/8*6-2);
        window.drawString("2",2,getHEIGHT()/8*7-2);
        window.drawString("1a",2,getHEIGHT()/8*8-2);
        window.drawString("b",getWIDTH()/8+2,getHEIGHT()/8*8-2);
        window.drawString("c",getWIDTH()/8*2+2,getHEIGHT()/8*8-2);
        window.drawString("d",getWIDTH()/8*3+2,getHEIGHT()/8*8-2);
        window.drawString("e",getWIDTH()/8*4+2,getHEIGHT()/8*8-2);
        window.drawString("f",getWIDTH()/8*5+2,getHEIGHT()/8*8-2);
        window.drawString("g",getWIDTH()/8*6+2,getHEIGHT()/8*8-2);
        window.drawString("h",getWIDTH()/8*7+2,getHEIGHT()/8*8-2);
        //https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659
        try {
            BufferedImage Wk = ImageIO.read(getClass().getResource("/ChessP/WK.png"));
            Image wk = Wk.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Wq = ImageIO.read(getClass().getResource("/ChessP/WQ.png"));
            Image wq = Wq.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Wb = ImageIO.read(getClass().getResource("/ChessP/WB.png"));
            Image wb = Wb.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Wr = ImageIO.read(getClass().getResource("/ChessP/WR.png"));
            Image wr = Wr.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Wn = ImageIO.read(getClass().getResource("/ChessP/WN.png"));
            Image wn = Wn.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Wp = ImageIO.read(getClass().getResource("/ChessP/WP.png"));
            Image wp = Wp.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Bk = ImageIO.read(getClass().getResource("/ChessP/BK.png"));
            Image bk = Bk.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Bq = ImageIO.read(getClass().getResource("/ChessP/BQ.png"));
            Image bq = Bq.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Bb = ImageIO.read(getClass().getResource("/ChessP/BB.png"));
            Image bb = Bb.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Br = ImageIO.read(getClass().getResource("/ChessP/BR.png"));
            Image br = Br.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Bn = ImageIO.read(getClass().getResource("/ChessP/BN.png"));
            Image bn = Bn.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            BufferedImage Bp = ImageIO.read(getClass().getResource("/ChessP/BP.png"));
            Image bp = Bp.getScaledInstance(getWIDTH()/8,getHEIGHT()/8,Image.SCALE_SMOOTH);
            //adds chess piece image based of backbone and grid
            //WK=6,WQ=5,WB=4,WN=3,WR=2,WP=1
            //BK=-6,BQ=-5,BB=-4,BN=-3,BR=-2,BP=-1
            for (int c=0;c<backbone.length;c++) {
                for (int r = 0; r < backbone[c].length; r++) {
                    if(backbone[c][r]==1)
                        window.drawImage(wp,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==2)
                        window.drawImage(wr,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==3)
                        window.drawImage(wn,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==4)
                        window.drawImage(wb,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==5)
                        window.drawImage(wq,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==6)
                        window.drawImage(wk,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==-1)
                        window.drawImage(bp,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==-2)
                        window.drawImage(br,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==-3)
                        window.drawImage(bn,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==-4)
                        window.drawImage(bb,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==-5)
                        window.drawImage(bq,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                    if(backbone[c][r]==-6)
                        window.drawImage(bk,grid[c][r].getxPos(),grid[c][r].getyPos(),this);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //methods to access panel's size
    public int getWIDTH(){return WIDTH;}
    public int getHEIGHT(){return HEIGHT;}
    //methods to set panel's size
    public void setWIDTH(int w){WIDTH=w;}
    public void setHEIGHT(int h){HEIGHT=h;}//backbone
    //methods to make changes to backbone
    public void changeBackBone(int cp, int rp, int cs, int rs){
        int type = backbone[cp][rp];
        backbone[cp][rp]=0;
        backbone[cs][rs]=type;
    }
}
