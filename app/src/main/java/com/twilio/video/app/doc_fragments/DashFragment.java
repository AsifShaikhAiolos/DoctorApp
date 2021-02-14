package com.twilio.video.app.doc_fragments;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.twilio.video.app.HomeActivity;
import com.twilio.video.app.LoginActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.SPManager;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apimodel.DashModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.LoginModel;
import com.twilio.video.app.doctor.CalenderFragment;
import com.twilio.video.app.fragments.DoctorListFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class DashFragment extends Fragment {

    CardView crdCalender;
    TextView nob, ear, up;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        crdCalender = view.findViewById(R.id.crdCalender);
        nob = view.findViewById(R.id.bookingtext);
        ear = view.findViewById(R.id.earntext);
        up = view.findViewById(R.id.precautionstext);

        crdCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                CalenderFragment calenderFragment = new CalenderFragment();
                activity.getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_container, calenderFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Dashboard");
    }

    private void checkingLoginDetails() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<DashModel> call = lgApi.checkDash("", "");
        call.enqueue(new Callback<DashModel>() {
            @Override
            public void onResponse(Call<DashModel> call, Response<DashModel> response) {
                if (response.body()!=null){
                    if (response.body().getStatus().equalsIgnoreCase("success")) {
//setTokentoprefernece
                        nob.setText(String.valueOf(response.body().getData().getNumber_of_bookings()));
                        ear.setText(response.body().getData().getTotal_earnings());
                        up.setText(String.valueOf(response.body().getData().getUpcoming_count()));

                        Log.e("errorchecking",response.body().toString());
                    } else {
                        Log.e("errorchecking",response.body().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<DashModel> call, Throwable t) {
                Log.e("errorchecking",t.toString());
            }
        });
    }

}