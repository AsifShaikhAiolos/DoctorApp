package com.twilio.video.app.doc_fragments;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.twilio.video.app.HomeActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.doctor.CalenderFragment;
import com.twilio.video.app.fragments.DoctorListFragment;


public class DashFragment extends Fragment {

    CardView crdCalender;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        crdCalender = view.findViewById(R.id.crdCalender);
        crdCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                CalenderFragment calenderFragment = new CalenderFragment();
                activity.getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_container, calenderFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Dashboard");
    }

}