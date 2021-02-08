package com.twilio.video.app.fragments;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.twilio.video.app.HomeActivity;
import com.twilio.video.app.LlistOfDoctorActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.adapter.TabAdapterOther;

public class HomeFragment extends Fragment {
FloatingActionButton fabBook;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
//        TabLayout tabLayOut = (TabLayout) view.findViewById(R.id.tabLayout);
//        TabAdapterOther tabAdapter = new TabAdapterOther(getFragmentManager());
//        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
//        viewPager.setAdapter(tabAdapter);
//        tabLayOut.setupWithViewPager(viewPager);
//
//        fabBook=view.findViewById(R.id.fabBookAppoinment);
//
//        fabBook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), LlistOfDoctorActivity.class);
//                startActivity(intent);
//            }
//        });
        return view;
    }
}