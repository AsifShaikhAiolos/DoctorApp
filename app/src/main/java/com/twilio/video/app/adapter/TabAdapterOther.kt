package com.twilio.video.app.adapter

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.twilio.video.app.AvailableFragment
import com.twilio.video.app.PastAppointFragment

class TabAdapterOther(fm: FragmentManager) : FragmentPagerAdapter(
        fm) {
    val fragmentList = ArrayList<Fragment>()
    val fragmentTitle = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        fragmentTitle.add(title)
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle.get(position)
    }
//    override fun getItem(position: Int): Fragment {
//        return when (position) {
//            0 -> {
//                PastAppointFragment()
//            }
//            1 -> {
//                AvailableFragment()
//            }
//            else -> {
//                PastAppointFragment()
//            }
//        }
//
//    }
//
//    override fun getCount(): Int {
//        return 2
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return when (position){
//            0 -> {
//                "Past Booking"
//            }
//            1 -> {
//                "Upcoming Booking"
//            }
//            else -> {
//                "Past Booking"
//            }
//        }
//        return super.getPageTitle(position)
//    }
//
}