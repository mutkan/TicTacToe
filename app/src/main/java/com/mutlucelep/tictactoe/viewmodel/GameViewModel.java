package com.mutlucelep.tictactoe.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayMap;

import com.mutlucelep.tictactoe.model.Cell;
import com.mutlucelep.tictactoe.model.Game;
import com.mutlucelep.tictactoe.model.Player;

import static com.mutlucelep.tictactoe.utility.StringUtility.stringFromNumbers;

public class GameViewModel extends ViewModel {
  public ObservableArrayMap<String, String> mCellsObservableArrayMap;
  private Game mGame;
Ö
  public void init(String player1, String player2) {
    mGame = new Game(player1, player2);
    mCellsObservableArrayMap = new ObservableArrayMap<>();
  }

  public void onClickedCellAt(int row, int column) {
    if (mGame.mCells != null && mGame.mCells[row][column] == null) {
      mGame.mCells[row][column] = new Cell(mGame.mCurrentPlayer);
      mCellsObservableArrayMap.put(stringFromNumbers(row, column), mGame.mCurrentPlayer.mValue);
      if (mGame.hasGameEnded()) mGame.reset();
      else mGame.switchPlayer();
    }
  }

  public LiveData<Player> getWinner() {
    return mGame.mWinner;
  }
}
