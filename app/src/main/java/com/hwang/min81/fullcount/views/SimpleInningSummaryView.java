package com.hwang.min81.fullcount.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hwang.min81.fullcount.R;

/**
 * Created by min on 2016. 3. 1..
 */
public class SimpleInningSummaryView extends LinearLayout implements InningSummaryView {
    private TextView mTextViewInning, mTextViewHomeSummary, mTextViewAwaySummary;

    public SimpleInningSummaryView(Context context) {
        super(context);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.simple_inning_summary_view, this, true);

        mTextViewInning = (TextView)findViewById(R.id.tvInning);
        mTextViewHomeSummary = (TextView)findViewById(R.id.tvHomeSummary);
        mTextViewAwaySummary = (TextView)findViewById(R.id.tvAwaySummary);
    }

    @Override
    public void setInning(int inning) {
        mTextViewInning.setText(String.valueOf(inning));
    }

    @Override
    public void setHomeSummary(String summary) {
        mTextViewHomeSummary.setText(summary);
    }

    @Override
    public void setAwaySummary(String summary) {
        mTextViewAwaySummary.setText(summary);
    }
}
