package com.hwang.min81.fullcount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 2015. 12. 27..
 */
public class BaseballScore implements Score<Integer> {
    private Integer score = 0;
    private List<ScoreChangedEventListener> listeners = new ArrayList();

    @Override
    public Integer earnPoints(int points) {
        if(points > 0) {
            long result = (long)this.score + (long)points;
            this.score = result <= Integer.MAX_VALUE ? (int)result : Integer.MAX_VALUE;
            scoreChanged();
        }

        return this.score;
    }

    @Override
    public Integer loosePoints(int points) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer getCurrentScore() {
        return this.score;
    }

    @Override
    public void setCurrentScore(Integer score) {
        this.score = score;
        scoreChanged();
    }

    @Override
    public void addListener(ScoreChangedEventListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(ScoreChangedEventListener listener) {
        this.listeners.remove(listener);
    }

    private void scoreChanged() {
        for(ScoreChangedEventListener listener : listeners) {
            listener.scoreChanged(this);
        }
    }
}
