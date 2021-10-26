package com.example.machinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtCount = (TextView) findViewById(R.id.txtCount);
        LinearLayout llMain = findViewById(R.id.rlMain);
        TextView textView = new TextView(this);
        textView.setText("I am added dynamically to the view");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        textView.setLayoutParams(params);
        llMain.addView(textView);

        final int secs = 5;
        new CountDownTimer((secs +1) * 1000, 1000) // Wait 5 secs, tick every 1 sec
        {
            @Override
            public final void onTick(final long millisUntilFinished)
            {
                txtCount.setText("" + (int) (millisUntilFinished * .001f));
            }
            @Override
            public final void onFinish()
            {
                txtCount.setText("GO!");
            }
        }.start();
    }
    }
