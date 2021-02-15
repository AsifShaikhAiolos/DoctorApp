package com.twilio.video.docapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.twilio.video.docapp.fragments.DoctorListFragment;
import com.twilio.video.docapp.fragments.BookingFragment;
import com.twilio.video.docapp.fragments.HomeFragment;
import com.twilio.video.docapp.fragments.ProfileFragment;

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
//        drawer = (DrawerLayout) findViewById(R.id.id_drawer_layout);
//        NavigationView navigationView = (NavigationView) findViewById(R.id.id_navview);


        loadFragment(new HomeFragment());


        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);

        //code for navigation drawer
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//
//        toggle.setDrawerIndicatorEnabled(true);
//        toggle.syncState();
//        drawer.addDrawerListener(toggle);

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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.nav_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.id_logOut) {
//             Toast.makeText(getApplicationContext(),"print",Toast.LENGTH_LONG).show();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


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

//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        toggle.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        toggle.onConfigurationChanged(newConfig);
//    }
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