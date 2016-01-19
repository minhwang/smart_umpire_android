package com.hwang.min81.smartumpire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hwang.min81.smartumpire.actions.BaseballAction;
import com.hwang.min81.smartumpire.actions.BaseballActions;
import com.hwang.min81.smartumpire.controllers.BallStrikeOutCounterController;
import com.hwang.min81.smartumpire.controllers.TeamScoreController;
import com.hwang.min81.smartumpire.views.BallStrikeOutCounterView;
import com.hwang.min81.smartumpire.views.TeamScoreView;

public class MainGameActivity extends AppCompatActivity implements TeamScoreController, BallStrikeOutCounterController {
    private BaseballScore homeScore;
    private BaseballScore awayScore;
    private TeamScoreView homeScoreView;
    private TeamScoreView awayScoreView;

    private BallStrikeOutCounter ballStrikeOutCounter;
    private BallStrikeOutCounterView ballStrikeOutCounterView;

    private BaseballAction ballAction;
    private BaseballAction strikeAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        this.homeScoreView = (TeamScoreView)findViewById(R.id.home_score_view);
        this.awayScoreView = (TeamScoreView)findViewById(R.id.away_score_view);
        this.ballStrikeOutCounterView = (BallStrikeOutCounterView)findViewById(R.id.ball_strike_out_counter_view);

        Intent intent = getIntent();

        this.homeScore = new BaseballScore();
        this.homeScore.addListener(this);
        this.homeScore.setCurrentScore(intent.getIntExtra("homeScore", 0));
        this.awayScore = new BaseballScore();
        this.awayScore.addListener(this);
        this.awayScore.setCurrentScore(intent.getIntExtra("awayScore", 0));

        this.homeScoreView.setTeamName(intent.getStringExtra("homeTeamName"));
        this.awayScoreView.setTeamName(intent.getStringExtra("awayTeamName"));

        this.ballStrikeOutCounter = new BallStrikeOutCounter();
        this.ballStrikeOutCounter.addListener(this);

        this.ballAction = new BaseballAction(BaseballActions.BALL);
        this.ballAction.addActionListener(this.ballStrikeOutCounter);
        this.strikeAction = new BaseballAction(BaseballActions.STRIKE);
        this.strikeAction.addActionListener(this.ballStrikeOutCounter);
    }

    @Override
    public void scoreChanged(Score score) {
        if(score.equals(this.homeScore)) { homeScoreChanged(); }
        else { awayScoreChanged(); }
    }

    @Override
    public void counterChanged(BallStrikeOutCounter counter) {
        this.ballStrikeOutCounterView.setBalls(counter.getBalls());
        this.ballStrikeOutCounterView.setStrikes(counter.getStrikes());
        this.ballStrikeOutCounterView.setOuts(counter.getOuts());
    }

    private void homeScoreChanged() {
        this.homeScoreView.setTeamScore(this.homeScore.getCurrentScore());
    }

    private void awayScoreChanged() {
        this.awayScoreView.setTeamScore(this.awayScore.getCurrentScore());
    }

    public void onHomeClick(View v) {
        this.homeScore.earnPoints(1);
    }

    public void onAwayClick(View v) {
        this.awayScore.earnPoints(1);
    }

    public void onCounterClick(View v) {
        this.ballAction.perform();
        this.strikeAction.perform();
    }
}
