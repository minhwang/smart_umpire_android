package com.hwang.min81.smartumpire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hwang.min81.smartumpire.controllers.TeamScoreController;
import com.hwang.min81.smartumpire.views.TeamScoreView;
import com.hwang.min81.smartumpire.views.TeamScoreViewImpl;

public class MainGameActivity extends AppCompatActivity implements TeamScoreController {
    private BaseballScore homeScore;
    private BaseballScore awayScore;
    private TeamScoreView homeScoreView;
    private TeamScoreView awayScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        this.homeScoreView = (TeamScoreViewImpl)findViewById(R.id.home_score_view);
        this.awayScoreView = (TeamScoreViewImpl)findViewById(R.id.away_score_view);

        Intent intent = getIntent();

        this.homeScore = new BaseballScore();
        this.homeScore.addListener(this);
        this.homeScore.setCurrentScore(intent.getIntExtra("homeScore", 0));
        this.awayScore = new BaseballScore();
        this.awayScore.addListener(this);
        this.awayScore.setCurrentScore(intent.getIntExtra("awayScore", 0));

        this.homeScoreView.setTeamName(intent.getStringExtra("homeTeamName"));
        this.awayScoreView.setTeamName(intent.getStringExtra("awayTeamName"));
    }

    @Override
    public void scoreChanged(Score score) {
        if(score.equals(this.homeScore)) { homeScoreChanged(); }
        else { awayScoreChanged(); }
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
}
