package com.twilio.video.app.doctor;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.twilio.video.app.LoginActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.SPManager;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.DocProfileData;
import com.twilio.video.app.apiWork.networkPojo.apimodel.DocProfile;
import com.twilio.video.app.doc_fragments.ProfileDetails;
import com.twilio.video.app.doc_fragments.DoctorNotificationActivity;
import com.twilio.video.app.doc_fragments.DoctorSettingActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DoctorProfileFragment extends Fragment {

    ConstraintLayout notify, setting, logout, viewEdit;
    TextView txtDoctrrName;
    List<DocProfileData> docProfileData;

    public DoctorProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notify = view.findViewById(R.id.txtNotification);
        setting = view.findViewById(R.id.txtSetting);
        logout = view.findViewById(R.id.txtLogout);
        viewEdit = view.findViewById(R.id.viewAndEdit);
        txtDoctrrName=view.findViewById(R.id.txtDoctoeName);
//        CircleImageView imageView=view.findViewById(R.id.idDoctorProfile);

//        Glide.with(getActivity()).load(docProfileData.get(1).getProfile_pic()).
//        apply(RequestOptions.centerCropTransform()).into(imageView);
//
        viewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileDetails.class);
                startActivity(intent);
            }
        });

        checkingProfileDetails();

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DoctorNotificationActivity.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DoctorSettingActivity.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SPManager sp = getContext().getSharedPreferences(getContext().getPackageName(), getContext().MODE_PRIVATE);
//                sp.edit().clear().commit();
                SPManager.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "logout", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Profile");
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
//                        Toast.makeText(getApplicationContext(),"Data Empty",Toast.LENGTH_LONG).show();
                        DocProfileData docProfileData=   response.body().getData().get(0);

                        txtDoctrrName.setText("Dr. "+docProfileData.getName().getFirst_name());


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
}