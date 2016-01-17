package com.hwang.min81.smartumpire;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;

public class TestActivity extends AppCompatActivity implements View.OnLongClickListener {
    private Button pitchButton, batButton, fieldButton, mgrButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        this.mgrButton = (Button)findViewById(R.id.mgr_button);
        this.mgrButton.setOnLongClickListener(this);

        this.pitchButton = (Button)findViewById(R.id.pitch_button);
        this.pitchButton.setOnLongClickListener(this);

        this.batButton = (Button)findViewById(R.id.bat_button);
        this.batButton.setOnLongClickListener(this);

        this.fieldButton = (Button)findViewById(R.id.field_button);
        this.fieldButton.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        Intent intent = new Intent(v.getContext(), ActionPopupActivity.class);
        startActivity(intent);
        return true;
    }
}
