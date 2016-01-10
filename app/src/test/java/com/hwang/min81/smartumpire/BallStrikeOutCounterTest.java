package com.hwang.min81.smartumpire;

import android.test.suitebuilder.annotation.SmallTest;

import com.hwang.min81.smartumpire.actions.*;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by min81 on 2015-10-07.
 */
@SmallTest
public class BallStrikeOutCounterTest {
    @Test
    public void testWhenCreated_thenHasDefaultValues() {
        BallStrikeOutCounter counter;

        when: {
            counter = new BallStrikeOutCounter();
        }
        then: {
            assertEquals(0, counter.getBalls());
            assertEquals(0, counter.getStrikes());
            assertEquals(0, counter.getOuts());
        }
    }

    @Test
    public void testGivenActionBall_whenActionPerformed_thenWillHandleIt() {
        BallStrikeOutCounter counter;
        BaseballAction baseballActionBall;

        given: {
            counter = Mockito.mock(BallStrikeOutCounter.class);
            baseballActionBall = new BaseballAction(BaseballActions.BALL);
            baseballActionBall.addActionListener(counter);
        }

        when: {
            baseballActionBall.perform();
            baseballActionBall.restore();
        }

        then: {
            verify(counter).performed(BaseballActions.BALL);
            verify(counter).restored(BaseballActions.BALL);
        }
    }

    @Test
    public void testGivenActionBall_whenActionPerformed_thenIncreasesBallsByOne() {
        BallStrikeOutCounter counter;
        BaseballAction baseballActionBall;

        given: {
            counter = new BallStrikeOutCounter();
            baseballActionBall = new BaseballAction(BaseballActions.BALL);
            baseballActionBall.addActionListener(counter);
        }

        when: {
            baseballActionBall.perform();
        }

        then: {
            assertEquals(1, counter.getBalls());
        }
    }

    @Test
    public void testGivenActionStrike_whenActionPerformed_thenWillHandleIt() {
        BallStrikeOutCounter counter;
        BaseballAction baseballActionStrike;

        given: {
            counter = Mockito.mock(BallStrikeOutCounter.class);
            baseballActionStrike = new BaseballAction(BaseballActions.STRIKE);
            baseballActionStrike.addActionListener(counter);
        }

        when: {
            baseballActionStrike.perform();
            baseballActionStrike.restore();
        }

        then: {
            verify(counter).performed(BaseballActions.STRIKE);
            verify(counter).restored(BaseballActions.STRIKE);
        }
    }

    @Test
    public void testGivenActionStrike_whenActionPerformed_thenIncreasesBallsByOne() {
        BallStrikeOutCounter counter;
        BaseballAction baseballActionStrike   ;

        given: {
            counter = new BallStrikeOutCounter();
            baseballActionStrike = new BaseballAction(BaseballActions.STRIKE);
            baseballActionStrike.addActionListener(counter);
        }

        when: {
            baseballActionStrike.perform();
        }

        then: {
            assertEquals(1, counter.getStrikes());
        }
    }

    @Test
    public void testGivenActionBaseOnBalls_whenActionPerformed_thenWillHandleIt() {
        BallStrikeOutCounter counter;
        BaseballAction baseballActionStrike;

        given: {
            counter = Mockito.mock(BallStrikeOutCounter.class);
            baseballActionStrike = new BaseballAction(BaseballActions.BASE_ON_BALLS);
            baseballActionStrike.addActionListener(counter);
        }

        when: {
            baseballActionStrike.perform();
            baseballActionStrike.restore();
        }

        then: {
            verify(counter).performed(BaseballActions.BASE_ON_BALLS);
            verify(counter).restored(BaseballActions.BASE_ON_BALLS);
        }
    }

    @Test
    public void testGivenActionBaseOnBalls_whenActionPerformed_thenResetBallsAndStrikes() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter counter;
        BaseballAction baseballActionStrike   ;

        given: {
            counter = new BallStrikeOutCounter();
            counter.setBalls(1);
            counter.setStrikes(1);
            baseballActionStrike = new BaseballAction(BaseballActions.BASE_ON_BALLS);
            baseballActionStrike.addActionListener(counter);
        }

        when: {
            baseballActionStrike.perform();
        }

        then: {
            assertEquals(0, counter.getBalls());
            assertEquals(0, counter.getStrikes());
        }
    }



    /*
     * setBalls() 함수가 예외를 발생시키도록 수정되면서 함수 시그너처가 바뀌었음.
    @Test
    public void Ball_CanBeAssignedTheValue_0to3() {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();

        ballStrikeOutCounter.setBalls((short)0);
        assertEquals(0, ballStrikeOutCounter.getBalls());

        ballStrikeOutCounter.setBalls((short)1);
        assertEquals(1, ballStrikeOutCounter.getBalls());

        ballStrikeOutCounter.setBalls((short)2);
        assertEquals(2, ballStrikeOutCounter.getBalls());

        ballStrikeOutCounter.setBalls((short)3);
        assertEquals(3, ballStrikeOutCounter.getBalls());
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

    @Test
    public void addOneStrike_whenStrikeIs0_shouldIncreaseBy1() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 0;

        ballStrikeOutCounter.setStrikes(givenStrike);

        ballStrikeOutCounter.addOneStrike();

        assertEquals(givenStrike + 1, ballStrikeOutCounter.getStrikes());
    }

    @Test
    public void addOneStrike_whenStrikeIs1_shouldIncreaseBy1() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 1;

        ballStrikeOutCounter.setStrikes(givenStrike);

        ballStrikeOutCounter.addOneStrike();

        assertEquals(givenStrike + 1, ballStrikeOutCounter.getStrikes());
    }

    @Test
    public void addOneStrike_whenStrikeIs2_BallIs1_OutIs0_shouldResetStrikeAndBall_andAddOneOut() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 2, givenBall = 1, givenOut = 0;

        ballStrikeOutCounter.setStrikes(givenStrike);
        ballStrikeOutCounter.setBalls(givenBall);
        ballStrikeOutCounter.setOuts(givenOut);

        ballStrikeOutCounter.addOneStrike();

        assertEquals(0, ballStrikeOutCounter.getStrikes());
        assertEquals(0, ballStrikeOutCounter.getBalls());
        assertEquals(givenOut + 1, ballStrikeOutCounter.getOuts());
    }

    @Test
    public void addOneOut_whenOutIs0_shouldIncreaseBy1() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenOut = 0;

        ballStrikeOutCounter.setOuts(givenOut);

        ballStrikeOutCounter.addOneOut();

        assertEquals(givenOut + 1, ballStrikeOutCounter.getOuts());
    }

    @Test
    public void addOneOut_whenOutIs1_shouldIncreaseBy1() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenOut = 1;

        ballStrikeOutCounter.setOuts(givenOut);

        ballStrikeOutCounter.addOneOut();

        assertEquals(givenOut + 1, ballStrikeOutCounter.getOuts());
    }

    @Test
    public void addOneOut_whenOutIs2_shouldResetAll() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 2, givenBall = 1, givenOut = 2;

        ballStrikeOutCounter.setStrikes(givenStrike);
        ballStrikeOutCounter.setBalls(givenBall);
        ballStrikeOutCounter.setOuts(givenOut);

        ballStrikeOutCounter.addOneOut();

        assertEquals(0, ballStrikeOutCounter.getStrikes());
        assertEquals(0, ballStrikeOutCounter.getBalls());
        assertEquals(0, ballStrikeOutCounter.getOuts());
    }

    @Test
    public void addOneBall_whenBallIs0_shouldIncreaseBy1() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenBall = 0;

        ballStrikeOutCounter.setBalls(givenBall);

        ballStrikeOutCounter.addOneBall();

        assertEquals(givenBall + 1, ballStrikeOutCounter.getBalls());
    }

    @Test
    public void addOneBall_whenBallIs1_shouldIncreaseBy1() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenBall = 1;

        ballStrikeOutCounter.setBalls(givenBall);

        ballStrikeOutCounter.addOneBall();

        assertEquals(givenBall + 1, ballStrikeOutCounter.getBalls());
    }

    @Test
    public void addOneBall_whenBallIs2_shouldIncreaseBy1() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenBall = 2;

        ballStrikeOutCounter.setBalls(givenBall);

        ballStrikeOutCounter.addOneBall();

        assertEquals(givenBall + 1, ballStrikeOutCounter.getBalls());
    }

    @Test
    public void addOneBall_whenBallIs3_shouldResetBallAndStrike() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenBall = 3, givenStrike = 1;

        ballStrikeOutCounter.setBalls(givenBall);
        ballStrikeOutCounter.setStrikes(givenStrike);

        ballStrikeOutCounter.addOneBall();

        assertEquals(0, ballStrikeOutCounter.getBalls());
        assertEquals(0, ballStrikeOutCounter.getStrikes());
    }

    @Test
    public void addOneStrike_whenStrikeIs2AndOutIs2_shouldResetAll() throws BallStrikeOutCounter.MaxValueReachedException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 2, givenOut = 2, givenBall = 2;

        ballStrikeOutCounter.setStrikes(givenStrike);
        ballStrikeOutCounter.setBalls(givenBall);
        ballStrikeOutCounter.setOuts(givenOut);

        ballStrikeOutCounter.addOneStrike();

        assertEquals(0, ballStrikeOutCounter.getStrikes());
        assertEquals(0, ballStrikeOutCounter.getBalls());
        assertEquals(0, ballStrikeOutCounter.getOuts());
    }
*/
}
