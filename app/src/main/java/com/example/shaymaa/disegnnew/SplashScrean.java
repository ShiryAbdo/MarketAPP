package com.example.shaymaa.disegnnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScrean extends AppCompatActivity {

    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screan);
        mProgress = (ProgressBar) findViewById(R.id.splash_screen_progress_bar);


        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SplashScrean.this.runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashScrean.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }, 3000);
    }
}
