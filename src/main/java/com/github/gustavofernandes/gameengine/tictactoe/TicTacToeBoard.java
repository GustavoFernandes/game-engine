package com.github.gustavofernandes.gameengine.tictactoe;

import com.github.gustavofernandes.gameengine.common.Board;
import com.github.gustavofernandes.gameengine.common.PlaceOccupiedException;

public class TicTacToeBoard implements Board {

    protected TicTacToePiece[][] grid;

    public TicTacToeBoard() {
        this.grid = new TicTacToePiece[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.grid[i][j] = TicTacToePiece.s;
            }
        }
    }

    public boolean isPlaceOccupied(int row, int column) {
        return this.grid[row][column] != TicTacToePiece.s;
    }

    public void place(TicTacToePiece piece, int row, int column) throws PlaceOccupiedException {
        if (this.isPlaceOccupied(row, column)) throw new PlaceOccupiedException();

        this.grid[row][column] = piece;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s += this.grid[i][j];
            }
            s += '\n';
        }
        return s;
    }
}
