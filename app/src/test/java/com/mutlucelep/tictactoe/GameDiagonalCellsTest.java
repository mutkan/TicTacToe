package com.mutlucelep.tictactoe;

import com.mutlucelep.tictactoe.model.Cell;
import com.mutlucelep.tictactoe.model.Game;
import com.mutlucelep.tictactoe.model.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameDiagonalCellsTest {
  private Game mGame;
  private Player mPlayer, mAnotherPlayer;

  @Before
  public void setUp() {
    mGame = new Game("X", "O");
    mPlayer = mGame.mPlayer1;
    mAnotherPlayer = mGame.mPlayer2;
  }

  @Test
  public void returnTrueIfHasThreeSameDiagonalCellsFromDownLeft() {
    Cell c = new Cell(mPlayer);
    mGame.mCells[0][0] = c;
    mGame.mCells[1][1] = c;
    mGame.mCells[2][2] = c;

    boolean hasThreeSameDiagonalCells = mGame.hasThreeSameDiagonalCells();
    assertEquals(true, hasThreeSameDiagonalCells);
  }

  @Test
  public void returnTrueIfHasThreeSameDiagonalCellsFromUpLeft() {
    Cell c = new Cell(mPlayer);
    mGame.mCells[0][2] = c;
    mGame.mCells[1][1] = c;
    mGame.mCells[2][0] = c;

    boolean hasThreeSameDiagonalCells = mGame.hasThreeSameDiagonalCells();
    assertEquals(true, hasThreeSameDiagonalCells);
  }

  @Test
  public void returnFalseIfDoesNotHaveThreeSameDiagonalCellsFromUpLeft() {
    Cell c = new Cell(mPlayer);
    Cell c1 = new Cell(mAnotherPlayer);
    mGame.mCells[0][2] = c;
    mGame.mCells[1][1] = c1;
    mGame.mCells[2][0] = c;

    boolean hasThreeSameDiagonalCells = mGame.hasThreeSameDiagonalCells();
    assertEquals(false, hasThreeSameDiagonalCells);
  }
}
