package com.twilio.video.app.fragments;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.twilio.video.app.HomeActivity;
import com.twilio.video.app.LlistOfDoctorActivity;
import com.twilio.video.app.R;
import com.twilio.video.app.adapter.DoctorListAdapter;
import com.twilio.video.app.adapter.SpecialityAdapter;
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

public class HomeFragment extends Fragment {
FloatingActionButton fabBook;
    SpecialityAdapter specilityAdapter;
    RecyclerView recyclerViewSpeciality;
    RecyclerView recyclerView;
    DoctorListAdapter doctorListAdapter;
    List<ListDoctorData> listDoctorData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewSpeciality = view.findViewById(R.id.specialityRecyclerView);

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

}