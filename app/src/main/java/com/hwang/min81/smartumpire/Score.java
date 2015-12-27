package com.hwang.min81.smartumpire;

/**
 * Created by min on 2015. 12. 27..
 */
public interface Score<T> {
    public T earnPoints(int points);
    public T loosePoints(int points);
    public T getCurrentScore();
    public void setCurrentScore(T score);
}
