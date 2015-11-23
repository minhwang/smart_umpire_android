package com.hwang.min81.smartumpire;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hwangmin on 2015. 11. 24..
 */
public class TimerTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void sample() {
        Timer timer = new Timer();
        timer.start();
        Assert.assertEquals("", timer.getTimeMillisLeftAsString());
    }
}