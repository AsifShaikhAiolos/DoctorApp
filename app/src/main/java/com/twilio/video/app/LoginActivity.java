package com.twilio.video.app;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.LoginData;
import com.twilio.video.app.apiWork.networkPojo.apimodel.LoginModel;
import com.twilio.video.app.doc_fragments.DoctorSettingActivity;
import com.twilio.video.app.doc_fragments.DoctorSignUpActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    TextView txtmail, txtpassword;
    Button btn_login;
    String get_mail;
    String get_passwrod;
    AppCompatTextView textSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//hooks
        txtmail = findViewById(R.id.id_mail);
        txtpassword = findViewById(R.id.id_password);
        textSignUp = findViewById(R.id.txtSignUp);
        btn_login = findViewById(R.id.btn_login);

        textSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DoctorSignUpActivity.class);
                startActivity(intent);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_mail = txtmail.getText().toString();
                get_passwrod = txtpassword.getText().toString();


                checkingLoginDetails();
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
                if (response.body()!=null){
                if (response.body().getStatus().equalsIgnoreCase("success")) {
//setTokentoprefernece
                   SPManager.getInstance().setAccessToken(response.body().getData());
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Log.e("errorchecking",response.body().toString());
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("errorchecking",response.body().toString());
                }
            }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("errorchecking",t.toString());
            }
        });
    }
}