package com.mycompany.xadrez;
import chess.*;
import board.*;

public class Xadrez {

    public static void main(String[] args) {
        
        ChessMatch match = new ChessMatch();
        match.initialSetup();
        UI.printBoard(match.getPieces());
        
        match.performChessMove(
                new ChessPosition('e', 2), 
                new ChessPosition('d', 4));
        
        UI.printBoard(match.getPieces());
        
        UI.printBoard(match.getPieces(), match.possibleMoves(new ChessPosition('d', 2)));
        
    }
}
