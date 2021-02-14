package com.twilio.video.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NewSplashScreen extends AppCompatActivity {
    private static int SPLASH_DISPLAY_LENGTH =1000;

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

//        textViewAni.postDelayed(new Runnable() {
//            public void run() {
////                textViewAni.setVisibility(View.GONE);
////                    progressBar.setVisibility(View.VISIBLE);
//            }
//        }, 3000);

//        RunAnimation();
//        ImageView textViewAni=findViewById(R.id.textAni);
//        final Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textani);
//        textViewAni.setAnimation(slide_up);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(NewSplashScreen.this, LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}