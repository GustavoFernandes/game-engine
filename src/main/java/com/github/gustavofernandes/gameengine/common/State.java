package com.github.gustavofernandes.gameengine.common;

public abstract class State<T extends Board> {

    private Player player;
    private T board;

    public State(Player player, T board) {
        this.player = player;
        this.board = board;
    }

    public Player getPlayer() {
        return this.player;
    }

    public T getBoard() {
        return this.board;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBoard(T board) {
        this.board = board;
    }
}
