package com.hwang.min81.fullcount;

import com.hwang.min81.fullcount.actions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min81 on 2015-10-07.
 */
public class BallStrikeOutCounter implements BaseballActionNotifier.BaseballActionListener {
    private final int MAX_BALLS = 4, MAX_STRIKES = 3, MAX_OUTS = 3;
    private int mBalls, mStrikes, mOuts;
    private boolean mHasTheLastActionBeenHandled;
    private List<BallStrikeOutCounterChangedListener> mListeners = new ArrayList();

    public BallStrikeOutCounter() {
        try {
            setBalls(0);
            setStrikes(0);
            setOuts(0);
        } catch (MaxValueReachedException e) {
            e.printStackTrace();
        }
    }

    public int getBalls() {
        return mBalls;
    }

    public void setBalls(int balls) throws MaxValueReachedException {
        if(balls >= this.MAX_BALLS) { throw new MaxValueReachedException(); }
        mBalls = balls;
        onCounterChanged();
    }

    public int getStrikes() {
        return mStrikes;
    }

    public void setStrikes(int strikes) throws MaxValueReachedException {
        if(strikes > this.MAX_STRIKES) { throw new MaxValueReachedException(); }
        mStrikes = strikes;
        onCounterChanged();
    }

    public int getOuts() {
        return mOuts;
    }

    public void setOuts(int outs) throws MaxValueReachedException {
        if(outs > this.MAX_OUTS) { throw new MaxValueReachedException(); }
        mOuts = outs;
        onCounterChanged();
    }

    @Override
    public boolean hasTheLastActionBeenHandled() {
        return mHasTheLastActionBeenHandled;
    }

    @Override
    public void onBaseballActionPerformed(BaseballActions action) {
        mHasTheLastActionBeenHandled = false;

        switch (action) {
            case BALL: {
                this.increaseBallsByOne();
                mHasTheLastActionBeenHandled = true;
                break;
            }
            case STRIKE: {
                this.increaseStrikesByOne();
                mHasTheLastActionBeenHandled = true;
                break;
            }
            case HIT_BY_PITCH: {
                try {
                    this.setBalls(0);
                    this.setStrikes(0);
                    mHasTheLastActionBeenHandled = true;
                } catch (MaxValueReachedException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }
            }

            default: {
                mHasTheLastActionBeenHandled = false;
                break;
            }
        }
    }

    private void increaseBallsByOne() {
        final int increasedBalls = getBalls() + 1;
        try {
            if(increasedBalls == this.MAX_BALLS) {
                setBalls(0);
                setStrikes(0);
            }
            else {
                setBalls(increasedBalls);
            }
        } catch (MaxValueReachedException e) {}
    }

    private void increaseStrikesByOne() {
        final int increasedStrikes = getStrikes() + 1;
        try {
            if(increasedStrikes == this.MAX_STRIKES) {
                setBalls(0);
                setStrikes(0);
                increaseOutsByOne();
            }
            else {
                setStrikes(increasedStrikes);
            }
        } catch (MaxValueReachedException e) {}
    }

    private void increaseOutsByOne() {
        final int increasedOuts = getOuts() + 1;
        try {
            if(increasedOuts == this.MAX_OUTS) {
                setBalls(0);
                setStrikes(0);
                setOuts(0);
            }
            else {
                setOuts(increasedOuts);
            }
        } catch (MaxValueReachedException e) {}

    }

    @Override
    public void onBaseballActionRestored(BaseballActions action) {
    }

    public void addListener(BallStrikeOutCounterChangedListener listener) {
        this.mListeners.add(listener);
    }

    public void removeListener(BallStrikeOutCounterChangedListener listener) {
        this.mListeners.remove(listener);
    }

    private void onCounterChanged() {
        for(BallStrikeOutCounterChangedListener listener : mListeners) {
            listener.onCounterChanged(this);
        }
    }

    public class MaxValueReachedException extends Exception {
    }
}
