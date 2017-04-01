package com.github.gustavofernandes.gameengine.common;

import com.github.gustavofernandes.gameengine.common.InvalidMoveException;
import com.github.gustavofernandes.gameengine.common.Player;
import com.github.gustavofernandes.gameengine.common.State;
import com.github.gustavofernandes.gameengine.tictactoe.TicTacToeMove;
import com.github.gustavofernandes.gameengine.tictactoe.TicTacToeState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsolePlayer extends Player {

    // TODO this might throw a stack overflow error
    @Override
    public void update(State state) {

        TicTacToeState ticTacToeState = (TicTacToeState) state; // TODO make generic instead of casting?

        if (this.getTeam() == ticTacToeState.getPlayer().getTeam()) {
            System.out.println("Your turn, player " + this.getTeam());
            System.out.println(ticTacToeState.getBoard().toString());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try {
                int row = Integer.parseInt(br.readLine());
                int column = Integer.parseInt(br.readLine());


                this.game.move(this, new TicTacToeMove(row, column));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
