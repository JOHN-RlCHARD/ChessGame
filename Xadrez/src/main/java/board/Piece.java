package board;

public abstract class Piece {

    protected Position position = null;
    protected Board board;
    
    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    protected Board getBoard() {
        return board;
    }
    
    public abstract boolean[][] possibleMoves();
    
//    public abstract boolean possibleMove(Position position);
//    
//    public abstract boolean isThereAnyPossibleMove();
    
}
