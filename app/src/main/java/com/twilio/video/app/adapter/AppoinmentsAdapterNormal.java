package com.twilio.video.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.networkPojo.apidata.PastDatat;
import com.twilio.video.app.apiWork.networkPojo.apidata.UpCommingDatat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppoinmentsAdapterNormal extends RecyclerView.Adapter<AppoinmentsAdapterNormal.ViewHolder> {



    List<UpCommingDatat> data;

    public AppoinmentsAdapterNormal(Context contatext,List<UpCommingDatat> mData) {
        data = mData;
        if(data == null){
            data = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.upcomming_date, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String sd = TimeConvertor(data.get(position).getTime_slot().getStart_time());
        String d = DateConvertor(data.get(position).getTime_slot().getDate());
        holder.docName.setText(data.get(position).getDoctor_id());
        holder.docST.setText(sd);
        holder.docD.setText(d);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView docName,docD, docST;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            docName = itemView.findViewById(R.id.idDoctorNameUpcomming);
            docST = itemView.findViewById(R.id.satrtMeeting);
            doD = itemView.findViewById(R.id.idUpcommingDate);
        }
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

    public String TimeConvertor(String d){
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm:ss");
            Date date = inputFormat.parse(d);
            return outputFormat.format(date);
        }catch (Exception e){
            e.printStackTrace();
            return d;
        }
    }

}

