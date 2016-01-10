package com.hwang.min81.smartumpire.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by min on 2016. 1. 1..
 */
public class BaseballAction {
    private List<BaseballActionListener> listeners = new ArrayList();
    private BaseballActions action;

    public BaseballAction(BaseballActions action) {
        this.action = action;
    }

    public void perform() {
        for(BaseballActionListener listener : listeners) {
            listener.performed(this.action);
        }
    }

    public void restore() {
        for(BaseballActionListener listener : listeners) {
            listener.restored(this.action);
        }
    }

    public void addActionListener(BaseballActionListener listener) {
        this.listeners.add(listener);
    }

    public void removeActionListener(BaseballActionListener listener) {
        this.listeners.remove(listener);
    }
}
