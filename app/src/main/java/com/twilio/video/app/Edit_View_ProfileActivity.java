package com.twilio.video.app;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apimodel.ProfileMoel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.twilio.video.app.apiWork.networkPojo.apimodel.Dashborad;
import com.twilio.video.app.apiWork.networkPojo.apimodel.ProfileMoel;

public class Edit_View_ProfileActivity extends AppCompatActivity {

    EditText edName,edLastName,edMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__view__profile);
      Toolbar toolbar = findViewById(R.id.toolbar);
        edName=findViewById(R.id.idFName);
        edLastName=findViewById(R.id.idLName);
        edMail=findViewById(R.id.idFamily);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getProfile();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void getProfile() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<ProfileMoel> call = lgApi.checkProfile("","");
        call.enqueue(new Callback<ProfileMoel>() {
            @Override
            public void onResponse(Call<ProfileMoel> call, Response<ProfileMoel> response) {
                if (response.body() != null){
                    edName.setText(response.body().getData().get(0).getName().getFirst_name());
                    edLastName.setText(response.body().getData().get(0).getName().getLast_name());
                    edMail.setText(response.body().getData().get(0).email);
                }
            }

            @Override
            public void onFailure(Call<ProfileMoel> call, Throwable t) {
                if (!call.isCanceled()) {
                    t.printStackTrace();
                }
            }
        });

    }
}