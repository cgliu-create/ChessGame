package ChessGame;

public class GameData {
    //2D Array that represents the pieces on a board
    //W = white, B = Black
    //P = pawn, R = rook, N = Knight, B = Bishop, Q = queen. K = king
    //XX = empty
    private String[][] data;
    //Sets Game Data to default setup
    public void resetData(){
        data = new String[][]{
                {"BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR"},
                {"BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP"},
                {"XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX"},
                {"XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX"},
                {"XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX"},
                {"XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX"},
                {"WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP"},
                {"WR", "WN", "WB", "WQ", "WK", "WB", "WN", "WR"}
        };
    }
    //Constructor
    public GameData(){
        resetData();
    }
    //Enter the position of a piece and its target position
    //Changes the data to reflect a piece move
    //The original position is changed to "empty"
    //The target position is changed to the selected piece
    public void changeData(int ya, int xa, int yb, int xb){
        String temp = data[ya][xa];
        data[ya][xa] = "XX";
        data[yb][xb] = temp;
    }
    //Returns the data of the board
    //Gives access to the game data
    public String[][] getData(){
        return data;
    }
}
