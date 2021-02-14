package com.twilio.video.app.fragments;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.twilio.video.app.Edit_View_ProfileActivity;
import com.twilio.video.app.LoginActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.SPManager;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apimodel.Dashborad;
import com.twilio.video.app.apiWork.networkPojo.apimodel.ProfileMoel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        getActivity().setTitle("Profile");

        ConstraintLayout editProfile=view.findViewById(R.id.editProfile);


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

        return view;
    }


}