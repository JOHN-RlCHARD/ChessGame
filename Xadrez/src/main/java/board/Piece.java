package board;

public abstract class Piece {

    protected Position position;
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
