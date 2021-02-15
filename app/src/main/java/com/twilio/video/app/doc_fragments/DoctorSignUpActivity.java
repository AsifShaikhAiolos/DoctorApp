package com.twilio.video.app.doc_fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.Name;
import com.twilio.video.app.apiWork.networkPojo.apimodel.RegisterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DoctorSignUpActivity extends AppCompatActivity {
    EditText edNameFirst,edMail,edphone_number,edSpeciality,edExperience,edQualification,edNameLast;

    String sFirstname,sLastName,smail, sphone_number, sspeciality,sexperince,squalification;
    Name name;
    Button btn_Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_sign_up);

        edNameFirst =findViewById(R.id.etFirstName);
        edNameLast =findViewById(R.id.etLastName);
    btn_Register=findViewById(R.id.btnRegister);
//
        edphone_number=findViewById(R.id.etContactNumber);
        edSpeciality=findViewById(R.id.etSpeciality);
        edExperience=findViewById(R.id.etExperience);
        edQualification=findViewById(R.id.etQualification);
        edMail=findViewById(R.id.etMail);
//
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUpdateDoctorProfile();
            }
        });
    }

    private void getUpdateDoctorProfile(){
        sFirstname= edNameFirst.getText().toString();
        sLastName= edNameLast.getText().toString();
        smail=edMail.getText().toString();
        sphone_number=edphone_number.getText().toString();
        sspeciality=edSpeciality.getText().toString();
        sexperince=edExperience.getText().toString();
        squalification=edQualification.getText().toString();

        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<RegisterModel> call = lgApi.getRegisterDoctor(sFirstname,sLastName,smail,"",
                sphone_number,"","","","",sspeciality,"","","",
                "",squalification,sexperince,"");
        call.enqueue(new Callback<RegisterModel>() {
            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                if (response.body()!=null){
                    if (response.body().getStatus().equalsIgnoreCase("success")) {


                        Log.e("errorchecking",response.body().toString());

                        Toast.makeText(DoctorSignUpActivity.this, response.body().getStatus(), Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(DoctorSignUpActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("errorchecking",response.body().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                Toast.makeText(DoctorSignUpActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("errorchecking",t.toString());
            }
        });

    }

}