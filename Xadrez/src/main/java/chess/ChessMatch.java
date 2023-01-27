package chess;
import board.*;
import chess.pieces.*;

public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private boolean check, checkMate;
    private ChessPiece enPessemfVulnerable;
    private ChessPiece promoted;
    private Board board;
    
    public ChessMatch() {
        this.board = new Board(8,8);
    }
    
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat  = new ChessPiece[board.getRows()][board.getColumns()];
        
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        
        return mat;
        
    }
    
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        ChessPiece p = null;
        if (board.thereIsAPiece(sourcePosition.toPosition())) {
            p = (ChessPiece)board.removePiece(sourcePosition.toPosition());
            board.placePiece(p, targetPosition.toPosition());
        }
        return p;
    }
    
    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        ChessPiece p = (ChessPiece)board.piece(sourcePosition.toPosition());
        
        return p.possibleMoves();
    }
    
    public void initialSetup() {

        //WHITES
        this.board.placePiece(
            new Rook(this.board,Color.WHITE),
            new ChessPosition('c',1).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.WHITE),
            new ChessPosition('c',2).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.WHITE),
            new ChessPosition('d',2).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.WHITE),
            new ChessPosition('e',2).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.WHITE),
            new ChessPosition('e',1).toPosition());  
        this.board.placePiece(
            new King(this.board,Color.WHITE),
            new ChessPosition('d',1).toPosition());
        
        //BLACKS
        this.board.placePiece(
            new Rook(this.board,Color.BLACK),
            new ChessPosition('c',7).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.BLACK),
            new ChessPosition('c',8).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.BLACK),
            new ChessPosition('d',7).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.BLACK),
            new ChessPosition('e',7).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.BLACK),
            new ChessPosition('e',8).toPosition());
        this.board.placePiece(
            new King(this.board,Color.BLACK),
            new ChessPosition('d',8).toPosition());
    }
    
}
