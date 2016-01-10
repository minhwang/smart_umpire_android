package com.hwang.min81.smartumpire.actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 2016. 1. 3..
 */
public class ActionRecorder {
    private final int MAX_ACTIONS_TO_RECORD = 10;
    private List<BaseballAction> actions = new ArrayList<>();

    public void push(BaseballAction action) {
        if(this.actions.size() >= this.MAX_ACTIONS_TO_RECORD) {
            this.actions.remove(0);
        }
        // TODO: Transaction?
        this.actions.add(action);
    }

    public BaseballAction pop() {
        BaseballAction action = null;
        int location = this.actions.size() - 1;

        if(location >= 0) {
            action = this.actions.get(location);
            this.actions.remove(location);
        }
        return action;
    }
}