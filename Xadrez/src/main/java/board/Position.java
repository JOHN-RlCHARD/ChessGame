package board;

public class Position {

    private int row, column;
    
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public void setValues(int row, int column) {
        setRow(row);
        setColumn(column);
    }
    
    @Override
    public String toString() {
        return "row: "+getRow()+"\ncolumn: "+getColumn();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
    
    
}