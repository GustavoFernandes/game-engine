package com.github.gustavofernandes.gameengine.common;

import com.github.gustavofernandes.gameengine.tictactoe.TicTacToe;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AgentTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void regularCircularListTest() {
        RandomAgent randomAgent = null;

        TicTacToe game = new TicTacToe(randomAgent, randomAgent);

        randomAgent = new RandomAgent(game);

        game.start();
    }
}
