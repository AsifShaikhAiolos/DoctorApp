package com.twilio.video.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.R;
import com.twilio.video.app.adapter.DoctorListAdapter;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;
import com.twilio.video.app.apiWork.networkPojo.apimodel.ListDoctorModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static tvi.webrtc.ContextUtils.getApplicationContext;


public class DoctorListFragment extends Fragment {

    RecyclerView recyclerView;
    DoctorListAdapter doctorListAdapter;
    List<ListDoctorData> listDoctorData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_doctorlist, container, false);
        listDoctorData = new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        doctorListAdapter = new DoctorListAdapter(getApplicationContext(), listDoctorData, getActivity());
        recyclerView.setAdapter(doctorListAdapter);
        getDoctorDataFromServer();
        return  view;
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


}