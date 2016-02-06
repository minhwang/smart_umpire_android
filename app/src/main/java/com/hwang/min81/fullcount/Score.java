package com.hwang.min81.fullcount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 2015. 12. 27..
 */
public abstract class Score<T> {
    private T mCurrentScore;
    private List<ScoreChangedListener> mChangedListeners = new ArrayList();

    public abstract T earnPoints(int points);
    public abstract T loosePoints(int points);

    /**
     * Get the current score.
     */
    public T getCurrentScore() {
        return mCurrentScore;
    }

    /**
     * Specify the current score.
     */
    public void setCurrentScore(T score) {
        mCurrentScore = score;
        notifyScoreChanged();
    }

    /**
     * Add the listener which will be called when the score changed.
     */
    public void addChangedListener(ScoreChangedListener listener) {
        mChangedListeners.add(listener);
    }

    /**
     * Remove the listener which will be called when the score changed.
     */
    public void removeChangedListener(ScoreChangedListener listener) {
        mChangedListeners.remove(listener);
    }

    private void notifyScoreChanged() {
        for(ScoreChangedListener listener : mChangedListeners) {
            listener.onScoreChanged(this);
        }
    }

    public interface ScoreChangedListener {
        /**
         * Called when a score has been changed.
         *
         * @param score The score that was changed and held.
         */
        void onScoreChanged(Score score);
    }
}
