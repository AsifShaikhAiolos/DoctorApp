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
import com.twilio.video.app.apiWork.networkPojo.apidata.VideoData;
import com.twilio.video.app.apiWork.networkPojo.apidata.VideoID;
import com.twilio.video.app.apiWork.networkPojo.apimodel.BookingModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.ListDoctorModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.TimeSlotModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.VideoModel;
import com.twilio.video.app.ui.login.CommunityLoginActivity;
import com.twilio.video.app.ui.room.RoomViewEvent;

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
            docName.setText("Dr. "+doctorData.getName().getFirst_name());
        }


        context = this;
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postBookDataServer();
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
                    Intent intent = new Intent(BookingDoctorFragment.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
//                    Log.e("ERROR CHECKING", response.body().getMessage());
                } else
                    Toast.makeText(getApplicationContext(),"Please Book An Appoiment", Toast.LENGTH_LONG).show();
//                Log.e("ERROR CHECKING", response.body().getMessage());
            }

            @Override
            public void onFailure(Call<BookingModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

            }
        });

    }


    private void startAppointment(String appointmentId) {

        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<VideoModel> call = lgApi.createVideoCall(new  VideoID(appointmentId));
        call.enqueue(new Callback<VideoModel>() {
            @Override
            public void onResponse(Call<VideoModel> call, Response<VideoModel> response) {

                if (response.body() != null) {

                   if("success".equalsIgnoreCase(response.body().getStatus())){
                       Intent intent= new Intent(getApplicationContext(), CommunityLoginActivity.class);
                       intent.putExtra("roomName",response.body().getData().getRoom_name());
                       intent.putExtra("passCode",response.body().getData().getPasscode());
                       intent.putExtra("userName",response.body().getData().getUser_name());


                       startActivity(intent);
                   }
                       //sucess
//                       String roomName = displayName
//                       if (response.body().getData().getRoom_name() != null) {

//                          String roomName = response.body().getData().getRoom_name();
//
//                           RoomViewEvent viewEvent = RoomViewEvent.Connect(displayName ?: "", roomName)
//                           roomViewModel.processInput(viewEvent)
//                       }
//                   }else {
//                       //failed
//                   }
                } else
                    Toast.makeText(context,"something went wrong", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<VideoModel> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onParentClick(TimeSlotData timeSlotDataModel, int position) {
        date=timeSlotDataModel.getDate();
        List<String> list = timeSlotDataModel.getTime_slots();
        Log.e("Tag","enter onclick time");
        if (list != null) {
            Log.e("","list size"+list.size());
            slotRecyclerview = findViewById(R.id.slotTimeRecyclerView);
            slotAdapter = new SlotAdapter(context, list,this);
            slotRecyclerview.setLayoutManager(new GridLayoutManager(context, 4));
            slotRecyclerview.setNestedScrollingEnabled(false);
            slotRecyclerview.setHasFixedSize(true);
            slotRecyclerview.setAdapter(slotAdapter);

//            Toast.makeText(context, "Position " + timeSlotData.get(position), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onChildClickClick(String selectedTime, int position) {

        start_time=selectedTime;
    }
}