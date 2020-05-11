package ChessAI;

import ChessGame.GameData;
import ChessGame.Rules;
import ChessPieces.Point;
import java.util.ArrayList;

public class MoveList {
    //MoveList uses GameData and Rules
    //Stores data on the position of a piece, all its moves, and possible outcomes
    private GameData gameData;
    //Piece Position
    private Point piece;
    //Moves for that piece
    private ArrayList<Point> moves;
    private int[] outcomes;
    //Constructor
    public MoveList(GameData gameData,int y, int x){
        this.piece = new Point(y,x);
        this.gameData = gameData;
        Rules rules = new Rules();
        this.moves = rules.checkMoves(gameData,y,x);
        this.outcomes = new int[moves.size()];
        checkOutcomes();
    }
    //Reads through possible moves
    //Assigns corresponding points to respective outcomes
    public void checkOutcomes(){
        String self = gameData.getData()[piece.getY()][piece.getX()];
        for (int i = 0; i < moves.size(); i++) {
            Point p = moves.get(i);
            String test = gameData.getData()[p.getY()][p.getX()];
            if(test.equals("WK")){ outcomes[i] = 100;}
            if(test.equals("WQ")){ outcomes[i] = 80;}
            if(test.equals("WR")){ outcomes[i] = 50;}
            if(test.equals("WB")){ outcomes[i] = 30;}
            if(test.equals("WN")){ outcomes[i] = 30;}
            if(test.equals("WP")){ outcomes[i] = 10;}
            if(test.equals(self)){ outcomes[i] = -1;}
        }
    }
    //Returns the position of a piece
    public Point getPiece() { return piece; }
    //Reads through possible outcomes
    //Returns the best outcome
    public int getMaxOutcome(){
        int max = -100;
        for (int outcome : outcomes) {
            if (outcome > max) { max = outcome; }
        }
        return max;
    }
    //Records the move(s) of the best outcome
    //Returns the target position of the/a best outcome
    public Point getMaxMove() {
        int max = getMaxOutcome();
        ArrayList<Integer>maxMove = new ArrayList<>();
        for (int i = 0; i < outcomes.length; i++) {
            if (outcomes[i]==max){ maxMove.add(i);};
        }
        int randomPick = (int)(Math.random() * maxMove.size());
        int pick = maxMove.get(randomPick);
        return moves.get(pick);
    }
}
