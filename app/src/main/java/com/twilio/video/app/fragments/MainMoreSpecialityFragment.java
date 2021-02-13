package com.twilio.video.app.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.R;
import com.twilio.video.app.adapter.AppoinmentsAdapterNormal;
import com.twilio.video.app.adapter.MoreSpeciality_RecyclerViewAdapter;


public class MainMoreSpecialityFragment extends Fragment {
        RecyclerView SpecialityRecylcerForMore;
    private String[] docSpeciality = {
            "Cardiology",
            "Nero",
            "Brain",
            "Heart",
            "Depression"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main_more_speciality, container, false);
        SpecialityRecylcerForMore = (RecyclerView) view.findViewById(R.id.doctorSpecialityMoreRecyclerView);

        MoreSpeciality_RecyclerViewAdapter moreSpeciality_recyclerViewAdapter = new MoreSpeciality_RecyclerViewAdapter(docSpeciality);
        SpecialityRecylcerForMore.setLayoutManager(new LinearLayoutManager(getContext()));
        SpecialityRecylcerForMore .setAdapter(moreSpeciality_recyclerViewAdapter);

        return view;
    }
}