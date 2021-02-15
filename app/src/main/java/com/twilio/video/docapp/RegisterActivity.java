package com.twilio.video.docapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.twilio.video.docapp.apiWork.NetworkInterface;
import com.twilio.video.docapp.apiWork.RetrofitClient;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.SignModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText firstName, lastName, email, password, cpassword;
    String fName, lName, semail, spass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btn_reg;
        btn_reg = (Button) findViewById(R.id.btn_signup);
        firstName = findViewById(R.id.id_name);
        lastName = findViewById(R.id.id_lname);
        email = findViewById(R.id.id_email);
        password = findViewById(R.id.id_password);
        cpassword = findViewById(R.id.id_confirmpassword);

        fName = firstName.getText().toString();
//        lName = lastName.getText().toString();
        semail = email.getText().toString();
        spass = password.getText().toString();


        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString() == cpassword.getText().toString()){
                    checkingUserDetails();
                }else {
                    Toast.makeText(RegisterActivity.this,"your passwor and confrim passwor does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void checkingUserDetails() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<SignModel> call = lgApi.checkUser(
                firstName.getText().toString(),
                lastName.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                "customer"
        );
        call.enqueue(new Callback<SignModel>() {
            @Override
            public void onResponse(Call<SignModel> call, Response<SignModel> response) {
                if (response.body()!=null){
                    if (response.body().getStatus().equalsIgnoreCase("success")) {
//setTokentoprefernece
                        SPManager.getInstance().setAccessToken(response.body().getData());
                        Intent i = new Intent(RegisterActivity.this, HomeActivity.class);
                        startActivity(i);
                        finish();
//                        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
                        Log.e("errorchecking",response.body().toString());
                    } else {
                        Log.e("errorchecking",response.body().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<SignModel> call, Throwable t) {
                Log.e("errorchecking",t.toString());
            }
        });
    }

}