package com.twilio.video.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.twilio.video.app.adapter.TabAdapterOther;

public class HomeActivity extends AppCompatActivity {
FloatingActionButton fabBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TabLayout tabLayOut = (TabLayout) findViewById(R.id.tabLayout);
        TabAdapterOther tabAdapter = new TabAdapterOther(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(tabAdapter);
        tabLayOut.setupWithViewPager(viewPager);

        fabBook=findViewById(R.id.fabBookAppoinment);

        fabBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LlistOfDoctorActivity.class);
                startActivity(intent);
            }
        });
    }
}