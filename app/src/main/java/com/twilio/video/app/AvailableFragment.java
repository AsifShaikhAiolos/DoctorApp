package com.twilio.video.app;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.adapter.AppoinmentsAdapterNormal;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.PastDatat;
import com.twilio.video.app.apiWork.networkPojo.apidata.UpCommingDatat;
import com.twilio.video.app.apiWork.networkPojo.apimodel.PastModelAPI;
import com.twilio.video.app.apiWork.networkPojo.apimodel.UpcommingModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AvailableFragment extends Fragment {

    List<UpCommingDatat> listUpcommig;
    AppoinmentsAdapterNormal adp;
    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_available, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HomeActivity nAct = new HomeActivity();
        listUpcommig=new ArrayList<>();
        getUpcommingDataFromServer();
        rv = (RecyclerView) view.findViewById(R.id.recyclerViewAvailable);
        adp = new AppoinmentsAdapterNormal(nAct,listUpcommig, nAct);
        rv.setLayoutManager(new LinearLayoutManager(nAct));
        rv.setAdapter(adp);


    }

    private void getUpcommingDataFromServer(){
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);
        Call<UpcommingModel> call = lgApi.getUpcommingList();
        call.enqueue(new Callback<UpcommingModel>() {
            @Override
            public void onResponse(Call<UpcommingModel> call, Response<UpcommingModel> response) {
                listUpcommig.clear();
                if(response.body()!=null&& response.body().getData()!=null) {

                    for (UpCommingDatat d : response.body().getData()) {
                        listUpcommig.add(d);
                    }
                }else {
                    Log.d("NULL", "null past");
                }
                Log.d("TAG", "size="+listUpcommig.size());
                adp.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<UpcommingModel> call, Throwable t) {
                if (!call.isCanceled()) {
                    t.printStackTrace();
                }
            }
        });
    }

}