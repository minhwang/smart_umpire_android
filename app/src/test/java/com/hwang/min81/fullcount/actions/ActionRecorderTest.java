package com.hwang.min81.fullcount.actions;

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
        BaseballActionNotifier action1 = new BaseballActionNotifier();
        BaseballActionNotifier action2 = new BaseballActionNotifier();

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
        BaseballActionNotifier action1 = new BaseballActionNotifier();
        BaseballActionNotifier action2 = new BaseballActionNotifier();

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
        BaseballActionNotifier action;

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