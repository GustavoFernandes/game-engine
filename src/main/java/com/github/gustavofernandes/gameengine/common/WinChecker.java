package com.github.gustavofernandes.gameengine.common;

public interface WinChecker<T extends Board> {
    Win checkWin(T board);
}
