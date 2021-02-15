package com.twilio.video.docapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.twilio.video.docapp.AvailableFragment
import com.twilio.video.docapp.PastAppointFragment

class TopTabAdapte(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                PastAppointFragment()
            }
            1 -> {
                AvailableFragment()
            }
            else -> {
                PastAppointFragment()
            }
        }

    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> {
                "Past Appointments"
            }
            1 -> {
                "Upcoming Appointments"
            }
            else -> {
                "Past Appointments"
            }
        }
        return super.getPageTitle(position)
    }


}