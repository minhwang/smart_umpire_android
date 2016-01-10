package com.hwang.min81.smartumpire;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by min on 2016. 1. 9..
 */
public class InningTest {

    @Test
    public void testGivenDefaultInning_whenCreated_thenInningIsZeroAndTopIsTrue() throws Exception {
        Inning inning;
        int currentInning;
        boolean isTopCurrently;

        given: {
            inning = new Inning();
        }

        when: {
            currentInning = inning.getInning();
            isTopCurrently = inning.getIsTop();
        }

        then: {
            assertEquals(true, isTopCurrently);
            assertEquals(0, currentInning);
        }
    }

    @Test
    public void testGivenTopIsTrue_whenNext_thenTopIsFalseAndNoChangeInInning() throws Exception {
        Inning inning;

        given: {
            inning = new Inning(0, true);
        }

        when: {
            inning.next();
        }

        then: {
            assertEquals(false, inning.getIsTop());
            assertEquals(0, inning.getInning());
        }
    }

    @Test
    public void testGivenTopIsFalse_whenNext_thenTopIsTrueAndIncreaseInningByOne() throws Exception {
        Inning inning;

        given: {
            inning = new Inning(0, false);
        }

        when: {
            inning.next();
        }

        then: {
            assertEquals(true, inning.getIsTop());
            assertEquals(1, inning.getInning());
        }
    }

    @Test
    public void testGivenInningIsZeroAndTopIsTrue_whenPrev_thenRetainTheValues() throws Exception {
        Inning inning;

        given: {
            inning = new Inning(0, true);
        }

        when: {
            inning.prev();
        }

        then: {
            assertEquals(true, inning.getIsTop());
            assertEquals(0, inning.getInning());
        }
    }
}