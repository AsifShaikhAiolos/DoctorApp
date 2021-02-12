package com.twilio.video.app.docAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.R;
import com.twilio.video.app.adapter.PastDataAdapter;
import com.twilio.video.app.apiWork.networkPojo.apidata.PastDatat;

import java.util.List;

public class Doc_PastAdapter extends RecyclerView.Adapter<Doc_PastAdapter.PastViewHolder> {
    String[] data;

    public Doc_PastAdapter(String[] data) {

        this.data = data;
    }

    @NonNull
    @Override
    public Doc_PastAdapter.PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lyt_doc_past_appt, parent, false);
        return new Doc_PastAdapter.PastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Doc_PastAdapter.PastViewHolder holder, final int position) {
//        String sd = TimeConvertor(data.get(position).getTime_slot().getStart_time());
//        String ed = TimeConvertor(data.get(position).getTime_slot().getEnd_time());
//        String d = DateConvertor(data.get(position).getTime_slot().getDate());
//        holder.docST.setText(sd);
//        holder.docET.setText(ed);
//        holder.docD.setText(d);
    }

    @Override
    public int getItemCount() {

        return 3;
    }

    public class PastViewHolder extends RecyclerView.ViewHolder {
        TextView patient_name,docET, docD;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
//            docST = itemView.findViewById(R.id.idPastTime);
//            docET = itemView.findViewById(R.id.idPastDate);
            patient_name = itemView.findViewById(R.id.idPatientNamepast);
        }
    }
}
