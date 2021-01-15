package com.twilio.video.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.adapter.SlotAdapter;
import com.twilio.video.app.adapter.WeekAdapter;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.BookingData;
import com.twilio.video.app.apiWork.networkPojo.apidata.DoctorIdData;
import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;
import com.twilio.video.app.apiWork.networkPojo.apidata.TimeSlotData;
import com.twilio.video.app.apiWork.networkPojo.apimodel.BookingModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.ListDoctorModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.TimeSlotModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BookingDoctorFragment extends AppCompatActivity implements EventListenere {
    Context context;
    TextView Slotstime, docName;
    TextView txtnewsDescription;

    Button btnBooking;
    String doctor_id;
    String start_time;
    String date;
    String email;
    String phone_number;
    String number_of_slots;
    RecyclerView recyclerView, slotRecyclerview;
    WeekAdapter weekAdapter;
    List<TimeSlotData> timeSlotData;
    ListDoctorData doctorData;
    SlotAdapter slotAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_booking_doctor);

        btnBooking = findViewById(R.id.btnBooking);
        docName = findViewById(R.id.docName);


        timeSlotData = new ArrayList<>();
        recyclerView = findViewById(R.id.WeekRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        weekAdapter = new WeekAdapter(getApplicationContext(), timeSlotData, this);
        recyclerView.setAdapter(weekAdapter);

        Intent intent = getIntent();
        if (intent != null) {
            doctorData = intent.getParcelableExtra("doctorModel");
            docName.setText(doctorData.getName().getFirst_name());
        }


        context = this;
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BookingDoctorFragment.this, HomeActivity.class);
                startActivity(intent);
//                postBookDataServer();
            }
        });
        getSlotFromServer();
    }


    private void getSlotFromServer() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);
        DoctorIdData doctorIdData = new DoctorIdData(doctorData.get_id());
        Call<TimeSlotModel> call = lgApi.createDoctorTimeSlot(doctorIdData);
        call.enqueue(new Callback<TimeSlotModel>() {
            @Override
            public void onResponse(Call<TimeSlotModel> call, Response<TimeSlotModel> response) {

                timeSlotData.clear();
                if (response.body() != null && response.body().getTimeSlotData() != null) {

                    for (TimeSlotData td : response.body().getTimeSlotData()) {
                        timeSlotData.add(td);
                    }
                }
                weekAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TimeSlotModel> call, Throwable t) {
                if (!call.isCanceled()) {
                    t.printStackTrace();
                }
            }
        });

    }


    private void postBookDataServer() {

        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<BookingModel> call = lgApi.bookAppointment(new BookingData(doctorData.get_id(), start_time, date));
        call.enqueue(new Callback<BookingModel>() {
            @Override
            public void onResponse(Call<BookingModel> call, Response<BookingModel> response) {
                if (response.body() != null) {
                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("ERROR CHECKING", response.body().getMessage());
                } else
                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_LONG).show();
                Log.e("ERROR CHECKING", response.body().getMessage());
            }

            @Override
            public void onFailure(Call<BookingModel> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onClick(int position) {

        List<String> list = timeSlotData.get(position).getTime_slots();
        if (list != null) {
            timeSlotData = new ArrayList<>();
            slotRecyclerview = findViewById(R.id.slotTimeRecyclerView);
            slotRecyclerview.setHasFixedSize(true);
            slotRecyclerview.setLayoutManager(new GridLayoutManager(this, 3));
            slotAdapter = new SlotAdapter(this, list);
            slotRecyclerview.setAdapter(slotAdapter);

//            Toast.makeText(context, "Position " + timeSlotData.get(position), Toast.LENGTH_SHORT).show();
        }
    }
}