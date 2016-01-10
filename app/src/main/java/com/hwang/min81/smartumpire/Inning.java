package com.hwang.min81.smartumpire;

/**
 * Created by min on 2016. 1. 9..
 */
public class Inning {
    private int inning;
    private boolean isTop;

    public Inning() {
        setInning(0);
        setIsTop(true);
    }
    public Inning(int inning, boolean isTop) {
        setInning(inning);
        setIsTop(isTop);
    }

    public void next() {
        int currentInning = getInning();
        boolean isTopCurrently = getIsTop();

        if(isTopCurrently == false) {
            setInning(currentInning + 1);
        }
        setIsTop(!isTopCurrently);
    }

    public void prev() {
        int currentInning = getInning();
        boolean isTopCurrently = getIsTop();

        if(currentInning == 0 && isTopCurrently == true) {
            return;
        }
        else if(isTopCurrently == true) {
            setInning(currentInning - 1);
        }
        setIsTop(!isTopCurrently);
    }

    public boolean getIsTop() {
        return this.isTop;
    }

    public int getInning() {
        return this.inning;
    }

    private void setInning(int inning) {
        this.inning = inning;
    }

    private void setIsTop(boolean isTop) {
        this.isTop = isTop;
    }
}
