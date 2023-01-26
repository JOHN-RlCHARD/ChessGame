package chess;
import board.Board;
import board.Piece;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int movesCount;

    public ChessPiece(Color color, Board board) {
        super(board);
        this.color = color;
        this.movesCount = 0;
    }

    public Color getColor() {
        return color;
    }
    
}
