package chess.pieces;
import board.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    
    public King(Board board, Color color) {
        super(color, board);
    }
    
    @Override
    public String toString() {
        return "K";
    }
    
//    @Override
//    public boolean[][] possibleMoves() {
//        boolean[][] positions;
//        for (int i=0; i<board.getRows(); i++) {
//            for (int j=0; j<board.getColumns(); j++) {
//                if ()
//            }
//        }
//    }
    
}
