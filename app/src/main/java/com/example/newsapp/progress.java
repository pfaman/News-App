package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class progress extends AppCompatActivity {

    ProgressBar progressBar;
    int count=0;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);



        progressBar=findViewById(R.id.progressbar);

        timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {

                count++;
                progressBar.setProgress(count);
                if(count==10) {
                    timer.cancel();
                    Intent intent=new Intent(progress.this,MainActivity.class);
                    startActivity(intent);
                }


            }
        };
        timer.schedule(timerTask,0,100);
    }
}