package com.twilio.video.app.doc_fragments;


import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.CheckBox;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.twilio.video.app.LoginActivity;
import com.twilio.video.app.R;

public class DoctorStatusActionActivity extends AppCompatActivity {

    CheckBox dayOff;
    CheckBox dayOn;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_status_action);
        btn = (Button) findViewById(R.id.btnSave);
        dayOff = (CheckBox) findViewById(R.id.checkman);
        dayOn = (CheckBox) findViewById(R.id.check2);
        dayOff.setChecked(false);
        dayOn.setChecked(false);
        btn.setEnabled(false);
        btn.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                Toast.makeText(DoctorStatusActionActivity .this, "btn", Toast.LENGTH_LONG).show();
            }
        });

        dayOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setEnabled(true);
                btn.setVisibility(v.VISIBLE);
                if (dayOn.isChecked()) {
                    dayOff.setChecked(true);
                    dayOn.setChecked(false);
                } else {
                    dayOff.setChecked(true);
                }
            }
        });

        dayOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setEnabled(true);
                btn.setVisibility(v.VISIBLE);
                if (dayOff.isChecked()) {
                    dayOff.setChecked(false);
                    dayOn.setChecked(true);
                } else {
                    dayOn.setChecked(true);
                }
            }
        });
    }
}