package com.mycompany.xadrez;
import chess.*;
import board.*;
import java.util.*;
import chess.ChessPiece;

public class Xadrez {

    public static void main(String[] args) {
        
//        ChessMatch match = new ChessMatch();
//        match.initialSetup();
//        UI.printBoard(match.getPieces());
//        
//        match.performChessMove(
//                new ChessPosition('e', 2), 
//                new ChessPosition('d', 4));
//        
//        UI.printBoard(match.getPieces());
//        
//        UI.printBoard(match.getPieces(), match.possibleMoves(new ChessPosition('d', 2)));

        System.out.println("");
        System.out.println("**************************************");
        System.out.println("*** WELCOME TO THE JAVA CHESS GAME ***");
        System.out.println("");
        System.out.println("        Press [ENTER] to Start.");
        System.out.println("");
        System.out.println("**************************************");
        System.out.println("");

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        sc.nextLine();
        
        ChessMatch match = new ChessMatch();
        match.initialSetup();
        
        boolean resume = true;
        String str;
        
        while(resume) {
            UI.printBoard(match.getPieces());
            UI.printTurn(match.getCurrentPlayer());
            UI.printInstructions();
            str = sc.next();
            if(!str.equals("EXIT")) {
                try {
                match.promote(str);
                    boolean done = false;
                    do {
                        System.out.println("\nType position to perform move or CANCEL to cancel: ");
                        str = sc.next();
                        
                        if (! str.equals("CANCEL")) {
                            try {
                                String[] strArray = str.split("");
                                char column2 = strArray[0].charAt(0);
                                int row2 = Integer.valueOf(strArray[1]);
                                
                                ChessPiece removed = match.performChessMove(new ChessPosition(column2, row2));
                                
                                //LOGIC TO PLAY AGAIN IF A ENEMY PIECE IS REMOVED, BUT ONLY ONCE
                                if (removed == null) {
                                    match.setLastPlayer(match.getCurrentPlayer());
                                    match.switchPlayer();
                                } else {
                                    if (match.getLastPlayer() == match.getCurrentPlayer()) {
                                        match.switchPlayer();
                                    } else {
                                        match.setLastPlayer(match.getCurrentPlayer());
                                    }
                                }
                                done = true;
                                
                            } catch (Exception e) {System.out.println(e);}
                        } else done = true;
                        
                    } while (done ==false);
                } catch (Exception e) {System.out.println(e);}
            } else resume = false;
        }

    }
}
