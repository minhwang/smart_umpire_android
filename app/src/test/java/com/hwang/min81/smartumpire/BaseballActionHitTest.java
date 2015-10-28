package com.hwang.min81.smartumpire;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by min81 on 2015-10-28.
 */
@RunWith(Parameterized.class)
public class BaseballActionHitTest {
    @Parameterized.Parameters(name = "{index}: B={0}, S={1}, O={2}")
    public static Iterable<Object[]> getParams() {
        return Arrays.asList(new Object[][] {
                {0, 0, 0},
                {0, 0, 1},
                {0, 0, 2},
                {0, 1, 0},
                {0, 1, 1},
                {0, 1, 2},
                {0, 2, 0},
                {0, 2, 1},
                {0, 2, 2},
                {1, 0, 0},
                {1, 0, 1},
                {1, 0, 2},
                {1, 1, 0},
                {1, 1, 1},
                {1, 1, 2},
                {1, 2, 0},
                {1, 2, 1},
                {1, 2, 2},
                {2, 0, 0},
                {2, 0, 1},
                {2, 0, 2},
                {2, 1, 0},
                {2, 1, 1},
                {2, 1, 2},
                {2, 2, 0},
                {2, 2, 1},
                {2, 2, 2},
                {3, 0, 0},
                {3, 0, 1},
                {3, 0, 2},
                {3, 1, 0},
                {3, 1, 1},
                {3, 1, 2},
                {3, 2, 0},
                {3, 2, 1},
                {3, 2, 2}
        });
    }

    private short ball;
    private short strike;
    private short out;

    public BaseballActionHitTest(int ball, int strike, int out) {
        this.ball = (short)ball;
        this.strike = (short)strike;
        this.out = (short)out;
    }

    @Test
    public void PerformingHitActionResetBallStrikeAndLeaveOutCount() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setBall(this.ball);
        ballStrikeOutCounter.setStrike(this.strike);
        ballStrikeOutCounter.setOut(this.out);

        BaseballActionHit baseballActionHit = new BaseballActionHit(ballStrikeOutCounter);
        baseballActionHit.perform();

        assertEquals(0, ballStrikeOutCounter.getBall());
        assertEquals(0, ballStrikeOutCounter.getStrike());
        assertEquals(this.out, ballStrikeOutCounter.getOut());
    }
}
