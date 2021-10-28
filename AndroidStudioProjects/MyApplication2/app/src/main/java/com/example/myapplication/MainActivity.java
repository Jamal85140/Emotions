package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat(" d MMM yyyy HH:mm:ss ");
            String time =  format.format(calendar.getTime());

            TextView textView = findViewById(R.id.timeCounter);
            textView.setText(time);

        /*private long startTime = 0;
        private TextView emoTimer;
        private Handler timerHandler = new Handler();


       @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_timer);

            emoTimer = findViewById(R.id.buttonEmo1Timer);
            btnEndTimer = findViewById(R.id.btnEndTimer);
            btnEndTimer.setOnClickListener(this);

            startTime = System.currentTimeMillis();
            timerHandler.postDelayed(timer, 0);
        }

        protected void onStop() {
            super.onStop();
            timerHandler.removeCallbacks(timer);
        }*/
    }
}