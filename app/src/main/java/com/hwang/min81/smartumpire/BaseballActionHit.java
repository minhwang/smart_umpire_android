package com.hwang.min81.smartumpire;

/**
 * Created by min81 on 2015-10-28.
 */
public class BaseballActionHit {
    private BallStrikeOutCounter ballStrikeOutCounter;

    public BaseballActionHit(BallStrikeOutCounter ballStrikeOutCounter) {
        this.ballStrikeOutCounter = ballStrikeOutCounter;
    }

    public void perform() throws BallStrikeOutCounter.OutOfRangeException {
        this.ballStrikeOutCounter.setBall((short)0);
        this.ballStrikeOutCounter.setStrike((short)0);
    }
}
