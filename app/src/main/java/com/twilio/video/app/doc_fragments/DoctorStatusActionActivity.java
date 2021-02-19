package com.twilio.video.app.doc_fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.CheckBox;
import android.view.View;
import android.widget.Toolbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.twilio.video.app.LoginActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.DoctorAvailability;
import com.twilio.video.app.apiWork.networkPojo.apidata.UpCommingDatat;
import com.twilio.video.app.apiWork.networkPojo.apimodel.AvailbleModelClass;
import com.twilio.video.app.apiWork.networkPojo.apimodel.DashModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.UpcommingModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DoctorStatusActionActivity extends AppCompatActivity {

//    CheckBox dayOff;
//    CheckBox dayOn;
    Button btn;
    RadioGroup radioGroup;
    private RadioButton radioButton;
    androidx.appcompat.widget.Toolbar toolbar;
    String var,var2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_status_action);
        btn = (Button) findViewById(R.id.btnSave);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        int selectedId = radioGroup.getCheckedRadioButtonId();
//        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
//        genderradioButton = (RadioButton) findViewById(selectedId);


//        int selectedId = radioGroup.getCheckedRadioButtonId();

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
                {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch(checkedId){
                            case R.id.radio1:
                                // do operations specific to this selection
                                var="0";


                                break;
                            case R.id.radio2:
                                // do operations specific to this selection
                                var="1";
//                                Toast.makeText(DoctorStatusActionActivity.this,var, Toast.LENGTH_SHORT).show();
//
                                break;
                        }
                    }
                });

//        btn.setVisibility(View.VISIBLE);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

//                String getDate = (String) getIntent().getExtras().get("date");
//                Toast.makeText(DoctorStatusActionActivity.this,
//                        getDate, Toast.LENGTH_SHORT).show();
//                int selectedId = rg.getCheckedRadioButtonId();

                // find the radiobutton by returned id
//                radioButton = (RadioButton) findViewById(selectedId);

                checkingDashDetails();

//                Toast.makeText(DoctorStatusActionActivity.this,
//                        var, Toast.LENGTH_SHORT).show();
//
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private void checkingDashDetails() {
        ArrayList<String> getDate =  getIntent().getStringArrayListExtra("date");
        Log.e("errorchecking",String.valueOf(getDate));
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);
            DoctorAvailability doctorAvailability=new DoctorAvailability(getDate, Integer.parseInt(var));
        Call<AvailbleModelClass> call = lgApi.getAvaibilityDoctor(doctorAvailability);
        call.enqueue(new Callback<AvailbleModelClass>() {
            @Override

            public void onResponse(Call<AvailbleModelClass> call, Response<AvailbleModelClass> response) {
                if (response.body()!=null){
//                    if (response.message().equalsIgnoreCase("success")) {
//                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        String message=response.body().getMessage();

                    AlertDialog alertDialog = new AlertDialog.Builder(DoctorStatusActionActivity.this)
                            .setIcon(R.drawable.app_logo)
                            .setTitle("Notification")
                            .setMessage(message)
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .show();


//                    if(response.body().getMakeAvailable()==1) {
////setTokentoprefernece    Can't mark the date as a days off, as the Date selected has an active appointment.
//
//                        }
//
//                        if(response.)
                        Log.e("errorchecking",response.body().toString());
//                    } else {
//                        Log.e("errorchecking",response.body().toString());
//                    }
                }
            }

            @Override
            public void onFailure(Call<AvailbleModelClass> call, Throwable t) {
                Log.e("errorchecking",t.toString());
            }
        });
    }


//    private void getUpcommingDataFromServer(){
//        Retrofit retrofit = RetrofitClient.getRetrofit();
//        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);
//        Call<AvailbleModelClass> call = lgApi.getcodedata();
//        call.enqueue(new Callback<AvailbleModelClass>() {
//            @Override
//            public void onResponse(Call<AvailbleModelClass> call, Response<AvailbleModelClass> response) {
//                if(response.body()!=null&& response.body().getData()!=null) {
//        if(response.)
//
//                }else {
//                    Log.d("NULL", "null past");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AvailbleModelClass> call, Throwable t) {
//                if (!call.isCanceled()) {
//                    t.printStackTrace();
//                }
//            }
//        });
//    }

}