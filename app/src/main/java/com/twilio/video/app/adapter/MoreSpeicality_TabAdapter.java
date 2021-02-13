package com.twilio.video.app.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.twilio.video.app.AvailableFragment;
import com.twilio.video.app.PastAppointFragment;
import com.twilio.video.app.R;
import com.twilio.video.app.fragments.DoctorListFragment;
import com.twilio.video.app.fragments.MainMoreSpecialityFragment;

public class MoreSpeicality_TabAdapter extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_MoreSpclty1, R.string.tab_text_MoreSpclty2};
    private final Context mContext;

    public MoreSpeicality_TabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new DoctorListFragment();
                break;
            case 1:
                fragment=new MainMoreSpecialityFragment();
                break;
            case 2:
                fragment=new DoctorListFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}