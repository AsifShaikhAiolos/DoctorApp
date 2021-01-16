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

import com.twilio.video.app.adapter.PastDataAdapter;
import com.twilio.video.app.apiWork.NetworkInterface;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.PastDatat;
import com.twilio.video.app.apiWork.networkPojo.apimodel.PastModelAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PastAppointFragment extends Fragment {

    List<PastDatat> listPastData;
    PastDataAdapter adp;
    RecyclerView rv;


    public PastAppointFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_past_appoint, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity nAct = new MainActivity();
        listPastData=new ArrayList<>();
        rv = (RecyclerView) view.findViewById(R.id.pastRecyclerViewAvailable);

        getPassAptmsDataFromServer();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(nAct));
        adp=new PastDataAdapter(listPastData);
        rv.setAdapter(adp);
    }

    private void getPassAptmsDataFromServer(){
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);
        Call<PastModelAPI> call = lgApi.getPastList();
        call.enqueue(new Callback<PastModelAPI>() {
            @Override
            public void onResponse(Call<PastModelAPI> call, Response<PastModelAPI> response) {
                listPastData.clear();
                if(response.body()!=null&& response.body().getData()!=null) {

                    for (PastDatat d : response.body().getData()) {
                        listPastData.add(d);
                    }
                }else {
                    Log.d("NULL", "null past");
                }
                Log.d("TAG", "size="+listPastData.size());
                adp.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PastModelAPI> call, Throwable t) {
                if (!call.isCanceled()) {
                    t.printStackTrace();
                }
            }
        });
    }
}