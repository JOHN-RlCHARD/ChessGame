package chess.pieces;
import board.*;
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
    
    @Override
    public boolean[][] possibleMoves() {
        //KING MOVES ONLY ONE STEP IN EVERY DIRECTION
        boolean[][] moves = new boolean[8][8];
        for (int i=0; i<moves.length;i++) {
            for (int j=0; j<moves.length; j++) {
                //CHECK IF POSITION IS ON THE SCOPE OF KING MOVES
                if ((i == position.getRow()+1 && j == position.getColumn())   ||
                    (i == position.getRow()-1 && j == position.getColumn())   ||
                    (i == position.getRow() && j == position.getColumn()+1)   ||
                    (i == position.getRow() && j == position.getColumn()-1)   ||
                    (i == position.getRow()+1 && j == position.getColumn()+1) ||
                    (i == position.getRow()+1 && j == position.getColumn()-1) ||
                    (i == position.getRow()-1 && j == position.getColumn()+1) ||
                    (i == position.getRow()-1 && j == position.getColumn()-1)){
                    //CHECK IF THERES A PIECE ON THE POSITION
                    if (this.board.thereIsAPiece(new Position(i, j))) {
                        //CHECK THE COLOR OF PIECE
                        ChessPiece p = (ChessPiece) this.board.piece(i, j);
                        if (p.getColor()!=this.getColor()) moves[i][j] = true;
                        else moves[i][j] = false;
                    } else moves[i][j] = true;
                } else moves[i][j] = false;
            }
        }
        return moves;
    }
    
}
