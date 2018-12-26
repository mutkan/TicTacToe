package com.mutlucelep.tictactoe.model;

import com.mutlucelep.tictactoe.utility.StringUtility;

public class Cell {
    public Player mPlayer;

    public Cell(Player player){
        mPlayer = player;
    }

    public boolean isEmpty(){
        return mPlayer == null || StringUtility.isNullOrEmpty(mPlayer.mValue);
    }
}

