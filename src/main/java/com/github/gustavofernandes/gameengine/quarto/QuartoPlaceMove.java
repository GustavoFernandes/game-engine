package com.github.gustavofernandes.gameengine.quarto;

public class QuartoPlaceMove implements QuartoMove {

    private byte piece;
    private int row;
    private int column;

    public QuartoPlaceMove(byte piece, int row, int column) {
        this.piece = piece;
        this.row = row;
        this.column = column;
    }
}
