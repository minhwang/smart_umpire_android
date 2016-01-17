package com.hwang.min81.smartumpire.actions;

/**
 * Created by min on 2016. 1. 1..
 */
public interface BaseballActionListener {
    void performed(BaseballActions action);
    void restored(BaseballActions action);
}