package com.twilio.video.app.doc_fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.R;
import com.twilio.video.app.adapter.PastDataAdapter;
import com.twilio.video.app.docAdapter.Doc_PastAdapter;

import java.util.ArrayList;

public class Doc_Past_Appt_Fragment extends Fragment {

        RecyclerView docpastRecyclerView;
    private String[] pastData = {
            "asif",
            "asif",
            "shitej",
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_doc__past__appt_, container, false);
       docpastRecyclerView=view.findViewById(R.id.docPastRecyclerViewAvailable);

        docpastRecyclerView.setHasFixedSize(true);
        docpastRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        Doc_PastAdapter doc_pastAdapter =new Doc_PastAdapter(pastData);
        docpastRecyclerView.setAdapter(doc_pastAdapter);
        return  view;

    }
}