package com.hwang.min81.smartumpire.actions;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by min on 2016. 1. 3..
 */
@SmallTest
public class ActionRecorderTest {
    @Test
    public void testPush_() {
        ActionRecorder recorder = new ActionRecorder();
        BaseballAction action1 = new BaseballAction(BaseballActions.BASE_ON_BALLS);
        BaseballAction action2 = new BaseballAction(BaseballActions.BALL);

        recorder.push(action1);
        recorder.push(action1);
        recorder.push(action2);

        assertEquals(action2, recorder.pop());
        assertEquals(action1, recorder.pop());
        assertEquals(action1, recorder.pop());
    }


    @Test
    public void testGiven10Actions_whenActionPushed_thenRemoveTheFirst() {
        ActionRecorder recorder = new ActionRecorder();
        BaseballAction action1 = new BaseballAction(BaseballActions.BASE_ON_BALLS);
        BaseballAction action2 = new BaseballAction(BaseballActions.BALL);

        given: {
            recorder.push(action1);
            recorder.push(action2);
            recorder.push(action2);
            recorder.push(action2);
            recorder.push(action2);
            recorder.push(action2);
            recorder.push(action2);
            recorder.push(action2);
            recorder.push(action2);
            recorder.push(action2);
        }

        when: {
            recorder.push(action2);

        }

        then: {
            assertEquals(action2, recorder.pop());
            assertEquals(action2, recorder.pop());
            assertEquals(action2, recorder.pop());
            assertEquals(action2, recorder.pop());
            assertEquals(action2, recorder.pop());
            assertEquals(action2, recorder.pop());
            assertEquals(action2, recorder.pop());
            assertEquals(action2, recorder.pop());
            assertEquals(action2, recorder.pop());
            assertEquals(action2, recorder.pop());
        }
    }

    @Test
    public void testGivenNoAction_whenPopped_thenReturnsNull() {
        ActionRecorder recorder;
        BaseballAction action;

        given: {
            recorder = new ActionRecorder();
        }

        when: {
            action = recorder.pop();
        }

        then: {
            assertNull(action);
        }
    }
}