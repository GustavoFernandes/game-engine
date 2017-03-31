package com.github.gustavofernandes.gameengine.tictactoe;

import com.github.gustavofernandes.gameengine.common.Win;
import com.github.gustavofernandes.gameengine.common.WinChecker;
import com.github.gustavofernandes.gameengine.common.WinLocation;

import static com.github.gustavofernandes.gameengine.tictactoe.TicTacToePiece.X;
import static com.github.gustavofernandes.gameengine.tictactoe.TicTacToePiece.s;

public class TicTacToeWinChecker implements WinChecker<TicTacToeBoard> {

    @Override
    public Win checkWin(TicTacToeBoard board) {

        // TODO clean up this code

        Win win = checkRows(board);
        if (win != null) return win;

        win = checkColumns(board);
        if (win != null) return win;

        win = checkDiagonal(board);
        if (win != null) return win;

        win = checkAntidiagonal(board);
        if (win != null) return win;

        return new Win(WinLocation.NONE);
    }

    private Win checkRows(TicTacToeBoard board) {
        int rowSum;
        for (int r = 0; r < 3; r++) {
            rowSum = 0;
            for (int c = 0; c < 3; c++) {
                if (board.grid[r][c] == s) break;
                rowSum += board.grid[r][c] == X ? 1 : -1;
            }

            if (rowSum == 3 || rowSum == -3) {
                return new Win(WinLocation.ROW, r);
            }
        }

        return null;
    }

    private Win checkColumns(TicTacToeBoard board) {
        int columnSum;
        for (int c = 0; c < 3; c++) {
            columnSum = 0;
            for (int r = 0; r < 3; r++) {
                if (board.grid[r][c] == s) break;
                columnSum += board.grid[r][c] == X ? 1 : -1;
            }

            if (columnSum == 3 || columnSum == -3) {
                return new Win(WinLocation.COLUMN, c);
            }
        }

        return null;
    }

    private Win checkDiagonal(TicTacToeBoard board) {
        int diagonalSum = 0;
        for (int i = 0; i < 3; i++) {
            if (board.grid[i][i] == s) return null;
            diagonalSum += board.grid[i][i] == X ? 1 : -1;
        }

        if (diagonalSum == 3 || diagonalSum == -3) {
            return new Win(WinLocation.DIAGONAL);
        }

        return null;
    }

    private Win checkAntidiagonal(TicTacToeBoard board) {
        int antidiagonalSum = 0;
        for (int i = 0; i < 3; i++) {
            if (board.grid[i][2 - i] == s) return null;
            antidiagonalSum += board.grid[i][2-i] == X ? 1 : -1;
        }

        if (antidiagonalSum == 3 || antidiagonalSum == -3) {
            return new Win(WinLocation.ANTIDIAGONAL);
        }

        return null;
    }
}
