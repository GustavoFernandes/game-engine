package com.github.gustavofernandes.gameengine.quarto;

import com.github.gustavofernandes.gameengine.common.Win;
import com.github.gustavofernandes.gameengine.common.WinLocation;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuartoWinCheckerTest {

    private static byte[][] gridRowWin = {
            {0b0001, 0b0011, 0b0111, 0b1111},
            {0b1110, 0b1100, 0b1000, 0b0001},
            {0b0000, 0b1111, 0b0010, 0b0000},
            {0b0000, 0b1111, 0b0000, 0b0000}
    };

    private static byte[][] gridColumnWin = {
            {0b1111, 0b0000, 0b0001, 0b1110},
            {0b0000, 0b0000, 0b0011, 0b1100},
            {0b0000, 0b1111, 0b0111, 0b1000},
            {0b0000, 0b0000, 0b1111, 0b0001}
    };

    private static byte[][] gridDiagonalWin = {
            {0b0001, 0b1110, 0b0000, 0b0000},
            {0b1110, 0b0011, 0b1100, 0b0000},
            {0b0000, 0b1100, 0b0111, 0b1000},
            {0b0011, 0b0000, 0b1000, 0b1111}
    };

    private static byte[][] gridAntidiagonalWin = {
            {0b0000, 0b0000, 0b1110, 0b0001},
            {0b0000, 0b1100, 0b0011, 0b1110},
            {0b1000, 0b0111, 0b1100, 0b0000},
            {0b1111, 0b1000, 0b0000, 0b0011}
    };

    private static byte[][] gridDraw = {
            {0b0000, 0b0001, 0b1100, 0b0110}, // {0, 1, 12, 6}
            {0b1110, 0b0011, 0b0101, 0b1000}, // {14, 3, 5, 8}
            {0b1101, 0b1010, 0b1011, 0b0111}, // {13, 10, 11, 7}
            {0b1001, 0b0100, 0b0010, 0b1111}  // {9, 4, 2, 15}
    };


    @Parameters(name = "{index}: Board {0} wins {1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {gridRowWin, new Win(WinLocation.ROW, 0)},
                {gridColumnWin, new Win(WinLocation.COLUMN, 2)},
                {gridDiagonalWin, new Win(WinLocation.DIAGONAL)},
                {gridAntidiagonalWin, new Win(WinLocation.ANTIDIAGONAL)},
                {gridDraw, new Win(WinLocation.NONE)},
                {new QuartoBoard().grid, new Win(WinLocation.NONE)}
        });
    }

    @SuppressWarnings("WeakerAccess")
    @Parameter
    public byte[][] input;

    @SuppressWarnings("WeakerAccess")
    @Parameter(1)
    public Win expected;

    private static QuartoBoard board;
    private static QuartoWinChecker<QuartoBoard> winChecker;

    @BeforeClass
    public static void setup() {
        board = new QuartoBoard();
        winChecker = new QuartoWinChecker<>();
    }

    @Test
    public void testWinChecker() {
        board.grid = input;
        assertEquals(expected, winChecker.checkWin(board));
    }
}
