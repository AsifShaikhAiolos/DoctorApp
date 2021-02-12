package com.twilio.video.app.doc_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import com.twilio.video.app.R;
import com.twilio.video.app.SectionsPagerAdapter;
import com.twilio.video.app.docAdapter.Doc_Top_TabAdapter;


public class Doctor_View_Booking_Fragment extends Fragment {


    //    FloatingActionButton fabBook;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        View view =inflater.inflate(R.layout.fragment_doctor__view__booking_, container, false);
        TabLayout tabLayOut = (TabLayout) view.findViewById(R.id.tabLayoutForDoctorBooking);
        Doc_Top_TabAdapter doc_top_tabAdapter = new Doc_Top_TabAdapter(view.getContext(),getActivity().getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.tabLayoutViewPager2);
//        setUpViewPager(viewPager);
        viewPager.setAdapter(doc_top_tabAdapter);
        tabLayOut.setupWithViewPager(viewPager);
//        viewPager.setOffscreenPageLimit(2);
//        viewPager.setOffscreenPageLimit(2);
//        viewPager.setAdapter(tabAdapter);
//
//        setupWithViewPager(viewPager);
//        setUpViewPager(viewPager)
//        tabAdapter.notifyDataSetChanged();
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

//    private void setUpViewPager(ViewPager viewpager){
//        HomeActivity nAct = new HomeActivity();
//        TabAdapterOther tabAdapter = new TabAdapterOther(nAct.getSupportFragmentManager());
//        tabAdapter.addFragment(new PastAppointFragment(), "Past Booking");
//        tabAdapter.addFragment(new AvailableFragment(), "Upcoming Booking");
//        viewpager.
//    }


//    @Override
//    public void  setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//
//            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
//        }
//    }
}