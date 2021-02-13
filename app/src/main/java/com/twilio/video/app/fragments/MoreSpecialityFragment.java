package com.twilio.video.app.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.twilio.video.app.R;
import com.twilio.video.app.SectionsPagerAdapter;
import com.twilio.video.app.adapter.MoreSpeicality_TabAdapter;


public class MoreSpecialityFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_more_speciality, container, false);

        getActivity().setTitle("Search");

        TabLayout tabLayOut = (TabLayout) view.findViewById(R.id.tabLayoutForMoreSpeciality);
        MoreSpeicality_TabAdapter tabAdapter = new MoreSpeicality_TabAdapter(
                view.getContext(),getActivity().getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.tabLayoutViewPagerForMoreSpeciality);
//        setUpViewPager(viewPager);
        viewPager.setAdapter(tabAdapter);
        tabLayOut.setupWithViewPager(viewPager);

        return view;

    }
}