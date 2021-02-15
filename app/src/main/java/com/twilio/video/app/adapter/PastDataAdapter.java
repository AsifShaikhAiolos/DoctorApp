package com.twilio.video.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.networkPojo.apidata.PastDatat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PastDataAdapter extends RecyclerView.Adapter<PastDataAdapter.ViewHolder> {
    List<PastDatat> data;
    public PastDataAdapter(List<PastDatat> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.past_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        String sd = TimeConvertor(data.get(position).getTime_slot().getStart_time());
        String ed = TimeConvertor(data.get(position).getTime_slot().getEnd_time());
        String d = DateConvertor(data.get(position).getTime_slot().getDate());
        holder.docST.setText(sd);
        holder.docET.setText(ed);
        holder.docD.setText(d);
        holder.docNAme.setText(data.get(position).getDoctor_name());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView docST,docET, docD,docNAme;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            docST = itemView.findViewById(R.id.idPastTime);
            docET = itemView.findViewById(R.id.idPastDate);
            docD = itemView.findViewById(R.id.idDoctorNamepast);
            docNAme = itemView.findViewById(R.id.txtDoctorNamepast);
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
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
            Date date = inputFormat.parse(d);
            return outputFormat.format(date);
        }catch (Exception e){
            e.printStackTrace();
            return d;
        }
    }

}