package com.hwang.min81.smartumpire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private BallStrikeOutCounter ballStrikeOutCounter = new BallStrikeOutCounter();

    // baseball actions
    private BaseballActionBall baseballActionBall;
    private BaseballActionStrike baseballActionStrike;
    private BaseballActionHit baseballActionHit;
    private BaseballActionBatterOut baseballActionBatterOut;
    private BaseballActionRunnerOut baseballActionRunnerOut;
    private BaseballActionWalkToBase baseballActionWalkToBase;

    private TextView txtBallCount, txtStrikeCount, txtOutCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtBallCount = (TextView)findViewById(R.id.txtBallCount);
        this.txtStrikeCount = (TextView)findViewById(R.id.txtStrikeCount);
        this.txtOutCount = (TextView)findViewById(R.id.txtOutCount);

        ShowBallStrikeOutCount();

        this.baseballActionBall = new BaseballActionBall(this.ballStrikeOutCounter);
        this.baseballActionStrike = new BaseballActionStrike(this.ballStrikeOutCounter);
        this.baseballActionHit = new BaseballActionHit(this.ballStrikeOutCounter);
        this.baseballActionBatterOut =  new BaseballActionBatterOut(this.ballStrikeOutCounter);
        this.baseballActionRunnerOut = new BaseballActionRunnerOut(this.ballStrikeOutCounter);
        this.baseballActionWalkToBase = new BaseballActionWalkToBase(this.ballStrikeOutCounter);
    }

    private void ShowBallStrikeOutCount() {
        this.txtBallCount.setText(String.valueOf(this.ballStrikeOutCounter.getBall()));
        this.txtStrikeCount.setText(String.valueOf(this.ballStrikeOutCounter.getStrike()));
        this.txtOutCount.setText(String.valueOf(this.ballStrikeOutCounter.getOut()));
    }

    public void onClickAddBall(View v) {
        try {
            this.ballStrikeOutCounter.addOneBall();
            ShowBallStrikeOutCount();
        } catch (BallStrikeOutCounter.OutOfRangeException e) {
            e.printStackTrace();
        }
    }

    public void onClickAddStrike(View v) {
        try {
            this.ballStrikeOutCounter.addOneStrike();
            ShowBallStrikeOutCount();
        } catch (BallStrikeOutCounter.OutOfRangeException e) {
            e.printStackTrace();
        }
    }

    public void onClickAddOut(View v) {
        try {
            this.ballStrikeOutCounter.addOneOut();
            ShowBallStrikeOutCount();
        } catch (BallStrikeOutCounter.OutOfRangeException e) {
            e.printStackTrace();
        }
    }

    public void onClickAction(View v) throws BallStrikeOutCounter.OutOfRangeException {
        int widgetId = v.getId();

        switch (widgetId) {
            case R.id.button_action_ball:
                this.baseballActionBall.perform();
                break;
            case R.id.button_action_strike:
                this.baseballActionStrike.perform();
                break;
            case R.id.button_action_hit:
                this.baseballActionHit.perform();
                break;
            case R.id.button_action_batter_out:
                this.baseballActionBatterOut.perform();
                break;
            case R.id.button_action_runner_out:
                this.baseballActionRunnerOut.perform();
                break;
            case R.id.button_action_walk:
                this.baseballActionWalkToBase.perform();
                break;
            default:
                break;
        }


        ShowBallStrikeOutCount();
    }
}
