package com.github.gustavofernandes.gameengine.quarto;

import com.github.gustavofernandes.gameengine.common.PieceUnavailableException;
import com.github.gustavofernandes.gameengine.common.Player;

import java.util.HashSet;
import java.util.Set;

public class Quarto implements QuartoGame {

    private QuartoBoard board;
    private Set<Byte> availablePieces;

    private Player currentPlayer;

    public Quarto() {
        this.board = new QuartoBoard();
        this.availablePieces = new HashSet<>();
        for (byte i = 0; i < 16; i++) {
            this.availablePieces.add(i);
        }
    }

    public boolean isPieceAvailable(byte b) {
        return this.availablePieces.contains(b);
    }

    public void move(Player player, QuartoMove move) throws PieceUnavailableException {

    }

    @Override
    public void placePiece(byte piece, int row, int column) {

    }

    @Override
    public void selectPieceForOpponent() {

    }
}
