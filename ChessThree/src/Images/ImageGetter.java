package Images;

import ChessGame.GameData;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageGetter {
    //Fancy
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
    //Using the ChessImage Enum to get the path
    //Enter the path for imgLoc and specific measurements
    //Returns an image object of specific size
    public Image getImage(String imgLoc, int w, int h) throws IOException {
         Image temp = ImageIO.read(getClass().getResource(imgLoc));
         return temp.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }
    //Enter data from GameData
    //Returns an image object of specific size
    //Returns gray or transparent based off position in tiles
    public Image getImage(GameData gameData, int y, int x, int w, int h) throws IOException {
        String data = gameData.getData()[y][x];
        if(data.equals("BK")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.bk.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.bkg.getImgLoc(),w,h);
        }
        if(data.equals("BQ")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.bq.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.bqg.getImgLoc(),w,h);
        }
        if(data.equals("BB")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.bb.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.bbg.getImgLoc(),w,h);
        }
        if(data.equals("BR")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.br.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.brg.getImgLoc(),w,h);
        }
        if(data.equals("BN")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.bn.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.bng.getImgLoc(),w,h);
        }
        if(data.equals("BP")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.bp.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.bpg.getImgLoc(),w,h);
        }
        if(data.equals("WK")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.wk.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.wkg.getImgLoc(),w,h);
        }
        if(data.equals("WQ")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.wq.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.wqg.getImgLoc(),w,h);
        }
        if(data.equals("WB")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.wb.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.wbg.getImgLoc(),w,h);
        }
        if(data.equals("WR")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.wr.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.wrg.getImgLoc(),w,h);
        }
        if(data.equals("WN")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.wn.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.wng.getImgLoc(),w,h);
        }
        if(data.equals("WP")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.wp.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.wpg.getImgLoc(),w,h);
        }
        if(data.equals("XX")){
            if(tiles[y][x] == 0)
                return getImage(ChessImage.empty.getImgLoc(),w,h);
            if(tiles[y][x] == 1)
                return getImage(ChessImage.gray.getImgLoc(),w,h);
        }
        return null;
    }
}

