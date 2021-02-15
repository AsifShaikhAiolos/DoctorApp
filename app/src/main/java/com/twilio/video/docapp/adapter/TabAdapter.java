package com.twilio.video.docapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.twilio.video.docapp.AvailableFragment;
import com.twilio.video.docapp.PastAppointFragment;

class TabAdapter extends FragmentPagerAdapter {


    public TabAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new PastAppointFragment();
            case 1:
                return new AvailableFragment();
            default:
                return new PastAppointFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Past Booking";
            case 1:
                return "Upcoming Booking";
            default:
                return "Past Booking";
        }
    }


}
