package com.mycompany.xadrez;
import chess.*;
import board.*;

public class Xadrez {

    public static void main(String[] args) {
        
        ChessMatch match = new ChessMatch();
        match.initialSetup();
        UI.printBoard(match.getPieces());
        
        match.performChessMove(
                new ChessPosition('c', 8), 
                new ChessPosition('c', 2));
        
        UI.printBoard(match.getPieces());
        
        match.possibleMoves(new ChessPosition('d', 1));
        
    }
}
