package com.hwang.min81.fullcount.actions;

import android.test.suitebuilder.annotation.SmallTest;

import com.hwang.min81.fullcount.BallStrikeOutCounter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by min on 2016. 1. 1..
 */
@RunWith(Parameterized.class)
@SmallTest
public class BaseballActionBallTest {
    @Parameterized.Parameters(name = "{index}: B={0}, S={1}, O={2} -> B={3}, S={4}, O={5}")
    public static Iterable<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 2, 1, 0, 2},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 2, 1, 1, 2},
                {0, 2, 0, 1, 2, 0},
                {0, 2, 1, 1, 2, 1},
                {0, 2, 2, 1, 2, 2},
                {1, 0, 0, 2, 0, 0},
                {1, 0, 1, 2, 0, 1},
                {1, 0, 2, 2, 0, 2},
                {1, 1, 0, 2, 1, 0},
                {1, 1, 1, 2, 1, 1},
                {1, 1, 2, 2, 1, 2},
                {1, 2, 0, 2, 2, 0},
                {1, 2, 1, 2, 2, 1},
                {1, 2, 2, 2, 2, 2},
                {2, 0, 0, 3, 0, 0},
                {2, 0, 1, 3, 0, 1},
                {2, 0, 2, 3, 0, 2},
                {2, 1, 0, 3, 1, 0},
                {2, 1, 1, 3, 1, 1},
                {2, 1, 2, 3, 1, 2},
                {2, 2, 0, 3, 2, 0},
                {2, 2, 1, 3, 2, 1},
                {2, 2, 2, 3, 2, 2},
                {3, 0, 0, 0, 0, 0},
                {3, 0, 1, 0, 0, 1},
                {3, 0, 2, 0, 0, 2},
                {3, 1, 0, 0, 0, 0},
                {3, 1, 1, 0, 0, 1},
                {3, 1, 2, 0, 0, 2},
                {3, 2, 0, 0, 0, 0},
                {3, 2, 1, 0, 0, 1},
                {3, 2, 2, 0, 0, 2}
        });
    }

    private int mBalls, mStrikes, mOuts, mExpectedBalls, mExpectedStrikes, mExpectedOuts;
    private BallStrikeOutCounter mBallStrikeCounter;
    private BaseballActionNotifier mBaseballActionNotifier;

    public BaseballActionBallTest(int balls, int strikes, int outs, int expectedBalls, int expectedStrikes, int expectedOuts) {
        mBalls = balls;
        mStrikes = strikes;
        mOuts = outs;
        mExpectedBalls = expectedBalls;
        mExpectedStrikes = expectedStrikes;
        mExpectedOuts = expectedOuts;
    }

    @Before
    public void setUp() {
        this.mBallStrikeCounter = new BallStrikeOutCounter();
        this.mBaseballActionNotifier = new BaseballActionNotifier();
        this.mBaseballActionNotifier.addActionListener(mBallStrikeCounter);
    }

    @Test
    public void testGivenSpecifiedCounts_whenActionBallPerformed_thenCountCorrectly() throws BallStrikeOutCounter.MaxValueReachedException {
        given: {
            mBallStrikeCounter.setBalls(mBalls);
            mBallStrikeCounter.setStrikes(mStrikes);
            mBallStrikeCounter.setOuts(mOuts);
        }

        when: {
            this.mBaseballActionNotifier.perform(BaseballActions.BALL);
        }

        then: {
            assertEquals(mExpectedBalls, mBallStrikeCounter.getBalls());
            assertEquals(mExpectedStrikes, mBallStrikeCounter.getStrikes());
            assertEquals(mExpectedOuts, mBallStrikeCounter.getOuts());
        }
    }
}
