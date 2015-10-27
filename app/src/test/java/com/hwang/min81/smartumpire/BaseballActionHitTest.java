package com.hwang.min81.smartumpire;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by min81 on 2015-10-28.
 */
public class BaseballActionHitTest {
    @Test
    public void PerformingHitActionResetBallStrikeCount() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setBall((short)1);
        ballStrikeOutCounter.setStrike((short) 2);

        BaseballActionHit baseballActionHit = new BaseballActionHit(ballStrikeOutCounter);
        baseballActionHit.perform();

        assertEquals(0, ballStrikeOutCounter.getBall());
        assertEquals(0, ballStrikeOutCounter.getStrike());
    }
}
