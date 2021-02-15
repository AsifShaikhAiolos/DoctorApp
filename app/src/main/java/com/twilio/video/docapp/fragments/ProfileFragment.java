package com.twilio.video.docapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.twilio.video.docapp.Edit_View_ProfileActivity;
import com.twilio.video.docapp.LoginActivity;
import com.twilio.video.docapp.R;
import com.twilio.video.docapp.SPManager;
import com.twilio.video.docapp.apiWork.NetworkInterface;
import com.twilio.video.docapp.apiWork.RetrofitClient;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.ProfileMoel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileFragment extends Fragment {
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        getActivity().setTitle("Profile");

        ConstraintLayout editProfile=view.findViewById(R.id.editProfile);
        textView=view.findViewById(R.id.PatNameTxt);


        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Edit_View_ProfileActivity.class);
                startActivity(intent);
            }
        });

        ConstraintLayout logOut=view.findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPManager.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        }
        );
        getProfile();

        return view;
    }

    private void getProfile() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<ProfileMoel> call = lgApi.checkProfile("","");
        call.enqueue(new Callback<ProfileMoel>() {
            @Override
            public void onResponse(Call<ProfileMoel> call, Response<ProfileMoel> response) {
                if (response.body() != null){
//                    edName.setText(response.body().getData().get(0).getName().getFirst_name());
//                    edLastName.setText(response.body().getData().get(0).getName().getLast_name());
//                    edMail.setText(response.body().getData().get(0).email);
                    String name = response.body().getData().get(0).getName().getFirst_name();
                    String last = response.body().getData().get(0).getName().getLast_name();

                    textView.setText(name + "\n" + last);

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