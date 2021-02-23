package com.twilio.video.docapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.twilio.video.docapp.HomeActivity;
import com.twilio.video.docapp.LlistOfDoctorActivity;
import com.twilio.video.docapp.R;
import com.twilio.video.docapp.adapter.DoctorListAdapter;
import com.twilio.video.docapp.adapter.SpecialityAdapter;
import com.twilio.video.docapp.apiWork.NetworkInterface;
import com.twilio.video.docapp.apiWork.RetrofitClient;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.ListDoctorData;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.VideoID;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.Dashborad;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.ListDoctorModel;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.VideoModel;
import com.twilio.video.docapp.ui.login.CommunityLoginActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {
FloatingActionButton fabBook;
    SpecialityAdapter specilityAdapter;
    RecyclerView recyclerViewSpeciality;
    RecyclerView recyclerView;
    DoctorListAdapter doctorListAdapter;
    List<ListDoctorData> listDoctorData;
    TextView more,more2, doctorName, doctorSpecility, date, time, up,sp;
    CardView crd;
    String formattedDate,localTime,appointmenttime,appointmentdate,id;
    HomeActivity nAct = new HomeActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmencrdt
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewSpeciality = view.findViewById(R.id.specialityRecyclerView);
        more = view.findViewById(R.id.id_more);
        more2 = view.findViewById(R.id.id_more2);
        doctorName = view.findViewById(R.id.idDoctorNameUpcomming);
        doctorSpecility = view.findViewById(R.id.idDrSpeciality);
        date = view.findViewById(R.id.idUpcommingDate);
        time = view.findViewById(R.id.satrtMeeting);
        crd = view.findViewById(R.id.doctorCard);
        up = view.findViewById(R.id.txtDoctor);
        sp = view.findViewById(R.id.idDrSpeciality);



        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                DoctorListFragment doctorListFragment = new DoctorListFragment();
                activity.getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_container, doctorListFragment).addToBackStack(null).commit();

//                nAct.navigation.setSelectedItemId(R.id.action_search);


            }
        });

        more2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                MoreSpecialityFragment moreSpecialityFragment = new MoreSpecialityFragment();
                activity.getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_container, moreSpecialityFragment).addToBackStack(null).commit();

            }
        });

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
        Date currentLocalTime = cal.getTime();
        DateFormat time = new SimpleDateFormat("hh:mm a");
// you can get seconds by adding  "...:ss" to it
        time.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));

        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        formattedDate = df.format(c);

        localTime = time.format(currentLocalTime);

        crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAppointment(id);
//                if (formattedDate == appointmentdate && localTime == appointmenttime){
//                    startAppointment(id);
//                    Toast.makeText(getActivity(), "success",Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(getActivity(), "successai",Toast.LENGTH_SHORT).show();
//                }
            }
        });

        getActivity().setTitle("Home");

        recyclerViewSpeciality.setHasFixedSize(true);
        recyclerViewSpeciality.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        specilityAdapter = new SpecialityAdapter();
        recyclerViewSpeciality.setAdapter(specilityAdapter);

        recyclerView = view.findViewById(R.id.doctorRecyclerView);

        listDoctorData = new ArrayList<>();
        LlistOfDoctorActivity lis = new LlistOfDoctorActivity();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        doctorListAdapter = new DoctorListAdapter(view.getContext(), listDoctorData, lis);
        recyclerView.setAdapter(doctorListAdapter);
        getDoctorDataFromServer();
        getDash();



//        TabLayout tabLayOut = (TabLayout) view.findViewById(R.id.tabLayout);
//        TabAdapterOther tabAdapter = new TabAdapterOther(getFragmentManager());
//        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
//        viewPager.setAdapter(tabAdapter);
//        tabLayOut.setupWithViewPager(viewPager);
//
//        fabBook=view.findViewById(R.id.fabBookAppoinment);
//
//        fabBook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), LlistOfDoctorActivity.class);
//                startActivity(intent);
//            }
//        });
        return view;
    }

    private void getDoctorDataFromServer() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<ListDoctorModel> call = lgApi.getDoctorList();
        call.enqueue(new Callback<ListDoctorModel>() {
            @Override
            public void onResponse(Call<ListDoctorModel> call, Response<ListDoctorModel> response) {

                listDoctorData.clear();
                if (response.body() != null && response.body().getData() != null) {

                    for (ListDoctorData d : response.body().getData()) {
                        listDoctorData.add(d);
                    }
                }
                doctorListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ListDoctorModel> call, Throwable t) {
                if (!call.isCanceled()) {
                    t.printStackTrace();
                }
            }
        });

    }

    private void getDash() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<Dashborad> call = lgApi.checkDash("","");
        call.enqueue(new Callback<Dashborad>() {
            @Override
            public void onResponse(Call<Dashborad> call, Response<Dashborad> response) {
                if (response != null && response.body().getData().getUpcoming_appointment().size() > 0){
                    up.setVisibility(View.VISIBLE);
                    crd.setVisibility(View.VISIBLE);
                    id = response.body().getData().getUpcoming_appointment().get(0).get_id();
                    appointmenttime = getStandardTime(response.body().getData().getUpcoming_appointment().get(0).getTime_slot().getStart_time());
                    appointmentdate = DateConvertor(response.body().getData().getUpcoming_appointment().get(0).getTime_slot().getDate());
                    doctorName.setText(response.body().getData().getUpcoming_appointment().get(0).getDoctor_name());
                    sp.setText(response.body().getData().getUpcoming_appointment().get(0).getDoc_speciality());
                    date.setText(appointmentdate);
                    time.setText(appointmenttime);
                }
            }

            @Override
            public void onFailure(Call<Dashborad> call, Throwable t) {
                if (!call.isCanceled()) {
                    t.printStackTrace();
                }
            }
        });

    }


    public String DateConvertor(String d){
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = inputFormat.parse(d);
            return outputFormat.format(date);
        }catch (Exception e){
            e.printStackTrace();
            return d;
        }
    }

    private String getStandardTime(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        df.setTimeZone(TimeZone.getDefault());
        String formattedDate = df.format(date);
        return TimeConvertor(formattedDate) ;
    }

//    public String TimeConvertor(String d){
//        try {
//            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
////            outputFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
//            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
//            Date date = inputFormat.parse(d);
//            return outputFormat.format(date);
//        }catch (Exception e){
//            e.printStackTrace();
//            return d;
//        }
//    }

    public String TimeConvertor(String d){
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
            Date date = inputFormat.parse(d);
            return outputFormat.format(date);
        }catch (Exception e){
            e.printStackTrace();
            return d;
        }
    }


    private void startAppointment(String appointmentId) {
        HomeActivity nAct = new HomeActivity();

        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<VideoModel> call = lgApi.createVideoCall(new VideoID(appointmentId));
        call.enqueue(new Callback<VideoModel>() {
            @Override
            public void onResponse(Call<VideoModel> call, Response<VideoModel> response) {

                if (response.body() != null) {

                    if("success".equalsIgnoreCase(response.body().getStatus())){
                        Intent intent= new Intent(getActivity(), CommunityLoginActivity.class);
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
                    Toast.makeText(getActivity(),"something went wrong", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<VideoModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}