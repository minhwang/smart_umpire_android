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

    // 아래 테스트는 2개의 입력값에 대한 테스트가 이루어지지 않음.
    // TODO 추후 다른 테스트 방법을 통해 개선되어야 함.
    @Test(expected = BallStrikeOutCounter.OutOfRangeException.class)
    public void Ball_AssigningTheValueGreaterThan3_ThrowsOverflowException() throws BallStrikeOutCounter.OutOfRangeException {
        BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
        ballStrikeOutCounter.setBall((short)4);
        ballStrikeOutCounter.setBall((short)5);
    }
}
