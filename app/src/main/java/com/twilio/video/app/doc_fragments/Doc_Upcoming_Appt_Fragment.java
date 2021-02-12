package com.twilio.video.app.doc_fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.R;
import com.twilio.video.app.docAdapter.Doc_PastAdapter;
import com.twilio.video.app.docAdapter.Doc_UpComingAdapter;

public class Doc_Upcoming_Appt_Fragment extends Fragment {

    RecyclerView docUpcomingRecyclerView;
    private String[] upcomingData = {
            "asif",
            "asif",
            "shitej",
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_doc__upcoming__appt_, container, false);
        docUpcomingRecyclerView =view.findViewById(R.id.docUpcomingRecyclerViewAvailable);

        docUpcomingRecyclerView.setHasFixedSize(true);
        docUpcomingRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        Doc_UpComingAdapter doc_pastAdapter =new Doc_UpComingAdapter(upcomingData);
        docUpcomingRecyclerView.setAdapter(doc_pastAdapter);
        return  view;

    }
}