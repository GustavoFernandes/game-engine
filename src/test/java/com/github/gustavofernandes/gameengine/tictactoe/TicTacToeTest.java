package com.github.gustavofernandes.gameengine.tictactoe;

import com.github.gustavofernandes.gameengine.common.*;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
public class TicTacToeTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ticTacToeWinTest() throws Exception {
        // xo
        // xo
        // x

        Player p1 = new Player();
        Player p2 = new Player();

        TicTacToe game = new TicTacToe(p1, p2);

        game.move(p1, new TicTacToeMove(0, 0));
        game.move(p2, new TicTacToeMove(0, 1));
        game.move(p1, new TicTacToeMove(1, 0));
        game.move(p2, new TicTacToeMove(1, 1));
        game.move(p1, new TicTacToeMove(2, 0));

        TicTacToeWinChecker winChecker = new TicTacToeWinChecker();
        Win win = winChecker.checkWin(game.getBoard());
        assertEquals(new Win(WinLocation.COLUMN, 0), win);
    }

    @Test
    public void ticTacToeNoWinTest() throws Exception {
        // xo
        // o x
        //  x

        Player<TicTacToePiece> p1 = new Player<>();
        Player<TicTacToePiece> p2 = new Player<>();

        TicTacToe game = new TicTacToe(p1, p2);

        game.move(p1, new TicTacToeMove(0, 0));
        game.move(p2, new TicTacToeMove(0, 1));
        game.move(p1, new TicTacToeMove(1, 2));
        game.move(p2, new TicTacToeMove(1, 0));
        game.move(p1, new TicTacToeMove(2, 1));

        TicTacToeWinChecker winChecker = new TicTacToeWinChecker();
        Win win = winChecker.checkWin(game.getBoard());
        assertEquals(new Win(WinLocation.NONE), win);
    }

    @Test
    public void invalidMoveTest() throws Exception {
        Player p1 = new Player();
        Player p2 = new Player();

        TicTacToe ticTacToe = new TicTacToe(p1, p2);
        TicTacToeMove move = new TicTacToeMove(0, 0);

        ticTacToe.move(p1, move);
        assertFalse(ticTacToe.isValidMove(move));
    }

    @Test
    public void catchInvalidMoveTest() throws Exception {
        this.thrown.expect(InvalidMoveException.class);

        TicTacToeMove move = new TicTacToeMove(-1, 3);
    }

    @Test
    public void catchOutOfTurnTest() throws Exception {
        thrown.expect(OutOfTurnException.class);

        Player p1 = new Player();
        Player p2 = new Player();

        TicTacToe game = new TicTacToe(p1, p2);
        game.move(p1, new TicTacToeMove(0, 0));
        game.move(p1, new TicTacToeMove(0,1));

    }

    @Test
    public void placeOccupiedTest() throws PlaceOccupiedException {
        TicTacToeBoard board = new TicTacToeBoard();
        assertFalse(board.isPlaceOccupied(0, 0));
        board.place(TicTacToePiece.X, 0, 0);
        assertTrue(board.isPlaceOccupied(0, 0));
    }

    @Test
    public void catchPlaceOccupiedTest() throws Exception {
        thrown.expect(PlaceOccupiedException.class);

        Player p1 = new Player();
        Player p2 = new Player();

        TicTacToe game = new TicTacToe(p1, p2);
        game.move(p1, new TicTacToeMove(0, 0));
        game.move(p2, new TicTacToeMove(0, 0));
    }
}
