package com.twilio.video.app.doc_fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.DoctorDataListForDoctor;
import com.twilio.video.app.apiWork.networkPojo.apidata.DoctorProfileUpdateModel;
import com.twilio.video.app.apiWork.networkPojo.apidata.Name;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AccountActivity extends AppCompatActivity {
 EditText edName,edMail,edphone_number,edSpeciality,edExperience,edQualification;

    String sname,smail, sphone_number, sspeciality,sexperince,squalification;
    Name name;
    List<DoctorDataListForDoctor> listDoctorData;

    Button btn_Update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        edName=findViewById(R.id.edfirstName);
        edphone_number=findViewById(R.id.edPhoneNumber);
        edSpeciality=findViewById(R.id.edDocSpecaility);
        edExperience=findViewById(R.id.edExperience);
        edQualification=findViewById(R.id.edQualification);
        edMail=findViewById(R.id.edMail);
        btn_Update=findViewById(R.id.btnUpdate);

//        edName.setText("name");
        getDoctorProfile();

        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }


    private void  getDoctorProfile(){
       Retrofit retrofit = RetrofitClient.getRetrofit();
       final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

       Call<DoctorProfileUpdateModel> call = lgApi.getDoctorProfileData("","");
       call.enqueue(new Callback<DoctorProfileUpdateModel>() {
           @Override
           public void onResponse(Call<DoctorProfileUpdateModel> call, Response<DoctorProfileUpdateModel> response) {
               if (response.body() != null) {

                   if(response.body().getStatus().equalsIgnoreCase("success")){

                       String name = response.body().getData().toString();

                       edName.setText(name);
                       Log.e("errorchecking", name);
                   }


                       Toast.makeText(AccountActivity.this, response.message().toString(), Toast.LENGTH_LONG).show();
////
               }
           }

           @Override
           public void onFailure(Call<DoctorProfileUpdateModel> call, Throwable t) {
               Toast.makeText(AccountActivity.this, t.toString(), Toast.LENGTH_LONG).show();
               Log.e("errorchecking",t.toString());
           }
       });
    }

    private void getUpdateDoctorProfile(){
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

    }

}