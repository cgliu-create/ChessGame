package Images;

public enum ChessImage {
    //List of ChessImages
    empty("/Images/ChessImages/empty.png"),
    bk("/Images/ChessImages/BK.png"),
    bq("/Images/ChessImages/BQ.png"),
    bb("/Images/ChessImages/BB.png"),
    br("/Images/ChessImages/BR.png"),
    bn("/Images/ChessImages/BN.png"),
    bp("/Images/ChessImages/BP.png"),
    wk("/Images/ChessImages/WK.png"),
    wq("/Images/ChessImages/WQ.png"),
    wb("/Images/ChessImages/WB.png"),
    wr("/Images/ChessImages/WR.png"),
    wn("/Images/ChessImages/WN.png"),
    wp("/Images/ChessImages/WP.png"),
    gray("/Images/ChessImages/gray.png"),
    bkg("/Images/ChessImages/BKG.png"),
    bqg("/Images/ChessImages/BQG.png"),
    bbg("/Images/ChessImages/BBG.png"),
    brg("/Images/ChessImages/BRG.png"),
    bng("/Images/ChessImages/BNG.png"),
    bpg("/Images/ChessImages/BPG.png"),
    wkg("/Images/ChessImages/WKG.png"),
    wqg("/Images/ChessImages/WQG.png"),
    wbg("/Images/ChessImages/WBG.png"),
    wrg("/Images/ChessImages/WRG.png"),
    wng("/Images/ChessImages/WNG.png"),
    wpg("/Images/ChessImages/WPG.png");
    //Stores the path for an image file
    private String imgLoc;
    //Constructor
    ChessImage(String loc) {imgLoc = loc;}
    //Returns the image location for a listed item
    public String getImgLoc() { return imgLoc;}

}
