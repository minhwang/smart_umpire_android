package com.hwang.min81.fullcount.actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 2016. 1. 1..
 */
public class BaseballActionNotifier {
    private List<BaseballActionListener> mListeners = new ArrayList();

    public void perform(BaseballActions action) {
        for(BaseballActionListener listener : mListeners) {
            listener.onBaseballActionPerformed(action);
        }
    }

    public void restore(BaseballActions action) {
        for(BaseballActionListener listener : mListeners) {
            listener.onBaseballActionRestored(action);
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
