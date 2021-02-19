package com.twilio.video.app.doc_fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.DocProfileData;
import com.twilio.video.app.apiWork.networkPojo.apidata.DoctorDataListForDoctor;
import com.twilio.video.app.apiWork.networkPojo.apidata.DoctorProfileUpdateModel;
import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;
import com.twilio.video.app.apiWork.networkPojo.apidata.Name;
import com.twilio.video.app.apiWork.networkPojo.apidata.UpCommingDatat;
import com.twilio.video.app.apiWork.networkPojo.apimodel.DashModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.DocProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AccountActivity extends AppCompatActivity {
 EditText edName,edLastName,edMail,edphone_number,edSpeciality,edExperience,edQualification;



    Button btn_Update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        edName=findViewById(R.id.edfirstName);
        edLastName=findViewById(R.id.edLastName);
        edphone_number=findViewById(R.id.edPhoneNumber);
        edSpeciality=findViewById(R.id.edDocSpecaility);
        edExperience=findViewById(R.id.edExperience);
        edQualification=findViewById(R.id.edQualification);
        edMail=findViewById(R.id.edMail);
        btn_Update=findViewById(R.id.btnUpdate);
//        Glide.with(getApplicationContext()).load(DocPro.get(position).()).apply(RequestOptions.centerCropTransform()).into(holder.doctorProfile);

//        edName.setText("name");
//        getDoctorProfile();
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        checkingProfileDetails();
//        getDoctorProfile();

    }

    private void checkingProfileDetails() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<DocProfile> call = lgApi.checkProfile("", "");
        call.enqueue(new Callback<DocProfile>() {
            @Override
            public void onResponse(Call<DocProfile> call, Response<DocProfile> response) {
                if (response.body().getData()!=null){
//                    listDoctorData.clear();
                    if(response.body().getData()!=null&&response.body().getData().size()>0) {
                        Toast.makeText(getApplicationContext(),"Data Empty",Toast.LENGTH_LONG).show();
                     DocProfileData docProfileData=   response.body().getData().get(0);

                     edMail.setText(docProfileData.getEmail());
                     edName.setText(docProfileData.getName().getFirst_name());
                     edLastName.setText(docProfileData.getName().getLast_name());
                     edSpeciality.setText(docProfileData.getSpeciality());
                     edQualification.setText(docProfileData.getQualification());
                     edExperience.setText(docProfileData.getExperience());
                     edphone_number.setText(docProfileData.getPhone_number());

                    }

         } else {
//                        Log.e("errorchecking",response.body().toString());
//                    }
                }
            }

            @Override
            public void onFailure(Call<DocProfile> call, Throwable t) {
                Log.e("errorchecking",t.toString());
            }
        });
    }


    private void  getDoctorProfile(){
       Retrofit retrofit = RetrofitClient.getRetrofit();
       final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

       Call<DoctorDataListForDoctor> call = lgApi.getDoctorProfileData("","");
       call.enqueue(new Callback<DoctorDataListForDoctor>() {
           @Override
           public void onResponse(Call<DoctorDataListForDoctor> call, Response<DoctorDataListForDoctor> response) {
               if (response.body() != null) {
                   List<DoctorDataListForDoctor> d;
//                       edName.setText(d.getName().getFirst_name());


//                   if(response.body().getStatus().equalsIgnoreCase("success")){
//
////                       for (int i = 0; i < response.body().getStatus().length(); i++){
////                           String name = response.body().getData().get(i).getEmail();
////                           edName.setText(name);
////                           Log.e("errorchecking", name);
////                       }
//
//
//                   }


                       Toast.makeText(AccountActivity.this, response.message().toString(), Toast.LENGTH_LONG).show();
////
               }
           }

           @Override
           public void onFailure(Call<DoctorDataListForDoctor> call, Throwable t) {
               Toast.makeText(AccountActivity.this, t.toString(), Toast.LENGTH_LONG).show();
               Log.e("errorchecking",t.toString());
           }
       });
    }


}