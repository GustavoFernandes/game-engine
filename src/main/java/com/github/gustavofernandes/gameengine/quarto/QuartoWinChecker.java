package com.github.gustavofernandes.gameengine.quarto;

import com.github.gustavofernandes.gameengine.common.Win;
import com.github.gustavofernandes.gameengine.common.WinChecker;
import com.github.gustavofernandes.gameengine.common.WinLocation;

public class QuartoWinChecker<T extends QuartoBoard> implements WinChecker<T> {

    /*
    Checks win by taking 4 bytes such as:
    0b0001, 0b0011, 0b0111, 0b1111
    Using and and or bitwise operators to get:
    and: 0b0001
    or:  0b1111
    Then looks for matching bits (rightmost one in this case)
     */

    @Override
    public Win checkWin(QuartoBoard board) {
        // TODO: clean this up with Functions/Java 8/Streams/etc

//        byte[][] grid = board.getBoard();
        byte[][] grid = new byte[4][4];

        Win win = checkRows(grid);
        if (win != null) return win;

        win = checkColumns(grid);
        if (win != null) return win;

        win = checkDiagonal(grid);
        if (win != null) return win;

        win = checkAntidiagonal(grid);
        if (win != null) return win;

        return new Win(WinLocation.NONE);
    }

    private Win checkRows(byte[][] grid) {
        byte ands, ors;
        for (int r = 0; r < 4; r++) {
            ands = ors = grid[r][0];
            for (int c = 1; c < 4; c++) {
                ands &= grid[r][c];
                ors |= grid[r][c];
            }

            if (checkAndsOrs(ands, ors)) {
                return new Win(WinLocation.ROW, r);
            }
        }

        return null;
    }

    private Win checkColumns(byte[][] grid) {
        byte ands, ors;
        for (int c = 0; c < 4; c++) {
            ands = ors = grid[0][c];
            for (int r = 1; r < 4; r++) {
                ands &= grid[r][c];
                ors |= grid[r][c];
            }

            if (checkAndsOrs(ands, ors)) {
                return new Win(WinLocation.COLUMN, c);
            }
        }

        return null;
    }

    private Win checkDiagonal(byte[][] grid) {
        byte ands, ors;
        ands = ors = grid[0][0];
        for (int i = 1; i < 4; i++) {
            ands &= grid[i][i];
            ors |= grid[i][i];
        }

        if (checkAndsOrs(ands, ors)) {
            return new Win(WinLocation.DIAGONAL);
        }

        return null;
    }

    private Win checkAntidiagonal(byte[][] grid) {
        byte ands, ors;
        ands = ors = grid[3][0];
        for (int i = 1; i < 4; i++) {
            ands &= grid[3-i][i];
            ors |= grid[3-i][i];
        }

        if (checkAndsOrs(ands, ors)) {
            return new Win(WinLocation.ANTIDIAGONAL);
        }

        return null;
    }

    private boolean checkAndsOrs(byte ands, byte ors) {
        if (ors >= 16) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (((ands >> i) & 1) == ((ors >> i) & 1)) {
                return true;
            }
        }

        return false;
    }
}
