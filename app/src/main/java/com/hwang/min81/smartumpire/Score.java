package com.hwang.min81.smartumpire;

/**
 * Created by min on 2015. 12. 27..
 */
public interface Score<T> {
    T earnPoints(int points);
    T loosePoints(int points);
    T getCurrentScore();
    void setCurrentScore(T score);
    void addListener(ScoreChangedEventListener listener);
    void removeListener(ScoreChangedEventListener listener);
}
