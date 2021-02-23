package com.twilio.video.app.doc_fragments;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.DoctorAvailability;
import com.twilio.video.app.apiWork.networkPojo.apimodel.AvailbleModelClass;
import com.vistrav.pop.Pop;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DoctorStatusActionActivity extends AppCompatActivity {
    Button btn;
    androidx.appcompat.widget.Toolbar toolbar;
    String var,var2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_status_action);
        btn = (Button) findViewById(R.id.btnSave);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
                {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch(checkedId){
                            case R.id.radio1:
                                var="0";
                                break;

                            case R.id.radio2:
                                var="1";
                               break;
                        }
                    }
                });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                checkingDashDetails();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private void checkingDashDetails() {
        ArrayList<String> getDate =  getIntent().getStringArrayListExtra("date");
        Log.e("errorchecking",String.valueOf(getDate));
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);
            DoctorAvailability doctorAvailability=new DoctorAvailability(getDate, Integer.parseInt(var));
        Call<AvailbleModelClass> call = lgApi.getAvaibilityDoctor(doctorAvailability);
        call.enqueue(new Callback<AvailbleModelClass>() {
            @Override

            public void onResponse(Call<AvailbleModelClass> call, Response<AvailbleModelClass> response) {
                if (response.body()!=null){
                        String message=response.body().getMessage();

//                    ViewDialog alert = new ViewDialog();
//                    alert.showDialog(getApplicationContext(), message);

                    Pop.on(DoctorStatusActionActivity.this).with().title(R.string.app_name).layout(R.layout.custom_pop)
                            .when(new Pop.Yah() {
                                @Override
                                public void clicked(DialogInterface dialog, View view) {
//                                    Toast.makeText(getBaseContext(), "Yah button clicked", Toast.LENGTH_LONG).show();
                                }
                            })
                            .show(new Pop.View() { // assign value to view element
                                @Override
                                public void prepare(View view) {
                                    TextView etName =  view.findViewById(R.id.message);
//                                    Log.i(TAG, "etName :: " + etName.getText());
                                    etName.setText(message);
                                }
                            });

//                    AlertDialog alertDialog = new AlertDialog.Builder(DoctorStatusActionActivity.this)
//                            .setIcon(R.drawable.app_logo)
//                            .setTitle("Notification")
//                            .setMessage(message)
//                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                }
//                            })
//                            .show();
//                    alertDialog.setContentView(R.layout.mydailogbhai);
                        Log.e("errorchecking",response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<AvailbleModelClass> call, Throwable t) {
                Log.e("errorchecking",t.toString());
            }
        });
    }

//    public class ViewDialog {
//        public void showDialog(Context activity, String msg) {
//            final Dialog dialog = new Dialog(activity);
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            dialog.setCancelable(false);
//            dialog.setContentView(R.layout.mydailogbhai);
//
//            TextView text = (TextView) dialog.findViewById(R.id.message);
//            text.setText(msg);
//
//            TextView dialogButton = dialog.findViewById(R.id.txtYes);
//            dialogButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dialog.dismiss();
//                }
//            });
//
//            dialog.show();
//
//        }
//    }


//    private void getUpcommingDataFromServer(){
//        Retrofit retrofit = RetrofitClient.getRetrofit();
//        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);
//        Call<AvailbleModelClass> call = lgApi.getcodedata();
//        call.enqueue(new Callback<AvailbleModelClass>() {
//            @Override
//            public void onResponse(Call<AvailbleModelClass> call, Response<AvailbleModelClass> response) {
//                if(response.body()!=null&& response.body().getData()!=null) {
//        if(response.)
//
//                }else {
//                    Log.d("NULL", "null past");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AvailbleModelClass> call, Throwable t) {
//                if (!call.isCanceled()) {
//                    t.printStackTrace();
//                }
//            }
//        });
//    }

}