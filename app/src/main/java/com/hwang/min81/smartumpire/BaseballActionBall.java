package com.hwang.min81.smartumpire;

/**
 * Created by min81 on 2015-10-28.
 */
public class BaseballActionBall {
    private BallStrikeOutCounter ballStrikeOutCounter;

    public BaseballActionBall(BallStrikeOutCounter ballStrikeOutCounter) {
        this.ballStrikeOutCounter = ballStrikeOutCounter;
    }

    public void perform() throws BallStrikeOutCounter.OutOfRangeException {
        this.ballStrikeOutCounter.addOneBall();
    }
}
