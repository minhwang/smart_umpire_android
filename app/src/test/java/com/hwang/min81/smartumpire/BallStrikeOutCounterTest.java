package com.hwang.min81.smartumpire;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by min81 on 2015-10-07.
 */
public class BallStrikeOutCounterTest {
    @Test
    public void Ball_CanDeliverTheDefaultValue_0() {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        assertEquals(0, ballStrikeOutCounter.getBall());
    }

    @Test
    public void Strike_CanDeliverTheDefaultValue_0() {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        assertEquals(0, ballStrikeOutCounter.getStrike());
    }

    @Test
    public void Out_CanDeliverTheDefaultValue_0() {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        assertEquals(0, ballStrikeOutCounter.getOut());
    }

    /*
     * setBall() 함수가 예외를 발생시키도록 수정되면서 함수 시그너처가 바뀌었음.
    @Test
    public void Ball_CanBeAssignedTheValue_0to3() {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();

        ballStrikeOutCounter.setBall((short)0);
        assertEquals(0, ballStrikeOutCounter.getBall());

        ballStrikeOutCounter.setBall((short)1);
        assertEquals(1, ballStrikeOutCounter.getBall());

        ballStrikeOutCounter.setBall((short)2);
        assertEquals(2, ballStrikeOutCounter.getBall());

        ballStrikeOutCounter.setBall((short)3);
        assertEquals(3, ballStrikeOutCounter.getBall());
    }
    */

    //// TODO: 2015-10-08 Parameterized test 고려해볼 필요 있음.
    @Test
    public void Ball_CanBeAssignedTheValue_0to3() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();

        ballStrikeOutCounter.setBall((short)0);
        assertEquals(0, ballStrikeOutCounter.getBall());

        ballStrikeOutCounter.setBall((short)1);
        assertEquals(1, ballStrikeOutCounter.getBall());

        ballStrikeOutCounter.setBall((short)2);
        assertEquals(2, ballStrikeOutCounter.getBall());

        ballStrikeOutCounter.setBall((short)3);
        assertEquals(3, ballStrikeOutCounter.getBall());
    }

    @Test
    public void Strike_CanBeAssignedTheValue_0to2() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();

        ballStrikeOutCounter.setStrike((short) 0);
        assertEquals(0, ballStrikeOutCounter.getStrike());

        ballStrikeOutCounter.setStrike((short) 1);
        assertEquals(1, ballStrikeOutCounter.getStrike());

        ballStrikeOutCounter.setStrike((short) 2);
        assertEquals(2, ballStrikeOutCounter.getStrike());
    }

    @Test
    public void Out_CanBeAssignedTheValue_0to2() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();

        ballStrikeOutCounter.setOut((short) 0);
        assertEquals(0, ballStrikeOutCounter.getOut());

        ballStrikeOutCounter.setOut((short) 1);
        assertEquals(1, ballStrikeOutCounter.getOut());

        ballStrikeOutCounter.setOut((short) 2);
        assertEquals(2, ballStrikeOutCounter.getOut());
    }

    // 아래 테스트는 2개의 입력값에 대한 테스트가 이루어지지 않음.
    // TODO 추후 다른 테스트 방법을 통해 개선되어야 함.
    @Test(expected = BallStrikeOutCounter.OutOfRangeException.class)
    public void Ball_AssigningTheValueGreaterThan3_ThrowsOutOfRangeException() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setBall((short) 4);
        ballStrikeOutCounter.setBall((short) 5);
    }

    @Test(expected = BallStrikeOutCounter.OutOfRangeException.class)
    public void Strike_AssigningTheValueGreaterThan2_ThrowsOutOfRangeException() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setStrike((short) 3);
        ballStrikeOutCounter.setStrike((short) 4);
    }

    @Test(expected = BallStrikeOutCounter.OutOfRangeException.class)
    public void Out_AssigningTheValueGreaterThan2_ThrowsOutOfRangeException() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setOut((short) 3);
        ballStrikeOutCounter.setOut((short) 4);
    }

    @Test
    public void addOneStrike_whenStrikeIs0_shouldIncreaseBy1() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 0;

        ballStrikeOutCounter.setStrike(givenStrike);

        ballStrikeOutCounter.addOneStrike();

        assertEquals(givenStrike + 1, ballStrikeOutCounter.getStrike());
    }

    @Test
    public void addOneStrike_whenStrikeIs1_shouldIncreaseBy1() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 1;

        ballStrikeOutCounter.setStrike(givenStrike);

        ballStrikeOutCounter.addOneStrike();

        assertEquals(givenStrike + 1, ballStrikeOutCounter.getStrike());
    }

    @Test
    public void addOneStrike_whenStrikeIs2_BallIs1_OutIs0_shouldResetStrikeAndBall_andAddOneOut() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 2, givenBall = 1, givenOut = 0;

        ballStrikeOutCounter.setStrike(givenStrike);
        ballStrikeOutCounter.setBall(givenBall);
        ballStrikeOutCounter.setOut(givenOut);

        ballStrikeOutCounter.addOneStrike();

        assertEquals(0, ballStrikeOutCounter.getStrike());
        assertEquals(0, ballStrikeOutCounter.getBall());
        assertEquals(givenOut + 1, ballStrikeOutCounter.getOut());
    }

    @Test
    public void addOneOut_whenOutIs0_shouldIncreaseBy1() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenOut = 0;

        ballStrikeOutCounter.setOut(givenOut);

        ballStrikeOutCounter.addOneOut();

        assertEquals(givenOut + 1, ballStrikeOutCounter.getOut());
    }

    @Test
    public void addOneOut_whenOutIs1_shouldIncreaseBy1() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenOut = 1;

        ballStrikeOutCounter.setOut(givenOut);

        ballStrikeOutCounter.addOneOut();

        assertEquals(givenOut + 1, ballStrikeOutCounter.getOut());
    }

    @Test
    public void addOneOut_whenOutIs2_shouldResetAll() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 2, givenBall = 1, givenOut = 2;

        ballStrikeOutCounter.setStrike(givenStrike);
        ballStrikeOutCounter.setBall(givenBall);
        ballStrikeOutCounter.setOut(givenOut);

        ballStrikeOutCounter.addOneOut();

        assertEquals(0, ballStrikeOutCounter.getStrike());
        assertEquals(0, ballStrikeOutCounter.getBall());
        assertEquals(0, ballStrikeOutCounter.getOut());
    }

    @Test
    public void addOneBall_whenBallIs0_shouldIncreaseBy1() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenBall = 0;

        ballStrikeOutCounter.setBall(givenBall);

        ballStrikeOutCounter.addOneBall();

        assertEquals(givenBall + 1, ballStrikeOutCounter.getBall());
    }

    @Test
    public void addOneBall_whenBallIs1_shouldIncreaseBy1() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenBall = 1;

        ballStrikeOutCounter.setBall(givenBall);

        ballStrikeOutCounter.addOneBall();

        assertEquals(givenBall + 1, ballStrikeOutCounter.getBall());
    }

    @Test
    public void addOneBall_whenBallIs2_shouldIncreaseBy1() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenBall = 2;

        ballStrikeOutCounter.setBall(givenBall);

        ballStrikeOutCounter.addOneBall();

        assertEquals(givenBall + 1, ballStrikeOutCounter.getBall());
    }

    @Test
    public void addOneBall_whenBallIs3_shouldResetBallAndStrike() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenBall = 3, givenStrike = 1;

        ballStrikeOutCounter.setBall(givenBall);
        ballStrikeOutCounter.setStrike(givenStrike);

        ballStrikeOutCounter.addOneBall();

        assertEquals(0, ballStrikeOutCounter.getBall());
        assertEquals(0, ballStrikeOutCounter.getStrike());
    }

    @Test
    public void addOneStrike_whenStrikeIs2AndOutIs2_shouldResetAll() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        final short givenStrike = 2, givenOut = 2, givenBall = 2;

        ballStrikeOutCounter.setStrike(givenStrike);
        ballStrikeOutCounter.setBall(givenBall);
        ballStrikeOutCounter.setOut(givenOut);

        ballStrikeOutCounter.addOneStrike();

        assertEquals(0, ballStrikeOutCounter.getStrike());
        assertEquals(0, ballStrikeOutCounter.getBall());
        assertEquals(0, ballStrikeOutCounter.getOut());


    }
}
