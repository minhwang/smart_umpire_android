package com.hwang.min81.smartumpire.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hwang.min81.smartumpire.R;

/**
 * Created by min on 2016. 1. 22..
 */
public class TimerViewImpl extends FrameLayout implements TimerView {
    private CircularProgress cpTimeProgress;
    private TextView tvTime;

    public TimerViewImpl(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.timer_view, this, true);

        this.tvTime = (TextView)findViewById(R.id.tvTimeText);
        this.cpTimeProgress = (CircularProgress)findViewById(R.id.cpTimeProgress);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.TimerView, 0, 0);

        try {
            setTimeProgressDegree(a.getInteger(R.styleable.TimerView_timeProgressDegree, 0));
            setTimeText(a.getString(R.styleable.TimerView_timeText));
        } finally {
            a.recycle();
        }
    }

    @Override
    public void setTimeText(String time) {
        this.tvTime.setText(time);
    }

    @Override
    public void setTimeProgressDegree(int degree) {
        this.cpTimeProgress.setProgressDegree(degree);
    }
}
