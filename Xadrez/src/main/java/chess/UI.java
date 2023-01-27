package chess;

public class UI {
    
    //TEXT COLORS
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    //BACKGROUND COLORS
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    public static void printBoard(ChessPiece[][] pieces) {
        
        System.out.println("");
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        for (int i=0; i<pieces.length; i++) {
            System.out.println("");
            for (int j=0;j<pieces[0].length;j++) {
                if (j==0) System.out.print((8-i)+" ");
                if (pieces[i][j] == null) System.out.print("- ");
                else printPiece(pieces[i][j]);
            }
        }
        System.out.println("");
        for (int i=0; i<letters.length;i++) {
            if (i==0) System.out.print("  ");
            System.out.print(letters[i]+" ");
        }
        System.out.println("");
    }
    
    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        
        System.out.println("");
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        for (int i=0; i<pieces.length; i++) {
            System.out.println("");
            for (int j=0;j<pieces[0].length;j++) {
                
                if (j==0) System.out.print((8-i)+" ");
                if (possibleMoves[i][j]) System.out.print(ANSI_BLUE_BACKGROUND);
                if (pieces[i][j] == null) System.out.print("- ");
                else printPiece(pieces[i][j]);
                if (possibleMoves[i][j]) System.out.print(ANSI_RESET);
            }
        }
        System.out.println("");
        for (int i=0; i<letters.length;i++) {
            if (i==0) System.out.print("  ");
            System.out.print(letters[i]+" ");
        }
        System.out.println("");
    }
    
    private static void printPiece(ChessPiece piece) {
        
        if(piece.getColor() == Color.WHITE) {
            System.out.print(ANSI_WHITE + piece+" "+ ANSI_RESET);
        } else {
            System.out.print(ANSI_YELLOW + piece+" "+ ANSI_RESET);
        }
        
    }
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");System.out.flush();
    }
    
    public static void printTurn(Color player) {
        if (player == Color.WHITE) {
            System.out.println("");
            System.out.println("- "+ANSI_WHITE+"PLAYER 1(WHITE)"+ANSI_RESET+" TURN -");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("- "+ANSI_YELLOW+"PLAYER 2"+"(BLACK)"+ANSI_RESET+" TURN -");
            System.out.println("");
        }
    }
    
    public static void printInstructions() {
        System.out.println("Type the piece location to make a move.\nFormat example: e2\nOr type EXIT to leave game.");
    }
    
}
