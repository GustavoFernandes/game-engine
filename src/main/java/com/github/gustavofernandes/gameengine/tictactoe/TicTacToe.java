package com.github.gustavofernandes.gameengine.tictactoe;

import com.github.gustavofernandes.gameengine.common.Game;
import com.github.gustavofernandes.gameengine.common.OutOfTurnException;
import com.github.gustavofernandes.gameengine.common.PlaceOccupiedException;
import com.github.gustavofernandes.gameengine.common.Player;

public class TicTacToe extends Game<TicTacToeMove, TicTacToeState> {

    public TicTacToe(Player p1, Player p2) {
        // TODO see about abstracting this logic

        super(new Player[] {p1, p2});

        this.state = new TicTacToeState(this.players.next(), new TicTacToeBoard());

        p1.setTeam(TicTacToePiece.X);
        p2.setTeam(TicTacToePiece.O);
    }

    public boolean isValidMove(TicTacToeMove move) {
        return !this.state.getBoard().isPlaceOccupied(move.getRow(), move.getColumn());
    }

    @Override
    protected void setup() {
        // no additional setup required
    }

    @Override
    protected TicTacToeState doMove(Player player, TicTacToeMove move) throws PlaceOccupiedException, OutOfTurnException {

        // TODO maybe move this to a TurnBasedGame parent class?
        if (this.state.getPlayer() != player) {
           throw new OutOfTurnException();
        }

        TicTacToePiece piece = (TicTacToePiece) player.getTeam(); // TODO any way to avoid cast?

        this.state.getBoard().place(piece, move.getRow(), move.getColumn());
        this.state.setPlayer(this.players.next());

        return this.state;
    }

    public TicTacToeBoard getBoard() {
        // TODO abstract this
        return this.state.getBoard();
    }
}
