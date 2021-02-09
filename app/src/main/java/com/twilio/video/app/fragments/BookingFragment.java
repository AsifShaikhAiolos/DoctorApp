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
import com.twilio.video.app.LlistOfDoctorActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.SectionsPagerAdapter;
import com.twilio.video.app.adapter.TabAdapterOther;


public class BookingFragment extends Fragment {


//    FloatingActionButton fabBook;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        View view =inflater.inflate(R.layout.fragment_booking, container, false);
        TabLayout tabLayOut = (TabLayout) view.findViewById(R.id.tabLayout);
        SectionsPagerAdapter tabAdapter = new SectionsPagerAdapter(view.getContext(),getActivity().getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
//        viewPager.setOffscreenPageLimit(2);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(tabAdapter);

        tabLayOut.setupWithViewPager(viewPager);
        tabAdapter.notifyDataSetChanged();
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


    @Override
    public void  setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }
}