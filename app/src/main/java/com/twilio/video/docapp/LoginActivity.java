package com.twilio.video.docapp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.twilio.video.docapp.apiWork.NetworkInterface;
import com.twilio.video.docapp.apiWork.RetrofitClient;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.LoginModel;
import com.twilio.video.docapp.apiWork.networkPojo.error.LoginModelError;
import com.twilio.video.docapp.util.Crypto;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    TextView txtmail, txtpassword, sign;
    Button btn_login;
    String get_mail;
    String get_passwrod;
    Crypto crypto = new Crypto();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//hooks
        txtmail = findViewById(R.id.id_mail);
        txtpassword = findViewById(R.id.id_password);
        btn_login = findViewById(R.id.btn_login);
        sign = findViewById(R.id.signUp);


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_mail = txtmail.getText().toString();
                get_passwrod = txtpassword.getText().toString();

                if(get_mail.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Pelease enter your userName", Toast.LENGTH_LONG).show();
                }else if(get_passwrod.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Pelease enter your password", Toast.LENGTH_LONG).show();
                }else {
                    checkingLoginDetails();
                }
            }
        });

    }


    private void checkingLoginDetails() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<LoginModel> call = lgApi.checkLogin(get_mail, get_passwrod);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    if (response.body()!=null){
                        String data = response.body().getData();
                        SPManager.getInstance().setAccessToken(crypto.encrypt(data.getBytes(), "token"));
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                        Log.e("errorchecking",response.body().getData().toString());
                        Log.e("errorchecking",crypto.encrypt(data.getBytes(), "token"));
                        Log.e("errorchecking",SPManager.getInstance().getAccessToken());
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "User Not Exits", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}