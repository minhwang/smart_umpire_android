package com.hwang.min81.smartumpire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, MainGameActivity.class);
        intent.putExtra("homeTeamName", "스나이퍼");
        intent.putExtra("awayTeamName", "이글스");
        intent.putExtra("homeScore", 3);
        intent.putExtra("awayScore", 2);

        startActivity(intent);
    }
}
