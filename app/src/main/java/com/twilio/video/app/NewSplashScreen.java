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
    private static int SPLASH_DISPLAY_LENGTH =2500;

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
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(NewSplashScreen.this, LoginActivity.class);
                startActivity(mainIntent);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}