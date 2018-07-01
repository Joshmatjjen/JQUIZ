package com.example.jasky.jquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroductionActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 10000;
    private TextView tv2;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.space_in_top_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(IntroductionActivity.this, RegisterActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        tv2 = (TextView) findViewById(R.id.tv2);
        iv = (ImageView) findViewById(R.id.iv);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv2.startAnimation(myanim);
        iv.startAnimation(myanim);
        final Intent i = new Intent(this,RegisterActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(10000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
