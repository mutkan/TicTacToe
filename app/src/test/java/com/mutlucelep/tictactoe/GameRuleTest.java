package com.mutlucelep.tictactoe;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.mutlucelep.tictactoe.model.Cell;
import com.mutlucelep.tictactoe.model.Game;
import com.mutlucelep.tictactoe.model.Player;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameRuleTest {
    private final static int BOARD_SIZE = 3;
    private Game mGame;
    private Player mPlayer;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        mGame = new Game("X", "O");
        mPlayer = mGame.mPlayer1;
    }

    @Test
    public void endGameIfHasThreeSameHorizontalCells() {
        Cell c = new Cell(mPlayer);
        mGame.mCells[0][0] = c;
        mGame.mCells[0][1] = c;
        mGame.mCells[0][2] = c;

        boolean hasGameEnded = mGame.hasGameEnded();
        assertEquals(true, hasGameEnded);
    }

    @Test
    public void endGameIfHasThreeSameVerticalCells() {
        Cell c = new Cell(mPlayer);
        mGame.mCells[0][0] = c;
        mGame.mCells[1][0] = c;
        mGame.mCells[2][0] = c;

        boolean hasGameEnded = mGame.hasGameEnded();
        assertEquals(true, hasGameEnded);
    }

    @Test
    public void endGameIfHasThreeSameDiagonalCells() {
        Cell c = new Cell(mPlayer);
        mGame.mCells[0][0] = c;
        mGame.mCells[1][1] = c;
        mGame.mCells[2][2] = c;

        boolean hasGameEnded = mGame.hasGameEnded();
        assertEquals(true, hasGameEnded);
    }

    @Test
    public void endGameIfBoardIsFull() {
        Cell c = new Cell(new Player("Name", "X"));
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                mGame.mCells[i][j] = c;
            }
        }

        boolean isBoardFull = mGame.isBoardFull();
        assertEquals(true, isBoardFull);
    }

    @Test
    public void switchPlayer1ToPlayer2() {
        mGame.mCurrentPlayer = mGame.mPlayer1;
        mGame.switchPlayer();
        assertEquals(mGame.mPlayer2, mGame.mCurrentPlayer);
    }

    @Test
    public void hasReset() {
        mGame.reset();
        assertNull(mGame.mCells);
        assertNull(mGame.mCurrentPlayer);
        assertNull(mGame.mWinner);
        assertNull(mGame.mPlayer2);
        assertNull(mGame.mPlayer1);
    }
}
