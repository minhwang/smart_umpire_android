package com.hwang.min81.smartumpire;

/**
 * Created by min81 on 2015-10-07.
 */
public class BallStrikeOutCounter {

    private short ball = 0, strike = 0, out = 0;

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

    public short getOut() {
        return this.out;
    }

    public void setOut(short out) throws OutOfRangeException {
        if(out > 2) { throw new OutOfRangeException(); }
        this.out = out;
    }

    public void addOneStrike() throws OutOfRangeException {
        final short strike = this.getStrike();

        if(strike == 2) {
            this.setStrike((short)0);
            this.setBall((short) 0);
            this.addOneOut();
        }
        else {
            this.setStrike((short)(strike + 1));
        }
    }

    public void addOneOut() throws OutOfRangeException {
        final short out = this.getOut();

        if(out == 2) {
            this.setStrike((short)0);
            this.setBall((short)0);
            this.setOut((short) 0);
        }
        else {
            this.setOut((short) (out + 1));
        }
    }

    public void addOneBall() throws OutOfRangeException {
        final short ball = this.getBall();

        if(ball == 3) {
            this.setStrike((short)0);
            this.setBall((short)0);
        }
        else {
            this.setBall((short) (ball + 1));
        }
    }

    class OutOfRangeException extends Exception {
    }
}
