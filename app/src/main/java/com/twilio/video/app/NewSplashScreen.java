package com.twilio.video.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.trncic.library.DottedProgressBar;

public class NewSplashScreen extends AppCompatActivity {
    private static int SPLASH_DISPLAY_LENGTH = 1000;

    DottedProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        PrefManager prefManager = new PrefManager(getApplicationContext());
        if (prefManager.isFirstTimeLaunch()) {
            prefManager.setFirstTimeLaunch(false);
            startActivity(new Intent(NewSplashScreen.this,LoginActivity.class));
            finish();
        }

//

//
//        TextView textViewAni=findViewById(R.id.textAni);
//        ProgressBar progressBar=findViewById(R.id.progress_bar);
//        textViewAni.setText("+0");
//        textViewAni.postDelayed(new Runnable() {
//            public void run() {
//                textViewAni.setVisibility(View.GONE);
//                    progressBar.setVisibility(View.VISIBLE);
//            }
//        }, 3000);

//        RunAnimation();
//        TextView textViewAni=findViewById(R.id.textAni);
////        final Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
//        final Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
//        textViewAni.setAnimation(slide_up);
////        textViewAni.setAnimation(slide_up);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(NewSplashScreen.this, LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void RunAnimation()
    {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.textani);
        a.reset();
        TextView tv = (TextView) findViewById(R.id.textAni);
        tv.clearAnimation();
        tv.startAnimation(a);
    }
}