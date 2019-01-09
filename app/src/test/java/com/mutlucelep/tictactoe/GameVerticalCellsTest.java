package com.mutlucelep.tictactoe;

import com.mutlucelep.tictactoe.model.Cell;
import com.mutlucelep.tictactoe.model.Game;
import com.mutlucelep.tictactoe.model.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameVerticalCellsTest {
  private Game mGame;
  private Player mPlayer, mAnotherPlayer;

  @Before
  public void setUp() throws Exception {
    mGame = new Game("X", "O");
    mPlayer = mGame.mPlayer1;
    mAnotherPlayer = mGame.mPlayer2;
  }

  @Test
  public void returnTrueIfHasThreeSameVerticalCellsAtColumn1() {
    Cell c = new Cell(mPlayer);
    mGame.mCells[0][0] = c;
    mGame.mCells[1][0] = c;
    mGame.mCells[2][0] = c;

    boolean hasThreeSameVerticalCells = mGame.hasThreeSameVerticalCells();
    assertEquals(true, hasThreeSameVerticalCells);
  }

  @Test
  public void returnTrueIfHasThreeSameVerticalCellsAtColumn2() {
    Cell c = new Cell(mPlayer);
    mGame.mCells[0][1] = c;
    mGame.mCells[1][1] = c;
    mGame.mCells[2][1] = c;

    boolean hasThreeSameVerticalCells = mGame.hasThreeSameVerticalCells();
    assertEquals(true, hasThreeSameVerticalCells);
  }

  @Test
  public void returnTrueIfHasThreeSameVerticalCellAtColumn3() {
    Cell c = new Cell(mPlayer);
    mGame.mCells[0][2] = c;
    mGame.mCells[1][2] = c;
    mGame.mCells[2][2] = c;

    boolean hasThreeSameVerticalCells = mGame.hasThreeSameVerticalCells();
    assertEquals(true, hasThreeSameVerticalCells);
  }

  @Test
  public void returnFalseIfDoesNotHaveThreeSameVerticalCellAtAColumn() {
    Cell c = new Cell(mPlayer);
    Cell c1 = new Cell(mAnotherPlayer);

    mGame.mCells[0][2] = c;
    mGame.mCells[1][2] = c;
    mGame.mCells[2][2] = c1;

    boolean hasThreeSameVerticalCells = mGame.hasThreeSameVerticalCells();
    assertEquals(false, hasThreeSameVerticalCells);
  }
}
