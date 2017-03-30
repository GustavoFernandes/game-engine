package com.github.gustavofernandes.gameengine.tictactoe;

import com.github.gustavofernandes.gameengine.common.Team;

public enum TicTacToePiece implements Team {
    X('x'),
    O('o'),
    s(' ');

    private char c;

    TicTacToePiece(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return Character.toString(this.c);
    }
}
