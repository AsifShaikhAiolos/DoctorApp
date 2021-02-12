package com.twilio.video.app;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.twilio.video.app.doc_fragments.DashFragment;
import com.twilio.video.app.fragments.DoctorListFragment;
import com.twilio.video.app.fragments.BookingFragment;
import com.twilio.video.app.doc_fragments.Doctor_View_Booking_Fragment;
import com.twilio.video.app.fragments.HomeFragment;
import com.twilio.video.app.fragments.ProfileFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//
        toolbar = findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.id_drawer_layout);
//        NavigationView navigationView = (NavigationView) findViewById(R.id.id_navview);


        loadFragment(new DashFragment());


        //code for navigation drawer
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawer.addDrawerListener(toggle);

//        navigationView.bringToFront();
//        navigationView.setNavigationItemSelectedListener(this);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.bringToFront();
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        selectedFragment = new DashFragment();
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
            });
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        drawer.closeDrawers();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//
//        int id = item.getItemId();
//
//        if (id == R.id.id_rate) {
////            MainFragment fragment = new MainFragment();
////            ft.replace(R.id.f_container, fragment);
////            ft.commit();
//            Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
//        } else if (id == R.id.id_share) {
//            //appBarTV.setText("Fragment With Tabs");
////            ChatFragment fragment = new ChatFragment();
////            ft.replace(R.id.f_container, fragment);
////            ft.commit();
//            Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

}