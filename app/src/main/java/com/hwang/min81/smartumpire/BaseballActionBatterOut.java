package com.hwang.min81.smartumpire;

/**
 * Created by min81 on 2015-11-01.
 */
public class BaseballActionBatterOut {
    private BallStrikeOutCounter ballStrikeOutCounter;

    public BaseballActionBatterOut(BallStrikeOutCounter ballStrikeOutCounter) {
        this.ballStrikeOutCounter = ballStrikeOutCounter;
    }

    public void perform() throws BallStrikeOutCounter.OutOfRangeException {
        this.ballStrikeOutCounter.setBall((short)0);
        this.ballStrikeOutCounter.setStrike((short)0);
        this.ballStrikeOutCounter.addOneOut();
    }
}
