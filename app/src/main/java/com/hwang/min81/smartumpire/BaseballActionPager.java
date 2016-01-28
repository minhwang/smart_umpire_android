package com.hwang.min81.smartumpire;

/**
 * Created by hwangmin on 2016. 1. 29..
 */
public enum BaseballActionPager {
    PITCHING(0, R.layout.pitching_action_view),
    BATTING(1, R.layout.batting_action_view),
    FIELDING(2, R.layout.fielding_action_view),
    MANAGING(3, R.layout.managing_action_view);

    private int pagePosition;
    private int resId;

    BaseballActionPager(int pagePosition, int resId) {
        this.pagePosition = pagePosition;
        this.resId = resId;
    }

    public int getPagePosition() {
        return this.pagePosition;
    }

    public int getResId() {
        return this.resId;
    }
}