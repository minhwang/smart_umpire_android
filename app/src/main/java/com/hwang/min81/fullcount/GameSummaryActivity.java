package com.hwang.min81.fullcount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.hwang.min81.fullcount.views.InningSummaryView;
import com.hwang.min81.fullcount.views.SimpleInningSummaryView;

public class GameSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_summary);

        LinearLayout ll = (LinearLayout)findViewById(R.id.inning_summary_layout);
        for(int i = 1; i <= 5; i++) {
            InningSummaryView isv = new SimpleInningSummaryView(this);
            isv.setInning(i);
            isv.setHomeSummary("asdfasdfasdf");
            isv.setAwaySummary("fjfjekkfksdlfkej");
            ll.addView((View)isv);
        }
    }
}
