package com.hwang.min81.fullcount;

import com.hwang.min81.fullcount.actions.BaseballActionListener;
import com.hwang.min81.fullcount.actions.BaseballActions;

/**
 * Created by min on 2016. 1. 3..
 */
public class PitchCounter implements BaseballActionListener {
    @Override
    public void baseballActionPerformed(BaseballActions action) {
        switch (action) {
            default:
                break;
        }
    }

    @Override
    public void baseballActionRestored(BaseballActions action) {

    }
}
