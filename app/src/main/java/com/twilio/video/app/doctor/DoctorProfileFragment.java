package com.twilio.video.app.doctor;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.twilio.video.app.LoginActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.SPManager;
import com.twilio.video.app.doc_fragments.DoctorNotificationActivity;
import com.twilio.video.app.doc_fragments.DoctorSettingActivity;
import com.twilio.video.app.doc_fragments.DoctorStatusActionActivity;

public class DoctorProfileFragment extends Fragment {

    ConstraintLayout notify, setting, logout;


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
//                Intent intent = new Intent(getActivity(), LoginActivity.class);
//                startActivity(intent);
                Toast.makeText(getActivity(), "logout", Toast.LENGTH_LONG).show();
            }
        });
    }
}