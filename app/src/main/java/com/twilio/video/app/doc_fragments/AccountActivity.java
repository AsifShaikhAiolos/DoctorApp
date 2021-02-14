package com.twilio.video.app.doc_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.twilio.video.app.HomeActivity;
import com.twilio.video.app.LoginActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.SPManager;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.DoctorDataListForDoctor;
import com.twilio.video.app.apiWork.networkPojo.apidata.DoctorProfileUpdateModel;
import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;
import com.twilio.video.app.apiWork.networkPojo.apidata.Name;
import com.twilio.video.app.apiWork.networkPojo.apimodel.LoginModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AccountActivity extends AppCompatActivity {
 EditText edName,edMail,edphone_number,edAddress,edCity;
    String email, phone_number, address,docName;
      Name name;
    List<DoctorDataListForDoctor> listDoctorData;

    Button btn_Update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        edName=findViewById(R.id.idAFName);
        edphone_number=findViewById(R.id.idAContact);
        edMail=findViewById(R.id.docEmail);
        btn_Update=findViewById(R.id.btnUpdate);

        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getUpdateDoctorProfile();
            }
        });

    }


   void  getUpdateDoctorProfile(){
       Retrofit retrofit = RetrofitClient.getRetrofit();
       final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

       Call<DoctorProfileUpdateModel> call = lgApi.getDoctorProfileData();
       call.enqueue(new Callback<DoctorProfileUpdateModel>() {
           @Override
           public void onResponse(Call<DoctorProfileUpdateModel> call, Response<DoctorProfileUpdateModel> response) {
               if (response.body()!=null){
                   if (response.body().getStatus().equalsIgnoreCase("success")) {
//setTokentoprefernece

                       SPManager.getInstance().setAccessToken(response.body().getStatus());
                            edName.setText(response.body().getData().get(1).getEmail());

//                       phone_number=edphone_number.getText().toString();
//                       email=edMail.getText().toString();
//                       docName=edName.getText().toString();



                       Toast.makeText(AccountActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                   } else {
                       Toast.makeText(AccountActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                       Log.e("errorchecking",response.body().toString());
                   }
               }
           }

           @Override
           public void onFailure(Call<DoctorProfileUpdateModel> call, Throwable t) {
               Toast.makeText(AccountActivity.this, t.toString(), Toast.LENGTH_LONG).show();
               Log.e("errorchecking",t.toString());
           }
       });
    }
}