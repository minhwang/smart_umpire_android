package com.hwang.min81.fullcount.actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 2016. 1. 1..
 */
public class BaseballAction {
    private List<BaseballActionListener> mListeners = new ArrayList();
    private BaseballActions action;

    public BaseballAction(BaseballActions action) {
        this.action = action;
    }

    public void perform() {
        for(BaseballActionListener listener : mListeners) {
            listener.onBaseballActionPerformed(this.action);
        }
    }

    public void restore() {
        for(BaseballActionListener listener : mListeners) {
            listener.onBaseballActionRestored(this.action);
        }
    }

    public void addActionListener(BaseballActionListener listener) {
        mListeners.add(listener);
    }

    public void removeActionListener(BaseballActionListener listener) {
        mListeners.remove(listener);
    }

    public interface BaseballActionListener {
        void onBaseballActionPerformed(BaseballActions action);
        void onBaseballActionRestored(BaseballActions action);
    }
}
