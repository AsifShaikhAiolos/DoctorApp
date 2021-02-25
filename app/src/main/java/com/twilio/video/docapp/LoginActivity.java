package com.twilio.video.docapp;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.twilio.video.docapp.apiWork.NetworkInterface;
import com.twilio.video.docapp.apiWork.RetrofitClient;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.LoginModel;
import com.twilio.video.docapp.apiWork.networkPojo.error.BaseModelError;
import com.twilio.video.docapp.util.Crypto;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    TextView txtmail, txtpassword, sign;
    Button btn_login;
    String get_mail;
    String get_passwrod;
    int res;
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

    public static BaseModelError parError(Response<?> response){
        Converter<ResponseBody, BaseModelError> converter = RetrofitClient.getRetrofit()
                .responseBodyConverter(BaseModelError.class, new Annotation[0]);
        BaseModelError error;
        try {
            error = converter.convert(response.errorBody());
        }catch (IOException e){
            return new BaseModelError();
        }
        return error;
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
                }else {
                    BaseModelError error = parError(response);
                    showMsg(error.getMessage());
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void showMsg(String msg){
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        alertDialogBuilder.setMessage(msg);
//        alertDialogBuilder.setPositiveButton("OK",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        finish();
//                    }
//                });
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();

        Dialog dialog;
        dialog = new Dialog(LoginActivity.this);
        dialog.setContentView(R.layout.error_msg_box);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        AppCompatTextView TxtMsg = dialog.findViewById(R.id.tvErrorMsg);
        AppCompatTextView ok = dialog.findViewById(R.id.tvOk);
        TxtMsg.setText(msg);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }
}