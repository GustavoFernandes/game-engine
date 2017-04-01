package com.github.gustavofernandes.gameengine.quarto;

public class QuartoSelectMove implements QuartoMove {

    private Quarto quarto;
    private byte piece;

    public QuartoSelectMove(Quarto quarto) {
        this.quarto = quarto;
    }

    public boolean isPieceAvailable(byte b) {
        return false;
    }

    public byte getPiece() {
        return this.piece;
    }
}
