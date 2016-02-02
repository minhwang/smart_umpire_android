package com.hwang.min81.smartumpire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private java.util.Timer activityTimer;
    private TimerTask activityTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.activityTimerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        };

        this.activityTimer = new java.util.Timer();
        this.activityTimer.schedule(activityTimerTask, 5000);
    }

    @Override
    protected void onDestroy() {
        this.activityTimer.cancel();
        super.onDestroy();
    }
}
