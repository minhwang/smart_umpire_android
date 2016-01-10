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

public class TestActivity extends AppCompatActivity {
    private Button mgrButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        this.mgrButton = (Button)findViewById(R.id.mgr_button);
        this.mgrButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(v.getContext(), ActionPopupActivity.class);
                startActivity(intent);
                return true;
            }
        });
    }
}
