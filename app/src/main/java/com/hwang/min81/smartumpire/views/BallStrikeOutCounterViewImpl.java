package com.hwang.min81.smartumpire.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hwang.min81.smartumpire.R;

/**
 * Created by min on 2016. 1. 16..
 */
public class BallStrikeOutCounterViewImpl extends LinearLayout implements BallStrikeOutCounterView {
    private TextView[] tvBalls = new TextView[3];
    private TextView[] tvStrikes = new TextView[2];
    private TextView[] tvOuts = new TextView[2];
    private int ballOnColor;
    private int strikeOnColor;
    private int outOnColor;
    private int offColor;

    public BallStrikeOutCounterViewImpl(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.ball_strike_out_counter_view, this, true);

        this.tvBalls[0] = (TextView)findViewById(R.id.tvBall_1);
        this.tvBalls[1] = (TextView)findViewById(R.id.tvBall_2);
        this.tvBalls[2] = (TextView)findViewById(R.id.tvBall_3);
        this.tvStrikes[0] = (TextView)findViewById(R.id.tvStrike_1);
        this.tvStrikes[1] = (TextView)findViewById(R.id.tvStrike_2);
        this.tvOuts[0] = (TextView)findViewById(R.id.tvOut_1);
        this.tvOuts[1] = (TextView)findViewById(R.id.tvOut_2);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.BallStrikeOutCounterViewImpl, 0, 0);

        try {
            this.ballOnColor = a.getColor(R.styleable.BallStrikeOutCounterViewImpl_ballOnColor, Color.YELLOW);
            this.strikeOnColor = a.getColor(R.styleable.BallStrikeOutCounterViewImpl_strikeOnColor, Color.GREEN);
            this.outOnColor = a.getColor(R.styleable.BallStrikeOutCounterViewImpl_outOnColor, Color.RED);
            this.offColor = a.getColor(R.styleable.BallStrikeOutCounterViewImpl_offColor, Color.LTGRAY);
            setBalls(a.getInteger(R.styleable.BallStrikeOutCounterViewImpl_balls, 0));
            setStrikes(a.getInteger(R.styleable.BallStrikeOutCounterViewImpl_strikes, 0));
            setOuts(a.getInteger(R.styleable.BallStrikeOutCounterViewImpl_outs, 0));

        } finally {
            a.recycle();
        }
    }

    @Override public void setBalls(int balls) {
        for(int i = 0; i < 3; i++) {
            int color = i < balls ? this.ballOnColor : this.offColor;
            this.tvBalls[i].setTextColor(color);
        }
        invalidate();
        requestLayout();
    }

    @Override public void setStrikes(int strikes) {
        for(int i = 0; i < 2; i++) {
            int color = i < strikes ? this.strikeOnColor : this.offColor;
            this.tvStrikes[i].setTextColor(color);
        }
        invalidate();
        requestLayout();
    }

    @Override public void setOuts(int outs) {
        for(int i = 0; i < 2; i++) {
            int color = i < outs ? this.outOnColor : this.offColor;
            this.tvOuts[i].setTextColor(color);
        }
        invalidate();
        requestLayout();
    }
}
