package com.hwang.min81.smartumpire;

/**
 * Created by min on 2015. 12. 27..
 */
public class BaseballScore implements Score<Integer> {
    private Integer score = 0;

    @Override
    public Integer earnPoints(int points) {
        if(points > 0) {
            long result = (long)this.score + (long)points;
            this.score = result <= Integer.MAX_VALUE ? (int)result : Integer.MAX_VALUE;
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
    }
}
