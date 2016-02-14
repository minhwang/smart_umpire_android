package com.hwang.min81.fullcount;

import android.test.suitebuilder.annotation.SmallTest;

import com.hwang.min81.fullcount.actions.*;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by min81 on 2015-10-07.
 */
@SmallTest
public class BallStrikeOutCounterTest {
    @Test
    public void testWhenCreated_thenHasDefaultValues() {
        BallStrikeOutCounter ballStrikeOutCounter;

        when: {
            ballStrikeOutCounter = new BallStrikeOutCounter();
        }
        then: {
            assertEquals(0, ballStrikeOutCounter.getBalls());
            assertEquals(0, ballStrikeOutCounter.getStrikes());
            assertEquals(0, ballStrikeOutCounter.getOuts());
        }
    }

    @Test
    public void testGivenActionBall_whenActionPerformed_thenWillHandleIt() {
        BallStrikeOutCounter ballStrikeOutCounter;
        BaseballActionNotifier baseballActionNotifier;

        given: {
            ballStrikeOutCounter = new BallStrikeOutCounter();
            baseballActionNotifier = new BaseballActionNotifier();
            baseballActionNotifier.addActionListener(ballStrikeOutCounter);
        }

        when: {
            baseballActionNotifier.perform(BaseballActions.BALL);
        }

        then: {
            assertTrue(ballStrikeOutCounter.hasTheLastActionBeenHandled());
        }
    }

    @Test
    public void testGivenActionStrike_whenActionPerformed_thenWillHandleIt() {
        BallStrikeOutCounter ballStrikeOutCounter;
        BaseballActionNotifier baseballActionNotifier;

        given: {
            ballStrikeOutCounter = new BallStrikeOutCounter();
            baseballActionNotifier = new BaseballActionNotifier();
            baseballActionNotifier.addActionListener(ballStrikeOutCounter);
        }

        when: {
            baseballActionNotifier.perform(BaseballActions.STRIKE);
        }

        then: {
            assertTrue(ballStrikeOutCounter.hasTheLastActionBeenHandled());
        }
    }

    @Test
    public void testGivenActionHitByPitch_whenActionPerformed_thenWillHandleIt() {
        BallStrikeOutCounter ballStrikeOutCounter;
        BaseballActionNotifier baseballActionNotifier;

        given: {
            ballStrikeOutCounter = new BallStrikeOutCounter();
            baseballActionNotifier = new BaseballActionNotifier();
            baseballActionNotifier.addActionListener(ballStrikeOutCounter);
        }

        when: {
            baseballActionNotifier.perform(BaseballActions.HIT_BY_PITCH);
        }

        then: {
            assertTrue(ballStrikeOutCounter.hasTheLastActionBeenHandled());
        }
    }

    //// TODO: 2015-10-08 Parameterized test 고려해볼 필요 있음.
    @Test
    public void Ball_CanBeAssignedTheValue_0to3() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();

        ballStrikeOutCounter.setBalls((short) 0);
        assertEquals(0, ballStrikeOutCounter.getBalls());

        ballStrikeOutCounter.setBalls((short) 1);
        assertEquals(1, ballStrikeOutCounter.getBalls());

        ballStrikeOutCounter.setBalls((short) 2);
        assertEquals(2, ballStrikeOutCounter.getBalls());

        ballStrikeOutCounter.setBalls((short) 3);
        assertEquals(3, ballStrikeOutCounter.getBalls());
    }

    @Test
    public void Strike_CanBeAssignedTheValue_0to2() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();

        ballStrikeOutCounter.setStrikes((short) 0);
        assertEquals(0, ballStrikeOutCounter.getStrikes());

        ballStrikeOutCounter.setStrikes((short) 1);
        assertEquals(1, ballStrikeOutCounter.getStrikes());

        ballStrikeOutCounter.setStrikes((short) 2);
        assertEquals(2, ballStrikeOutCounter.getStrikes());
    }

    @Test
    public void Out_CanBeAssignedTheValue_0to2() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();

        ballStrikeOutCounter.setOuts((short) 0);
        assertEquals(0, ballStrikeOutCounter.getOuts());

        ballStrikeOutCounter.setOuts((short) 1);
        assertEquals(1, ballStrikeOutCounter.getOuts());

        ballStrikeOutCounter.setOuts((short) 2);
        assertEquals(2, ballStrikeOutCounter.getOuts());
    }

    // 아래 테스트는 2개의 입력값에 대한 테스트가 이루어지지 않음.
    // TODO 추후 다른 테스트 방법을 통해 개선되어야 함.
    @Test(expected = BallStrikeOutCounter.MaxValueReachedException.class)
    public void Ball_AssigningTheValueGreaterThan3_ThrowsOutOfRangeException() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setBalls((short) 4);
        ballStrikeOutCounter.setBalls((short) 5);
    }

    @Test(expected = BallStrikeOutCounter.MaxValueReachedException.class)
    public void Strike_AssigningTheValueGreaterThan2_ThrowsOutOfRangeException() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setStrikes((short) 3);
        ballStrikeOutCounter.setStrikes((short) 4);
    }

    @Test(expected = BallStrikeOutCounter.MaxValueReachedException.class)
    public void Out_AssigningTheValueGreaterThan2_ThrowsOutOfRangeException() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setOuts((short) 3);
        ballStrikeOutCounter.setOuts((short) 4);
    }
}
