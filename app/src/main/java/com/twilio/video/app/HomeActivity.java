package com.twilio.video.app;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.twilio.video.app.fragments.DoctorListFragment;
import com.twilio.video.app.fragments.BookingFragment;
import com.twilio.video.app.fragments.HomeFragment;
import com.twilio.video.app.fragments.ProfileFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//


        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
//        navigation.setItemIconTintList(ColorStateList.valueOf(Color.parseColor("#aa80b4")));
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.action_home:
                selectedFragment = new HomeFragment();
                break;
            case R.id.action_search:
                selectedFragment = new DoctorListFragment();
                break;
            case R.id.action_news:
                selectedFragment = new BookingFragment();
                break;
            case R.id.action_notification:
                selectedFragment = new ProfileFragment();
                break;
        }
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                selectedFragment).commit();

        return loadFragment(selectedFragment);
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }



    @Override
    protected void onStart() {
        super.onStart();
       updateNavigationBarState();
    }



    private void updateNavigationBarState() {
//        int actionId = getNavigationMenuItemId();
//        selectBottomNavigationBarItem(actionId);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Fragment frg = null;
        frg = getSupportFragmentManager().findFragmentByTag(String.valueOf(frg));
        if (frg == null)
            return;
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.detach(frg);
        ft.attach(frg);
        ft.commit();
    }

}