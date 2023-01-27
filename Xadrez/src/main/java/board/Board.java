package board;
import chess.*;

public class Board {

    private int rows;
    private int columns;
    //private char[][] board;
    protected Piece[][] pieces;
    
    public Board(int rows, int columns) {
        
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
        
    }
    
    public Piece piece(int row, int column){
        return pieces[row][column];
    }
    
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }
    
    public void placePiece(ChessPiece piece, Position position) {
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.setPosition(position);
    }

    public boolean positionExists(Position position) {
        if (
            position.getRow() < 0 ||
            position.getRow() > getRows() ||
            position.getColumn() < 0 ||
            position.getColumn() > getColumns()
            ) return false;
        return true;
    }
    
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) return false;
        if (piece(position)==null) return false;
        return true;
    }
    
    public Piece removePiece(Position position) {
        Piece p = null;
        if (thereIsAPiece(position)) {
            p = pieces[position.getRow()][position.getColumn()];
            pieces[position.getRow()][position.getColumn()] = null;
        }
        return p;
    }
    
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    
}
