package com.twilio.video.app.doctor;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.timessquare.CalendarPickerView;
import com.twilio.video.app.HomeActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.doc_fragments.DoctorStatusActionActivity;

import java.util.Calendar;
import java.util.Date;

public class CalenderFragment extends Fragment {

    FloatingActionButton fab;
    CalendarPickerView calendar;
    public CalenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_calender, container, false);
        fab = view.findViewById(R.id.editFab);
        calendar = (CalendarPickerView) view.findViewById(R.id.calendar);
        Date today = new Date();
        final Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        final Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -1);

        calendar.init(today, nextYear.getTime())
                .inMode(CalendarPickerView
                        .SelectionMode
                        .MULTIPLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), DoctorStatusActionActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Calendar");
    }

//    public void goToAttract(View v)
//    {
//        Intent intent = new Intent(getActivity(), EditDoctorActivity.class);
//        startActivity(intent);
//    }

}