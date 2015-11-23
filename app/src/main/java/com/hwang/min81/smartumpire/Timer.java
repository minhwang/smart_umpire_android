package com.hwang.min81.smartumpire;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hwangmin on 2015. 11. 24..
 */
public class Timer {

    private long startTimeMillis = 0;
    private long timeMillisLeft = 0;

    void start() {
        this.startTimeMillis = System.currentTimeMillis();
    }

    public long getTimeMillisLeft() {
        this.timeMillisLeft = System.currentTimeMillis() - this.startTimeMillis;
        return this.timeMillisLeft;
    }

    public String getTimeMillisLeftAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        return dateFormat.format(new Date(this.timeMillisLeft));
    }
}
