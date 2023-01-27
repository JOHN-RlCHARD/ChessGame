package chess;
import board.*;
import chess.pieces.*;
import java.util.Random;
import chess.ChessPosition;

public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private Color lastPlayer;
    private boolean check, checkMate;
    private ChessPiece enPessemfVulnerable;
    private ChessPiece promoted;
    private Board board;
    
    public ChessMatch() {
        this.board = new Board(8,8);
        this.turn = 1;
        //START WITH RANDOM PLAYER
        Color[] players = {Color.WHITE, Color.BLACK};
        this.currentPlayer = players[new Random().nextInt(2)];
        this.check = false;
        this.checkMate = false;
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
    
    public void promote(String str) throws Exception {
        
        String[] strArray = str.split("");
        char column = strArray[0].charAt(0);
        int row = Integer.valueOf(strArray[1]);
        
        //CASE POSITION DOESNT EXISTS
        if (column < 'a' || column > 'h' || row < 1 || row > 8) throw new BoardException("Position does not exist.");
        
        ChessPiece p = (ChessPiece) this.board.piece(new ChessPosition(column, row).toPosition());
        
        //CASE POSITION DOESNT HAVE PIECE
        if(p==null) throw new BoardException("There is no piece on that position");
        
        //CASE PIECE FROM OTHER PLAYER
        if (p.getColor()!=this.currentPlayer) throw new ChessException("Not your piece.");
        
        //CASE NO POSSIBLE MOVE FOR PIECE
        boolean isThereAPossibleMove = false;
        boolean[][] possibleMoves = p.possibleMoves();
        for (int i=0; i<possibleMoves.length; i++) {
            for (int j=0; j<possibleMoves[0].length; j++) {
                if (possibleMoves[i][j] == true) isThereAPossibleMove = true;
            }
        }
        if (isThereAPossibleMove == false) throw new ChessException("There is no possible move for that piece.");
        
        //IF ALL CASES PASS
        this.promoted = p;
        UI.printBoard(this.getPieces(), possibleMoves);
        
    }
    
    public ChessPiece performChessMove(ChessPosition targetPosition) throws Exception {
        ChessPiece removed = null;
        if (!board.thereIsAPiece(this.promoted.getPosition())) throw new BoardException("Source position not valid.");
        
        boolean possibleMoves[][] =  this.promoted.possibleMoves();
        
        Position position = targetPosition.toPosition();
        
        if (possibleMoves[position.getRow()][position.getColumn()] == false)
            throw new ChessException("Invalid Movement");
        
        ChessPiece p = (ChessPiece)board.removePiece(this.promoted.getPosition());
        if (board.thereIsAPiece(targetPosition.toPosition())) removed = (ChessPiece) board.removePiece(targetPosition.toPosition());
        board.placePiece(p, targetPosition.toPosition());
        if (p.getClass() == Pawn.class) {
            Pawn pawn = (Pawn) p;
            pawn.setFirstMove();
        }
            
        return removed;
    }
    
    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        ChessPiece p = (ChessPiece)board.piece(sourcePosition.toPosition());
        
        return p.possibleMoves();
    }
    
    public void initialSetup() {

        //WHITES
        //ROOKS
        this.board.placePiece(
            new Rook(this.board,Color.WHITE),
            new ChessPosition('a',1).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.WHITE),
            new ChessPosition('h',1).toPosition());
        //PAWNS
        this.board.placePiece(
            new Pawn(this.board,Color.WHITE),
            new ChessPosition('a',2).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.WHITE),
            new ChessPosition('b',2).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.WHITE),
            new ChessPosition('c',2).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.WHITE),
            new ChessPosition('d',2).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.WHITE),
            new ChessPosition('e',2).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.WHITE),
            new ChessPosition('f',2).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.WHITE),
            new ChessPosition('g',2).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.WHITE),
            new ChessPosition('h',2).toPosition());
        
        this.board.placePiece(
            new King(this.board,Color.WHITE),
            new ChessPosition('d',1).toPosition());
        
        
        //BLACKS
        //ROOKS
        this.board.placePiece(
            new Rook(this.board,Color.BLACK),
            new ChessPosition('a',8).toPosition());
        this.board.placePiece(
            new Rook(this.board,Color.BLACK),
            new ChessPosition('h',8).toPosition());
        
        //PAWNS
        this.board.placePiece(
            new Pawn(this.board,Color.BLACK),
            new ChessPosition('a',7).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.BLACK),
            new ChessPosition('b',7).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.BLACK),
            new ChessPosition('c',7).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.BLACK),
            new ChessPosition('d',7).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.BLACK),
            new ChessPosition('e',7).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.BLACK),
            new ChessPosition('f',7).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.BLACK),
            new ChessPosition('g',7).toPosition());
        this.board.placePiece(
            new Pawn(this.board,Color.BLACK),
            new ChessPosition('h',7).toPosition());
        
        this.board.placePiece(
            new King(this.board,Color.BLACK),
            new ChessPosition('d',8).toPosition());
    }

    public int getTurn() {
        return turn;
    }

    public void increaseTurn() {
        this.turn++;
    }
    
    public void switchPlayer() {
        if (this.currentPlayer == Color.BLACK) this.currentPlayer = Color.WHITE;
        else this.currentPlayer = Color.BLACK;
        increaseTurn();
    }
    
    public Color getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setLastPlayer(Color lastPlayer) {
        this.lastPlayer = lastPlayer;
    }

    public Color getLastPlayer() {
        return lastPlayer;
    }
    
}
