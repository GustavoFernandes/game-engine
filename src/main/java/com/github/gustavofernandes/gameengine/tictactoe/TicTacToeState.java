package com.github.gustavofernandes.gameengine.tictactoe;

import com.github.gustavofernandes.gameengine.common.Player;
import com.github.gustavofernandes.gameengine.common.State;

public class TicTacToeState extends State<TicTacToeBoard> {

    TicTacToeState(Player player, TicTacToeBoard board) {
        super(player, board);
    }
}
