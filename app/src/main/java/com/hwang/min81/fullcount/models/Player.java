package com.hwang.min81.fullcount.models;

/**
 * Created by min on 2016. 3. 6..
 */
public class Player {
    private String mName;
    private String mTeamName;
    private int mUniformNumber;

    /**
     *
     */
    public Player() {

    }

    /**
     *
     * @param player
     */
    public Player(Player player) {

    }

    /**
     *
     * @return
     */
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name.trim();
    }
}