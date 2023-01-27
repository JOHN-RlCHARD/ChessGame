package chess.pieces;
import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(color, board);
    }
    
    @Override
    public String toString() {
        return "R";
    }
    
    @Override
    public boolean[][] possibleMoves() {
        //ROOK MOVES IN A STRAIGTH LINE IN ALL 4 DIRECTIONS, UNTIL REACHES AN ENEMY
        boolean[][] moves = new boolean [board.getRows()][board.getColumns()];
        
        //FILLING THE BOOLEAN MATRIX WITH FALSES
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                moves[i][j] = false;
            }
        }
        
        //NOW REPLACING WITH DE TRUES
        //UP
        boolean pieceReached = false;
        int i = this.position.getRow();
        int j = this.position.getColumn();
        while (pieceReached == false && i != 0) {
            i--;
            if (this.board.thereIsAPiece(new Position(i, j))) {
                pieceReached = true;
                ChessPiece p = (ChessPiece) this.board.piece(i, j);
                if (p.getColor()!=this.getColor()) moves[i][j] = true;
            } else moves[i][j] = true;
        }
        
        //DOWN
        pieceReached = false;
        i = this.position.getRow();
        j = this.position.getColumn();
        while (pieceReached == false && i != 7) {
            i++;
            if (this.board.thereIsAPiece(new Position(i, j))) {
                pieceReached = true;
                ChessPiece p = (ChessPiece) this.board.piece(i, j);
                if (p.getColor()!=this.getColor()) moves[i][j] = true;
            } else moves[i][j] = true;
        }
        
        //LEFT
        pieceReached = false;
        i = this.position.getRow();
        j = this.position.getColumn();
        while (pieceReached == false && j != 0) {
            j--;
            if (this.board.thereIsAPiece(new Position(i, j))) {
                pieceReached = true;
                ChessPiece p = (ChessPiece) this.board.piece(i, j);
                if (p.getColor()!=this.getColor()) moves[i][j] = true;
            } else moves[i][j] = true;
        }
        
        //RIGHT
        pieceReached = false;
        i = this.position.getRow();
        j = this.position.getColumn();
        while (pieceReached == false && j != 7) {
            j++;
            if (this.board.thereIsAPiece(new Position(i, j))) {
                pieceReached = true;
                ChessPiece p = (ChessPiece) this.board.piece(i, j);
                if (p.getColor()!=this.getColor()) moves[i][j] = true;
            } else moves[i][j] = true;
        }
        
        return moves;
    }
    
}
