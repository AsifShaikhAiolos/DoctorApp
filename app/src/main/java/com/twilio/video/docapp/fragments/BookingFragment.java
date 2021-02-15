package com.twilio.video.docapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.twilio.video.docapp.R;
import com.twilio.video.docapp.SectionsPagerAdapter;


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
        getActivity().setTitle("My Bookings");

        TabLayout tabLayOut = (TabLayout) view.findViewById(R.id.tabLayout);
        SectionsPagerAdapter tabAdapter = new SectionsPagerAdapter(view.getContext(),getActivity().getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.tabLayoutViewPager);
//        setUpViewPager(viewPager);
        viewPager.setAdapter(tabAdapter);
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