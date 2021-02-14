package com.twilio.video.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.adapter.FamilyMemberAdapter;
import com.twilio.video.app.adapter.SpecialityAdapter;

public class MyFamilyActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_family);
        Toolbar toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.myFamilyRecyclerView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        FamilyMemberAdapter adp = new FamilyMemberAdapter();
        rv.setAdapter(adp);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}