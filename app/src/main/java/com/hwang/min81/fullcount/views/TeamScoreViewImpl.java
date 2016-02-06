package com.hwang.min81.fullcount.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hwang.min81.fullcount.R;

/**
 * Created by min on 2016. 1. 9..
 */
public class TeamScoreViewImpl extends LinearLayout implements TeamScoreView{
    private TextView tvTeamName;
    private TextView tvTeamScore;
    private ImageView ivBatPitch;

    public TeamScoreViewImpl(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.team_score_view, this, true);

        this.tvTeamName = (TextView)findViewById(R.id.tvTeamName);
        this.tvTeamScore = (TextView)findViewById(R.id.tvTeamScore);
        this.ivBatPitch = (ImageView)findViewById(R.id.ivBatPitch);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.TeamScoreView, 0, 0);

        try {
            setTeamName(a.getString(R.styleable.TeamScoreView_teamName));
            setTeamScore(a.getInteger(R.styleable.TeamScoreView_teamScore, 0));
            setTurn(a.getInteger(R.styleable.TeamScoreView_turn, 0));

        } finally {
            a.recycle();
        }
    }

    @Override public void setTeamName(String name) {
        this.tvTeamName.setText(name);
    }

    @Override public void setTeamScore(int score) {
        this.tvTeamScore.setText(String.valueOf(score));
    }

    @Override public void setTurn(int turn) {
        int batSrc = R.drawable.abc_ic_search_api_mtrl_alpha;
        int fieldSrc = R.drawable.abc_ic_menu_share_mtrl_alpha;
        int id = turn == 0 ? batSrc : fieldSrc;

        ivBatPitch.setImageResource(id);
    }
}
