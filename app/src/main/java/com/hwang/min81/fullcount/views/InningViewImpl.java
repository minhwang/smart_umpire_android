package com.hwang.min81.fullcount.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hwang.min81.fullcount.R;

/**
 * Created by min on 2016. 1. 9..
 */
public class InningViewImpl extends LinearLayout implements InningView {
    private TextView tvInning;
    private TextView tvTopBottom;

    public InningViewImpl(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.inning_view, this, true);

        this.tvInning = (TextView)findViewById(R.id.tvInning);
        this.tvTopBottom = (TextView)findViewById(R.id.tvTopBottom);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.InningView, 0, 0);

        try {
            setInning(a.getInteger(R.styleable.InningView_inning, 0));
            setTopBottom(a.getInteger(R.styleable.InningView_topBottom, 0));

        } finally {
            a.recycle();
        }
    }

    @Override public void setInning(int inning) {
        this.tvInning.setText(String.valueOf(inning));
        invalidate();
        requestLayout();
    }

    @Override public void setTopBottom(int topBottom) {
        String str = topBottom == 0 ? "TOP" : "BOT";
        tvTopBottom.setText(str);
        invalidate();
        requestLayout();
    }
}
