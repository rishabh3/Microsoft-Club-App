package com.example.rishabh.microsoftclubapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_OUT_TIME=10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image=(ImageView) findViewById(R.id.imageView);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation);
        final SharedPreferences preferences=getSharedPreferences("my_preferences",MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if(!preferences.getBoolean("onboarding_complete",false)) {
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        },SPLASH_OUT_TIME);
    }
}
