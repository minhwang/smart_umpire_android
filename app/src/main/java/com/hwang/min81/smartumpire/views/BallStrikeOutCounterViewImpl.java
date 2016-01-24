package com.hwang.min81.smartumpire.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hwang.min81.smartumpire.R;

/**
 * Created by min on 2016. 1. 16..
 */
public class BallStrikeOutCounterViewImpl extends LinearLayout implements BallStrikeOutCounterView {
    private ImageView[] ivBalls = new ImageView[3];
    private ImageView[] ivStrikes = new ImageView[2];
    private ImageView[] ivOuts = new ImageView[2];
    private int ballOnColor;
    private int strikeOnColor;
    private int outOnColor;
    private int offColor;

    public BallStrikeOutCounterViewImpl(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.ball_strike_out_counter_view, this, true);

        this.ivBalls[0] = (ImageView)findViewById(R.id.ivBall_1);
        this.ivBalls[1] = (ImageView)findViewById(R.id.ivBall_2);
        this.ivBalls[2] = (ImageView)findViewById(R.id.ivBall_3);
        this.ivStrikes[0] = (ImageView)findViewById(R.id.ivStrike_1);
        this.ivStrikes[1] = (ImageView)findViewById(R.id.ivStrike_2);
        this.ivOuts[0] = (ImageView)findViewById(R.id.ivOut_1);
        this.ivOuts[1] = (ImageView)findViewById(R.id.ivOut_2);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.BallStrikeOutCounterView, 0, 0);

        try {
            this.ballOnColor = a.getColor(R.styleable.BallStrikeOutCounterView_ballOnColor, Color.YELLOW);
            this.strikeOnColor = a.getColor(R.styleable.BallStrikeOutCounterView_strikeOnColor, Color.GREEN);
            this.outOnColor = a.getColor(R.styleable.BallStrikeOutCounterView_outOnColor, Color.RED);
            this.offColor = a.getColor(R.styleable.BallStrikeOutCounterView_offColor, Color.LTGRAY);
            setBalls(a.getInteger(R.styleable.BallStrikeOutCounterView_balls, 0));
            setStrikes(a.getInteger(R.styleable.BallStrikeOutCounterView_strikes, 0));
            setOuts(a.getInteger(R.styleable.BallStrikeOutCounterView_outs, 0));

        } finally {
            a.recycle();
        }
    }

    @Override public void setBalls(int balls) {
        for(int i = 0; i < 3; i++) {
            int color = i < balls ? this.ballOnColor : this.offColor;
            ((GradientDrawable)this.ivBalls[i].getDrawable()).setColor(color);

        }
    }

    @Override public void setStrikes(int strikes) {
        for(int i = 0; i < 2; i++) {
            int color = i < strikes ? this.strikeOnColor : this.offColor;
            ((GradientDrawable)this.ivStrikes[i].getDrawable()).setColor(color);
        }
    }

    @Override public void setOuts(int outs) {
        for(int i = 0; i < 2; i++) {
            int color = i < outs ? this.outOnColor : this.offColor;
            ((GradientDrawable)this.ivOuts[i].getDrawable()).setColor(color);
        }
    }
}
