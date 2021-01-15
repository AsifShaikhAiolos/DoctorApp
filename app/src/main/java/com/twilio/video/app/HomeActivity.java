package com.twilio.video.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.twilio.video.app.adapter.TabAdapterOther;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TabLayout tabLayOut = (TabLayout) findViewById(R.id.tabLayout);
        TabAdapterOther tabAdapter = new TabAdapterOther(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(tabAdapter);
        tabLayOut.setupWithViewPager(viewPager);
    }
}