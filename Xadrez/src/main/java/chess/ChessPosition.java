package chess;
import board.*;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        this.column = column;
        this.row = row;
    }
    
    protected Position toPosition() {
        return new Position(8-row, column - 'a');
    }
    
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char) ('a' -position.getColumn()), 8 -position.getRow());
    }
    
}
