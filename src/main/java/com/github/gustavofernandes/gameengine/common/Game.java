package com.github.gustavofernandes.gameengine.common;

import java.util.Observable;

public abstract class Game<T extends Move, U extends State> extends Observable {

    protected U state;
//    protected List<Player> players;
    protected CircularSinglyLinkedList<Player> players;

    public Game(Player[] players) {
        this.players = new CircularSinglyLinkedList<>(players);

        for (Player player : players) {
            this.addObserver(player);
        }
    }

    public final void start() {
        System.out.println("Number of observers: " + this.countObservers());
        this.setChanged();
        this.notifyObservers(this.state);
    }

    public final void move(Player player, T move) throws Exception {
        U state = this.doMove(player, move);
        this.setChanged();
        this.notifyObservers(this.state);
    }

    // TODO might be unnecessary
    protected abstract void setup();

    protected abstract U doMove(Player player, T move) throws Exception;

    // public void reset() {} // TODO idea: State has Board which can be reset
}
