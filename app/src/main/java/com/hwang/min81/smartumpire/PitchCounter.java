package com.hwang.min81.smartumpire;

import com.hwang.min81.smartumpire.actions.BaseballActionListener;
import com.hwang.min81.smartumpire.actions.BaseballActions;

/**
 * Created by min on 2016. 1. 3..
 */
public class PitchCounter implements BaseballActionListener {
    @Override
    public void performed(BaseballActions action) {
        switch (action) {
            default:
                break;
        }
    }

    @Override
    public void restored(BaseballActions action) {

    }
}
