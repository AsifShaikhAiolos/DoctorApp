package com.twilio.video.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btn_reg;
//        TextView txtLogin;
        btn_reg = (Button) findViewById(R.id.btn_signup);
//        txtLogin = (TextView) findViewById(R.id.id_txtlogin);


        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UserchoiceActivity.class);
                startActivity(i);
            }
        });

//        txtLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), UserLoginActivity.class);
//                startActivity(i);
//            }
//        });

    }
}