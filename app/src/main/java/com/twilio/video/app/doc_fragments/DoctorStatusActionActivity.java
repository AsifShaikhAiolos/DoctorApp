package com.twilio.video.app.doc_fragments;


import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.CheckBox;
import android.view.View;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.twilio.video.app.LoginActivity;
import com.twilio.video.app.R;

public class DoctorStatusActionActivity extends AppCompatActivity {

//    CheckBox dayOff;
//    CheckBox dayOn;
    Button btn;
    RadioGroup radioGroup;
    RadioButton genderradioButton;
    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_status_action);
        btn = (Button) findViewById(R.id.btnSave);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        int selectedId = radioGroup.getCheckedRadioButtonId();
//        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
//        genderradioButton = (RadioButton) findViewById(selectedId);

        btn.setVisibility(View.VISIBLE);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
//                if(selectedId==-1){
//                    Toast.makeText(DoctorStatusActionActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(DoctorStatusActionActivity.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();
//                }
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}