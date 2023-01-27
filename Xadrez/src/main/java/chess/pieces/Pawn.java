package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private boolean firstMove;
    
    public Pawn(Board board, Color color) {
        super(color, board);
        firstMove = true;
    }
    
    @Override
    public String toString() {
        return "P";
    }
    
    @Override
    public boolean[][] possibleMoves() {
        //PAWN CAN ONLY MOVE FOWARD IF FRONT SPACE IS EMPTY
        // CAN MOVE DIAGONALLY IF ENEMY PIECE IS PRESENT
        
        
        boolean[][] moves = new boolean[8][8];
        for (int i=0; i<moves.length;i++) {
            for (int j=0; j<moves.length; j++) {
                moves[i][j] = false;
            }
        }
        
        int i = position.getRow();
        int j = position.getColumn();
        int movementDirection;
        
        if (this.getColor() == Color.BLACK) movementDirection = 1;
        else movementDirection = -1;
            
        //CHECK IF THERES A PIECE ON THE POSITION FRONT RIGHT
        if (board.positionExists(new Position(i+movementDirection, j+1))) {
            if (this.board.thereIsAPiece(new Position(i+movementDirection, j+1))) {
            //CHECK THE COLOR OF PIECE
                ChessPiece p = (ChessPiece) this.board.piece(i+movementDirection, j+1);
                if (p.getColor()!=this.getColor()) moves[i+movementDirection][j+1] = true;
            } 
        }

        //CHECK IF THERES A PIECE ON THE POSITION FRONT LEFT
        if (board.positionExists(new Position(i+movementDirection, j-1))) {
            if (this.board.thereIsAPiece(new Position(i+movementDirection, j-1))) {
                //CHECK THE COLOR OF PIECE
                ChessPiece p = (ChessPiece) this.board.piece(i+movementDirection, j-1);
                if (p.getColor()!=this.getColor()) moves[i+movementDirection][j-1] = true;
            } 
        }

        //CHECK IF THERES A PIECE ON THE POSITION FRONT
        if (!this.board.thereIsAPiece(new Position(i+movementDirection, j))) {
            moves[i+movementDirection][j] = true;
            if (!this.board.thereIsAPiece(new Position(i+movementDirection+movementDirection, j)) && this.firstMove) {
                moves[i+movementDirection+movementDirection][j] = true;
            }
        } 
        
        
        return moves;
    }
    
    public void setFirstMove() {
        this.firstMove = false;
    }
    
}
