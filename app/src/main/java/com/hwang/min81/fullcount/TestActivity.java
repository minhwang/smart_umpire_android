package com.hwang.min81.fullcount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity implements View.OnLongClickListener {
    private Button pitchButton, batButton, fieldButton, mgrButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        this.mgrButton = (Button)findViewById(R.id.btnManagingAction);
        this.mgrButton.setOnLongClickListener(this);

        this.pitchButton = (Button)findViewById(R.id.btnPitchingAction);
        this.pitchButton.setOnLongClickListener(this);

        this.batButton = (Button)findViewById(R.id.btnBattingAction);
        this.batButton.setOnLongClickListener(this);

        this.fieldButton = (Button)findViewById(R.id.btnFieldingAction);
        this.fieldButton.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        Intent intent = new Intent(v.getContext(), ActionPopupActivity.class);
        startActivity(intent);
        return true;
    }
}
