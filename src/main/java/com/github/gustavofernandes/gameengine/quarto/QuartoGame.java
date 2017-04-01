package com.github.gustavofernandes.gameengine.quarto;

public interface QuartoGame { //} extends Game {

    void placePiece(byte piece, int row, int column);

    void selectPieceForOpponent();
}
