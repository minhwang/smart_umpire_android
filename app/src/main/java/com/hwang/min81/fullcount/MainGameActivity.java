package com.hwang.min81.fullcount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hwang.min81.fullcount.actions.BaseballActionNotifier;
import com.hwang.min81.fullcount.actions.BaseballActions;
import com.hwang.min81.fullcount.controllers.BallStrikeOutCounterViewController;
import com.hwang.min81.fullcount.controllers.BaseballActionViewController;
import com.hwang.min81.fullcount.controllers.TimerController;
import com.hwang.min81.fullcount.views.BallStrikeOutCounterView;
import com.hwang.min81.fullcount.views.BaseballActionView;
import com.hwang.min81.fullcount.views.TeamScoreView;
import com.hwang.min81.fullcount.views.TimerView;

public class MainGameActivity extends AppCompatActivity implements BaseballActionViewController, BallStrikeOutCounterViewController, TimerController, View.OnClickListener, View.OnLongClickListener {
    private BaseballScore homeScore;
    private BaseballScore awayScore;
    private TeamScoreView homeScoreView;
    private TeamScoreView awayScoreView;
    private TimerView timerView;
    private BaseballActionView baseballActionView;

    private BallStrikeOutCounter ballStrikeOutCounter;
    private BallStrikeOutCounterView ballStrikeOutCounterView;

    private BaseballActionNotifier mBaseballActionNotifier;
    private BaseballActionNotifier ballAction;
    private BaseballActionNotifier strikeAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        this.homeScoreView = (TeamScoreView)findViewById(R.id.home_score_view);
        this.awayScoreView = (TeamScoreView)findViewById(R.id.away_score_view);
        this.ballStrikeOutCounterView = (BallStrikeOutCounterView)findViewById(R.id.ball_strike_out_counter_view);
        this.timerView = (TimerView)findViewById(R.id.timer_view);

        this.timerView.setTimeText("60분");
        this.timerView.setTimeProgressDegree(35);

        Intent intent = getIntent();

        this.homeScore = new BaseballScore();
        this.homeScore.setCurrentScore(intent.getIntExtra("homeScore", 0));
        this.awayScore = new BaseballScore();
        this.awayScore.setCurrentScore(intent.getIntExtra("awayScore", 0));

        this.homeScoreView.setTeamName(intent.getStringExtra("homeTeamName"));
        this.awayScoreView.setTeamName(intent.getStringExtra("awayTeamName"));

        this.ballStrikeOutCounter = new BallStrikeOutCounter();
        this.ballStrikeOutCounter.addListener(this);

        // TODO: 모든 액션을 BaseballAction에서 관리하도록 수정 필요
        mBaseballActionNotifier = new BaseballActionNotifier();
        mBaseballActionNotifier.addActionListener(this.ballStrikeOutCounter);
        //this.ballAction = new BaseballActionNotifier(BaseballActions.BALL);
        //this.ballAction.addActionListener(this);
        //this.strikeAction = new BaseballActionNotifier(BaseballActions.STRIKE);
        //this.strikeAction.addActionListener(this.ballStrikeOutCounter);

        // set longclicklisteners for menu button
        findViewById(R.id.btnManagingAction).setOnLongClickListener(this);
        findViewById(R.id.btnPitchingAction).setOnLongClickListener(this);
        findViewById(R.id.btnBattingAction).setOnLongClickListener(this);
        findViewById(R.id.btnFieldingAction).setOnLongClickListener(this);

        initBaseballActionView();
    }

    private void initBaseballActionView() {
        View baseballActionContentView = getLayoutInflater().inflate(R.layout.baseball_action_view, null);
        this.baseballActionView = new BaseballActionView(baseballActionContentView);
        this.baseballActionView.setAnchor(BaseballActionPager.PITCHING, findViewById(R.id.btnPitchingAction));
        this.baseballActionView.setAnchor(BaseballActionPager.BATTING, findViewById(R.id.btnBattingAction));
        this.baseballActionView.setAnchor(BaseballActionPager.FIELDING, findViewById(R.id.btnFieldingAction));
        this.baseballActionView.setAnchor(BaseballActionPager.MANAGING, findViewById(R.id.btnManagingAction));

        this.baseballActionView.setOnPerformActionListener(this);
        this.baseballActionView.setOnRestoreActionListener(this);
    }

    @Override
    public void onCounterChanged(BallStrikeOutCounter counter) {
        this.ballStrikeOutCounterView.setBalls(counter.getBalls());
        this.ballStrikeOutCounterView.setStrikes(counter.getStrikes());
        this.ballStrikeOutCounterView.setOuts(counter.getOuts());
    }

    @Override
    public boolean onLongClick(View v) {
        BaseballActionPager baseballActionPager;

        switch (v.getId()) {
            case R.id.btnPitchingAction:
                baseballActionPager = BaseballActionPager.PITCHING;
                break;
            case R.id.btnBattingAction:
                baseballActionPager = BaseballActionPager.BATTING;
                break;
            case R.id.btnFieldingAction:
                baseballActionPager = BaseballActionPager.FIELDING;
                break;
            case R.id.btnManagingAction:
                baseballActionPager = BaseballActionPager.MANAGING;
                break;
            default:
                return false;
        }

        this.baseballActionView.showAbove(baseballActionPager);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPerformStrike:
                this.strikeAction.perform(BaseballActions.STRIKE);
                break;
            case R.id.btnPerformBall:
                this.ballAction.perform(BaseballActions.BALL);
                break;
            case R.id.btnPerformSummary:
                Intent i = new Intent(this, GameSummaryActivity.class);
                startActivity(i);
            default:
                break;
        }
        this.baseballActionView.dismiss();
    }
}
