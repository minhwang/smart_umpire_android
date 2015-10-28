package com.hwang.min81.smartumpire;

/**
 * Created by min81 on 2015-10-28.
 */
public class BaseballActionStrike {
    private BallStrikeOutCounter ballStrikeOutCounter;

    public BaseballActionStrike(BallStrikeOutCounter ballStrikeOutCounter) {
        this.ballStrikeOutCounter = ballStrikeOutCounter;
    }

    public void perform() throws BallStrikeOutCounter.OutOfRangeException {
        this.ballStrikeOutCounter.addOneStrike();
    }
}
