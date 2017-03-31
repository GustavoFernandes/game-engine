package com.github.gustavofernandes.gameengine.tictactoe;

import com.github.gustavofernandes.gameengine.common.Win;
import com.github.gustavofernandes.gameengine.common.WinLocation;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.github.gustavofernandes.gameengine.tictactoe.TicTacToePiece.O;
import static com.github.gustavofernandes.gameengine.tictactoe.TicTacToePiece.X;
import static com.github.gustavofernandes.gameengine.tictactoe.TicTacToePiece.s;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TicTacToeWinCheckerTest {

    private static TicTacToePiece[][] rowWin = {
            {O, s, X},
            {s, O, O},
            {X, X, X}
    };

    private static TicTacToePiece[][] columnWin = {
            {O, s, X},
            {O, X, s},
            {O, X, O}
    };

    private static TicTacToePiece[][] diagonalWin = {
            {X, O, X},
            {O, X, s},
            {O, s, X}
    };

    private static TicTacToePiece[][] antidiagonalWin = {
            {O, X, O},
            {s, O, X},
            {O, s, X}
    };

    private static TicTacToePiece[][] draw = {
            {X, O, X},
            {O, O, X},
            {X, X, O}
    };

    @Parameters(name = "{index}: Board {0} wins {1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {rowWin, new Win(WinLocation.ROW, 2)},
                {columnWin, new Win(WinLocation.COLUMN, 0)},
                {diagonalWin, new Win(WinLocation.DIAGONAL)},
                {antidiagonalWin, new Win(WinLocation.ANTIDIAGONAL)},
                {draw, new Win(WinLocation.NONE)},
                {new TicTacToeBoard().grid, new Win(WinLocation.NONE)}
        });
    }

    @SuppressWarnings("WeakerAccess")
    @Parameter
    public TicTacToePiece[][] input;

    @SuppressWarnings("WeakerAccess")
    @Parameter(1)
    public Win expected;

    private static TicTacToeBoard board;
    private static TicTacToeWinChecker winChecker;

    @BeforeClass
    public static void setup() {
        board = new TicTacToeBoard();
        winChecker = new TicTacToeWinChecker();
    }

    @Test
    public void testWinChecker() {
        board.grid = input;
        System.out.println(expected);
        System.out.println(board);
        assertEquals(expected, winChecker.checkWin(board));
    }
}
