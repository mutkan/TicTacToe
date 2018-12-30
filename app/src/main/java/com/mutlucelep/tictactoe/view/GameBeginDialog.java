package com.mutlucelep.tictactoe.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import com.mutlucelep.tictactoe.MainActivity;
import com.mutlucelep.tictactoe.R;

public class GameBeginDialog extends DialogFragment {

    private TextInputLayout player1Layout;
    private TextInputLayout player2Layout;

    private TextInputEditText player1EditText;
    private TextInputEditText player2EditText;

    private String player1;
    private String player2;

    private View rootView;
    private MainActivity activity;

    public static GameBeginDialog newInstance(MainActivity activity) {
        GameBeginDialog dialog = new GameBeginDialog();
        dialog.activity = activity;
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        initViews();
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(rootView)
                .setTitle(R.string.game_dialog_title)
                .setCancelable(false)
                .setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onDoneClicked();
                    }
                })
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        return alertDialog;
    }

    private void initViews() {
        rootView = LayoutInflater.from(getContext())
                .inflate(R.layout.game_begin_dialog, null, false);

        player1Layout = rootView.findViewById(R.id.layout_player1);
        player2Layout = rootView.findViewById(R.id.layout_player2);

        player1EditText = rootView.findViewById(R.id.et_player1);
        player2EditText = rootView.findViewById(R.id.et_player2);
        addTextWatchers();
    }

    private void onDoneClicked() {
        if (isAValidName(player1Layout, player1) && isAValidName(player2Layout, player2)) {
            activity.onPlayersSet(player1, player2);
            dismiss();
        }
    }

    private boolean isAValidName(TextInputLayout layout, String name) {
        if (TextUtils.isEmpty(name)) {
            layout.setErrorEnabled(true);
            layout.setError(getString(R.string.game_dialog_empty_name));
            return false;
        }

        if (player1 != null && player2 != null && player1.equalsIgnoreCase(player2)) {
            layout.setErrorEnabled(true);
            layout.setError(getString(R.string.game_dialog_same_names));
            return false;
        }

        layout.setErrorEnabled(false);
        layout.setError("");
        return true;
    }

    private void addTextWatchers() {
        player1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                player1 = s.toString();
            }
        });
        player2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                player2 = s.toString();
            }
        });
    }
}