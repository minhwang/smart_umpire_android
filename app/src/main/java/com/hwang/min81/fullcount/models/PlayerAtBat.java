package com.hwang.min81.fullcount.models;

/**
 * Created by min on 2016. 3. 8..
 */
public class PlayerAtBat extends Player {
    private int mPitchedCount;
    private int mStrikeCount;
    private int mBallCount;

    /**
     *
     * @param player
     */
    public PlayerAtBat(Player player) {
        super(player);
    }
}
