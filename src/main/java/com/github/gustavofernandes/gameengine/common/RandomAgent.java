package com.github.gustavofernandes.gameengine.common;

import com.github.gustavofernandes.gameengine.tictactoe.TicTacToeState;

public class RandomAgent extends Agent {

    private Game game;

    public RandomAgent(Game game) {
        this.game = game;
    }

    @Override
    public void update(State state) {
        TicTacToeState s = (TicTacToeState) state;

        if (this.getTeam() == s.getPlayer().getTeam()) {

        }
    }

}
