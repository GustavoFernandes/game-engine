package com.github.gustavofernandes.gameengine.tictactoe;

import com.github.gustavofernandes.gameengine.common.InvalidMoveException;
import com.github.gustavofernandes.gameengine.common.Move;

public class TicTacToeMove implements Move {

    private int row;
    private int column;

    public TicTacToeMove(int row, int column) throws InvalidMoveException {
        // TODO invalid move exception is ambiguous with TicTacToe.isValidMove, maybe rename to something like "malformed"?
        if (row < 0 || row > 2 || column < 0 || column > 2) throw new InvalidMoveException();

        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
