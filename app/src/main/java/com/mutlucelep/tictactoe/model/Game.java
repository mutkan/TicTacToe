package com.mutlucelep.tictactoe.model;

import android.arch.lifecycle.MutableLiveData;

import static com.mutlucelep.tictactoe.utility.StringUtility.isNullOrEmpty;

public class Game {
    private static final String TAG = Game.class.getSimpleName();
    private static final int BOARD_SIZE = 3;

    public Player mPlayer1, mPlayer2, mCurrentPlayer;
    public Cell[][] mCells;

    public MutableLiveData<Player> mWinner = new MutableLiveData<>();

    public Game(String player1, String player2) {
        mCells = new Cell[BOARD_SIZE][BOARD_SIZE];
        mPlayer1 = new Player(player1, "x");
        mPlayer2 = new Player(player2, "o");
        mCurrentPlayer = mPlayer1;
    }

    public boolean hasGameEnded() {
        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()) {
            mWinner.setValue(mCurrentPlayer);
            return true;
        }

        if (isBoardFull()) {
            mWinner.setValue(null);
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (Cell[] row : mCells) {
            for (Cell c : row) {
                if (c == null || c.isEmpty())
                    return false;
            }
        }
        return true;
    }

    private boolean hasThreeSameDiagonalCells() {
        return areEqual(mCells[0][0], mCells[1][1], mCells[2][2]) ||
                areEqual(mCells[2][0], mCells[1][1], mCells[0][2]);
    }

    private boolean hasThreeSameVerticalCells() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (areEqual(mCells[0][i], mCells[1][i], mCells[2][i]))
                return true;
        }
        return false;
    }

    public boolean hasThreeSameHorizontalCells() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (areEqual(mCells[i][0], mCells[i][1], mCells[i][2]))
                return true;
        }
        return false;
    }

    private boolean areEqual(Cell... cells) {
        if (cells == null || cells.length == 0)
            return false;

        for (Cell c : cells) {
            if (c == null || isNullOrEmpty(c.mPlayer.mValue))
                return false;
        }

        Cell initialBase = cells[0];
        for (int i = 1; i < cells.length; i++) {
            if (!initialBase.mPlayer.mValue.equals(cells[i].mPlayer.mValue))
                return false;
        }
        return true;
    }

    public void reset() {
        mPlayer1 = null;
        mPlayer2 = null;
        mCurrentPlayer = null;
        mCells = null;
        mWinner = null;
    }

    public void switchPlayer() {
        mCurrentPlayer = mCurrentPlayer == mPlayer1 ? mPlayer2 : mPlayer1;
    }
}
