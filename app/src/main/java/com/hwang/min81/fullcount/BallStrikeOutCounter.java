package com.hwang.min81.fullcount;

import com.hwang.min81.fullcount.actions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min81 on 2015-10-07.
 */
public class BallStrikeOutCounter implements BaseballActionListener {
    private final int MAX_BALLS = 4, MAX_STRIKES = 3, MAX_OUTS = 3;
    private int balls, strikes, outs;
    private List<BallStrikeOutCounterChangedEventListener> listeners = new ArrayList();

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
        return this.balls;
    }

    public void setBalls(int balls) throws MaxValueReachedException {
        if(balls >= this.MAX_BALLS) { throw new MaxValueReachedException(); }
        this.balls = balls;
        counterChanged();
    }

    public int getStrikes() {
        return this.strikes;
    }

    public void setStrikes(int strikes) throws MaxValueReachedException {
        if(strikes > this.MAX_STRIKES) { throw new MaxValueReachedException(); }
        this.strikes = strikes;
        counterChanged();
    }

    public int getOuts() {
        return this.outs;
    }

    public void setOuts(int outs) throws MaxValueReachedException {
        if(outs > this.MAX_OUTS) { throw new MaxValueReachedException(); }
        this.outs = outs;
        counterChanged();
    }

    @Override
    public void baseballActionPerformed(BaseballActions action) {
        switch (action) {
            case BALL:
                this.increaseBallsByOne();
                break;
            case STRIKE:
                this.increaseStrikesByOne();
                break;
            case BASE_ON_BALLS:
                try {
                    this.setBalls(0);
                    this.setStrikes(0);
                } catch (MaxValueReachedException e) {
                    e.printStackTrace();
                }

            default:
                break;
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
    public void baseballActionRestored(BaseballActions action) {

    }

    public void addListener(BallStrikeOutCounterChangedEventListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(BallStrikeOutCounterChangedEventListener listener) {
        this.listeners.remove(listener);
    }

    private void counterChanged() {
        for(BallStrikeOutCounterChangedEventListener listener : listeners) {
            listener.counterChanged(this);
        }
    }

    public class MaxValueReachedException extends Exception {
    }
}
