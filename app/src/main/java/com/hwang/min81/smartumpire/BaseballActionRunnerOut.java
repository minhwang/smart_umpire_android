package com.hwang.min81.smartumpire;

/**
 * Created by min81 on 2015-11-01.
 */
public class BaseballActionRunnerOut {
    private BallStrikeOutCounter ballStrikeOutCounter;

    public BaseballActionRunnerOut(BallStrikeOutCounter ballStrikeOutCounter) {
        this.ballStrikeOutCounter = ballStrikeOutCounter;
    }

    public void perform() throws BallStrikeOutCounter.OutOfRangeException {
        this.ballStrikeOutCounter.addOneOut();
    }
}
