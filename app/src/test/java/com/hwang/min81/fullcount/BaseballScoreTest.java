package com.hwang.min81.fullcount;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by min on 2015. 12. 27..
 */
public class BaseballScoreTest {

    @Test
    public void BaseballScoreShouldStartFromZero() throws Exception {
        BaseballScore baseballScore = new BaseballScore();
        Assert.assertEquals(0, baseballScore.getCurrentScore().intValue());
    }

    @Test
    public void EarningPointsAddsPointsToTheCurrentScore() throws Exception {
        BaseballScore baseballScore = new BaseballScore();

        Assert.assertEquals(1, baseballScore.earnPoints(1).intValue());
        Assert.assertEquals(1, baseballScore.getCurrentScore().intValue());

        Assert.assertEquals(3, baseballScore.earnPoints(2).intValue());
        Assert.assertEquals(3, baseballScore.getCurrentScore().intValue());

        Assert.assertEquals(6, baseballScore.earnPoints(3).intValue());
        Assert.assertEquals(6, baseballScore.getCurrentScore().intValue());

        Assert.assertEquals(10, baseballScore.earnPoints(4).intValue());
        Assert.assertEquals(10, baseballScore.getCurrentScore().intValue());
    }

    @Test
    public void ResultOfEarningPointsCannotExceedMaxOfInteger() throws Exception {
        BaseballScore baseballScore = new BaseballScore();
        baseballScore.setCurrentScore(Integer.MAX_VALUE);

        Assert.assertEquals(Integer.MAX_VALUE, baseballScore.earnPoints(1).intValue());
    }

    @Test
    public void EarningZeroPointRetainTheCurrentScore() throws Exception {
        BaseballScore baseballScore = new BaseballScore();
        Assert.assertEquals(0, baseballScore.earnPoints(0).intValue());
    }

    @Test
    public void EarningNegativePointRetainTheCurrentScore() throws Exception {
        BaseballScore baseballScore = new BaseballScore();
        Assert.assertEquals(0, baseballScore.earnPoints(-1).intValue());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void LoosingPointsIsNotSupportedInBaseball() throws Exception {
        BaseballScore baseballScore = new BaseballScore();
        baseballScore.loosePoints(1);
    }
}