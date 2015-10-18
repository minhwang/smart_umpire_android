package com.hwang.min81.smartumpire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BallStrikeOutCounterActivity extends AppCompatActivity {
    private BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();
    private TextView txtBallCount, txtStrikeCount, txtOutCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_strike_out_counter);

        this.txtBallCount = (TextView)findViewById(R.id.txtBallCount);
        this.txtStrikeCount = (TextView)findViewById(R.id.txtStrikeCount);
        this.txtOutCount = (TextView)findViewById(R.id.txtOutCount);

        this.txtBallCount.setText(String.valueOf(this.ballStrikeOutCounter.getBall()));
        this.txtStrikeCount.setText(String.valueOf(this.ballStrikeOutCounter.getStrike()));
        this.txtOutCount.setText(String.valueOf(this.ballStrikeOutCounter.getOut()));
    }

    public void onClickAddBall(View v) {
        try {
            this.ballStrikeOutCounter.addOneBall();
            this.txtBallCount.setText(String.valueOf(this.ballStrikeOutCounter.getBall()));
            this.txtStrikeCount.setText(String.valueOf(this.ballStrikeOutCounter.getStrike()));
            this.txtOutCount.setText(String.valueOf(this.ballStrikeOutCounter.getOut()));
        } catch (BallStrikeOutCounter.OutOfRangeException e) {
            e.printStackTrace();
        }
    }

    public void onClickAddStrike(View v) {
        try {
            this.ballStrikeOutCounter.addOneStrike();
            this.txtBallCount.setText(String.valueOf(this.ballStrikeOutCounter.getBall()));
            this.txtStrikeCount.setText(String.valueOf(this.ballStrikeOutCounter.getStrike()));
            this.txtOutCount.setText(String.valueOf(this.ballStrikeOutCounter.getOut()));
        } catch (BallStrikeOutCounter.OutOfRangeException e) {
            e.printStackTrace();
        }
    }

    public void onClickAddOut(View v) {
        try {
            this.ballStrikeOutCounter.addOneOut();
            this.txtBallCount.setText(String.valueOf(this.ballStrikeOutCounter.getBall()));
            this.txtStrikeCount.setText(String.valueOf(this.ballStrikeOutCounter.getStrike()));
            this.txtOutCount.setText(String.valueOf(this.ballStrikeOutCounter.getOut()));
        } catch (BallStrikeOutCounter.OutOfRangeException e) {
            e.printStackTrace();
        }
    }
}
