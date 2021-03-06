package com.mutlucelep.tictactoe;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mutlucelep.tictactoe.databinding.ActivityMainBinding;
import com.mutlucelep.tictactoe.model.Player;
import com.mutlucelep.tictactoe.view.GameBeginDialog;
import com.mutlucelep.tictactoe.view.GameEndDialog;
import com.mutlucelep.tictactoe.viewmodel.GameViewModel;

import static com.mutlucelep.tictactoe.utility.StringUtility.isNullOrEmpty;

public class MainActivity extends AppCompatActivity {
    private static final String GAME_BEGIN_DIALOG_TAG = "game_begin_dialog_tag";
    private static final String GAME_END_DIALOG_TAG = "game_end_dialog_tag";
    private static final String NO_WINNER = "No one";
    private GameViewModel mGameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        promptForPlayers();
    }

    public void promptForPlayers() {
        GameBeginDialog dialog = GameBeginDialog.newInstance(this);
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), GAME_BEGIN_DIALOG_TAG);
    }

    public void onPlayersSet(String player1, String player2) {
        initDataBinding(player1, player2);
    }

    private void initDataBinding(String player1, String player2) {
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mGameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        mGameViewModel.init(player1,player2);
        activityMainBinding.setGameViewModel(mGameViewModel);
        setUpOnGameEndListener();
    }

    private void setUpOnGameEndListener() {
        mGameViewModel.getWinner().observe(this, this::onGameWinnerChanged);
    }

    @VisibleForTesting
    public void onGameWinnerChanged(Player winner) {
        String winnerName = winner == null || isNullOrEmpty(winner.mName) ? NO_WINNER : winner.mName;
        GameEndDialog dialog = GameEndDialog.newInstance(this, winnerName);
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), GAME_END_DIALOG_TAG);
    }
}
