package com.hwang.min81.smartumpire;

/**
 * Created by min81 on 2015-10-07.
 */
public class BallStrikeOutCounter {

    private short ball = 0, strike = 0;

    public short getBall() {
        return this.ball;
    }

    public void setBall(short ball) throws OutOfRangeException {
        if(ball > 3) { throw new OutOfRangeException(); }
        this.ball = ball;
    }

    public short getStrike() {
        return this.strike;
    }

    public void setStrike(short strike) throws OutOfRangeException {
        if(strike > 2) { throw new OutOfRangeException(); }
        this.strike = strike;
    }

    class OutOfRangeException extends Exception {
    }
}
