package com.hwang.min81.fullcount;

/**
 * Created by min on 2015. 12. 27..
 */
public class BaseballScore extends Score<Integer> {
    @Override
    public Integer earnPoints(int points) {
        int score = getCurrentScore();
        if(points > 0) {
            try {
                score = getCurrentScore() + points;
            } catch (ArithmeticException ex) {
                score = Integer.MAX_VALUE;
            }
        }
        setCurrentScore(score);
        return getCurrentScore();
    }

    @Override
    public Integer loosePoints(int points) {
        throw new UnsupportedOperationException();
    }
}
