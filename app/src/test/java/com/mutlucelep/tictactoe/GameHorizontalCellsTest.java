package com.mutlucelep.tictactoe;

import com.mutlucelep.tictactoe.model.Cell;
import com.mutlucelep.tictactoe.model.Game;
import com.mutlucelep.tictactoe.model.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameHorizontalCellsTest {
  private Game mGame;
  private Player mPlayer, mAnotherPlayer;

  @Before
  public void setUp() {
    mGame = new Game("X", "O");
    mPlayer = mGame.mPlayer1;
    mAnotherPlayer = mGame.mPlayer2;
  }

  @Test
  public void returnTrueIfHasThreeSameHorizontalCellAtRow1() {
    Cell c = new Cell(mPlayer);
    mGame.mCells[0][0] = c;
    mGame.mCells[0][1] = c;
    mGame.mCells[0][2] = c;

    boolean hasThreeSameHorizontalCell = mGame.hasThreeSameHorizontalCells();
    assertEquals(true, hasThreeSameHorizontalCell);
  }

  @Test
  public void returnTrueIfHasThreeSameHorizontalCellAtRow2() {
    Cell c = new Cell(mPlayer);
    mGame.mCells[1][0] = c;
    mGame.mCells[1][1] = c;
    mGame.mCells[1][2] = c;

    boolean hasThreeSameHorizontalCell = mGame.hasThreeSameHorizontalCells();
    assertEquals(true, hasThreeSameHorizontalCell);
  }

  @Test
  public void returnTrueIfHasThreeSameHorizontalCellAtRow3() {
    Cell c = new Cell(mPlayer);
    mGame.mCells[2][0] = c;
    mGame.mCells[2][1] = c;
    mGame.mCells[2][2] = c;

    boolean hasThreeSameHorizontalCell = mGame.hasThreeSameHorizontalCells();
    assertEquals(true, hasThreeSameHorizontalCell);
  }

  @Test
  public void returnFalseIfDoesNotHaveThreeSameHorizontalCells() {
    Cell c = new Cell(mPlayer);
    Cell c1 = new Cell(mAnotherPlayer);

    mGame.mCells[0][0] = c;
    mGame.mCells[0][1] = c;
    mGame.mCells[0][2] = c1;

    boolean hasThreeSameHorizontalCells = mGame.hasThreeSameHorizontalCells();
    assertEquals(false, hasThreeSameHorizontalCells);
  }
}
