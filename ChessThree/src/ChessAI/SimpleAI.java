package ChessAI;

import ChessGame.GameData;
import ChessPieces.Point;

import java.util.ArrayList;

public class SimpleAI {
    //Uses Game Data and MoveList
    private GameData gameData;
    private ArrayList<MoveList> allPossibleMoves = new ArrayList<>();
    private int[] maxOutcomes;
    //Constructor
    public SimpleAI(GameData gameData){
        this.gameData = gameData;
    }
    //Reads through Game Data
    //Records moves and outcomes for each piece belonging to it
    //Records the best outcomes for each piece
    public void recordMoves(){
        String[][] data = gameData.getData();
        for (int y = 0; y <  data.length; y++) {
            for (int x = 0; x < data[y].length; x++) {
                String piece = data[y][x];
                if(piece.charAt(0)=='B'){
                    MoveList moves = new MoveList(gameData,y,x);
                    allPossibleMoves.add(moves);
                }
            }
        }
        maxOutcomes = new int[allPossibleMoves.size()];
        for (int i = 0; i < maxOutcomes.length; i++) {
            maxOutcomes[i] = allPossibleMoves.get(i).getMaxOutcome();
        }
    }
    //Reads through the list of best outcomes
    //Returns the best outcome value
    public int getBestOutcome(){
        int max = 0;
        for (int maxOutcome : maxOutcomes) {
            if (maxOutcome > max) { max = maxOutcome; }
        }
        return max;
    }
    //Records moves and outcomes
    //Finds the best outcome
    //Chooses a piece and a move of the best outcome
    //Changes data with the two positions that have been selected
    public void makeMove(){
        recordMoves();
        int max = getBestOutcome();
        ArrayList<Integer> potentialMoves = new ArrayList<>();
        for (int i = 0; i < maxOutcomes.length; i++) {
            if(maxOutcomes[i] == max){ potentialMoves.add(i);}
        }
        int randomPick = (int)(Math.random() * potentialMoves.size());
        int pick = potentialMoves.get(randomPick);
        Point piece = allPossibleMoves.get(pick).getPiece();
        Point target = allPossibleMoves.get(pick).getMaxMove();
        gameData.changeData(piece.getY(), piece.getX(), target.getY(), target.getX());
    }
}
