package com.twilio.video.app.doctor;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.timessquare.CalendarPickerView;
import com.twilio.video.app.R;
import com.twilio.video.app.doc_fragments.DoctorStatusActionActivity;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalenderFragment extends Fragment {

    FloatingActionButton fab;
    CalendarPickerView calendar;
    String selectedDate;
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

//        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(Date date) {
//                selectedDate = date.toString();
//                String dateR = calendar.getSelectedDate().toString();
//                String newT= DateConvertor(dateR);
//                Toast.makeText(getActivity(), newT, Toast.LENGTH_SHORT);
//            }
//
//            @Override
//            public void onDateUnselected(Date date) {
//
//            }
//        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Date> dates = calendar.getSelectedDates();
                ArrayList<String> appointmentdate =   DateConvertor(dates);
                Log.e("SelectDate", String.valueOf(appointmentdate));
                Intent intent = new Intent(getActivity(), DoctorStatusActionActivity.class);
                intent.putStringArrayListExtra("date", appointmentdate);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    public ArrayList<String> DateConvertor(List<Date> dates){
        ArrayList<String> str= new ArrayList<>();
        try {
            for (Date d : dates) {
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = dateFormat.format(d);

                str.add(strDate);
            }
        }catch (Exception e){
                e.printStackTrace();
            }
            return str;
        }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Calendar");
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

//    public void goToAttract(View v)
//    {
//        Intent intent = new Intent(getActivity(), EditDoctorActivity.class);
//        startActivity(intent);
//    }

}