package com.hwang.min81.smartumpire;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by min81 on 2015-11-01.
 */
@RunWith(Parameterized.class)
@SmallTest
public class BaseballActionRunnerOutTest {
    private short ball, strike, out, expectedBall, expectedStrike, expectedOut;

    @Parameterized.Parameters(name = "{index}: B={0}, S={1}, O={2} -> B={3}, S={4}, O={5}")
    public static Iterable<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 2},
                {0, 0, 2, 0, 0, 0},
                {0, 1, 0, 0, 1, 1},
                {0, 1, 1, 0, 1, 2},
                {0, 1, 2, 0, 0, 0},
                {0, 2, 0, 0, 2, 1},
                {0, 2, 1, 0, 2, 2},
                {0, 2, 2, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 2},
                {1, 0, 2, 0, 0, 0},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 2},
                {1, 1, 2, 0, 0, 0},
                {1, 2, 0, 1, 2, 1},
                {1, 2, 1, 1, 2, 2},
                {1, 2, 2, 0, 0, 0},
                {2, 0, 0, 2, 0, 1},
                {2, 0, 1, 2, 0, 2},
                {2, 0, 2, 0, 0, 0},
                {2, 1, 0, 2, 1, 1},
                {2, 1, 1, 2, 1, 2},
                {2, 1, 2, 0, 0, 0},
                {2, 2, 0, 2, 2, 1},
                {2, 2, 1, 2, 2, 2},
                {2, 2, 2, 0, 0, 0},
                {3, 0, 0, 3, 0, 1},
                {3, 0, 1, 3, 0, 2},
                {3, 0, 2, 0, 0, 0},
                {3, 1, 0, 3, 1, 1},
                {3, 1, 1, 3, 1, 2},
                {3, 1, 2, 0, 0, 0},
                {3, 2, 0, 3, 2, 1},
                {3, 2, 1, 3, 2, 2},
                {3, 2, 2, 0, 0, 0}
        });
    }

    public BaseballActionRunnerOutTest(int ball, int strike, int out, int expectedBall, int expectedStrike, int expectedOut) {
        this.ball = (short)ball;
        this.strike = (short)strike;
        this.out = (short)out;
        this.expectedBall = (short)expectedBall;
        this.expectedStrike = (short)expectedStrike;
        this.expectedOut = (short)expectedOut;
    }

    @Test
    public void PerformingRunnerOutActionLeaveBallStrikeCountAndAddOneOutCount() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setBall(this.ball);
        ballStrikeOutCounter.setStrike(this.strike);
        ballStrikeOutCounter.setOut(this.out);

        BaseballActionRunnerOut baseballActionRunnerOut = new BaseballActionRunnerOut(ballStrikeOutCounter);
        baseballActionRunnerOut.perform();

        assertEquals(this.expectedBall, ballStrikeOutCounter.getBall());
        assertEquals(this.expectedStrike, ballStrikeOutCounter.getStrike());
        assertEquals(this.expectedOut, ballStrikeOutCounter.getOut());
    }
}