package com.github.gustavofernandes.gameengine.quarto;

import com.github.gustavofernandes.gameengine.common.Board;

public class QuartoBoard implements Board {

    byte[][] grid;

    public QuartoBoard() {
        this.grid = new byte[4][4];

        // initialize bytes to 16
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.grid[i][j] = 0b0001_0000;
            }
        }
    }
}
