package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
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

        long startTime = 0;
        TextView emoTimer;
        Handler timerHandler = new Handler();


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
        }
        class ShowTimer {


            private long startTime = 0L;
            private Handler customHandler = new Handler();
            long timeInMilliseconds = 0L;
            long timeSwapBuff = 0L;
            long updatedTime = 0L;

            public void StartTimer() {

                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread, 0);
            }

            public void StopTimer() {
                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);
            }

            private Runnable updateTimerThread = new Runnable() {

                public void run() {

                    timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

                    updatedTime = timeSwapBuff + timeInMilliseconds;

                    int secs = (int) (timeInMilliseconds / 1000);
                    int mins = secs / 60;
                    secs = secs % 60;
                    int hours = mins / 60;
                    mins = mins % 60;
                    //int milliseconds = (int) (updatedTime % 1000);
                    //+ ":" + String.format("%03d", milliseconds)
                    String timer = "" + String.format("%02d", hours) + ":" + String.format("%02d", mins) + ":" + String.format("%02d", secs);
                    //set yout textview to the String timer here
                    customHandler.postDelayed(this, 1000);
                }

            };




        }

    };
}
