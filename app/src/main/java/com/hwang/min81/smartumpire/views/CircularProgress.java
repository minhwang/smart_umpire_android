package com.hwang.min81.smartumpire.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.hwang.min81.smartumpire.R;

/**
 * Created by min on 2016. 1. 23..
 */
public class CircularProgress extends View {
    private int backColor;
    private int foreColor;
    private int progressColor;
    private int progressSize;
    private int x, y, r;
    private float progressDegree;

    public CircularProgress(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.CircularProgress, 0, 0);

        try {
            this.backColor = a.getColor(R.styleable.CircularProgress_backColor, Color.WHITE);
            this.foreColor = a.getColor(R.styleable.CircularProgress_foreColor, this.backColor);
            this.progressColor = a.getColor(R.styleable.CircularProgress_progressColor, Color.RED);
            this.progressSize = (int)toPixel(a.getInteger(R.styleable.CircularProgress_progressSize, 15));

        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.x = getWidth() / 2;
        this.y = this.x;
        this.r = this.x;

        Paint backCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backCirclePaint.setColor(this.backColor);
        canvas.drawCircle(this.x, this.y, this.r, backCirclePaint);

        drawArc(canvas);

        Paint foreCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        foreCirclePaint.setColor(this.foreColor);
        canvas.drawCircle(this.x, this.y, this.r - this.progressSize, foreCirclePaint);
    }

    public void setProgressDegree(int degree) {
        this.progressDegree = degree;
        invalidate();
    }

    private double toPixel(double dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    private void drawArc(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(this.progressColor);

        for(int i = -90; i < this.progressDegree - 90; i++) {
            float dX = (float)(this.r * Math.cos(Math.toRadians(i)));
            float dY = (float)(this.r * Math.sin(Math.toRadians(i)));
            canvas.drawLine(this.x, this.y, this.x + dX, this.y + dY, paint);
            
        }
    }
}
