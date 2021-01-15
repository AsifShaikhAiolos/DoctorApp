package com.twilio.video.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.twilio.video.app.EventListenere;
import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.networkPojo.apidata.TimeSlotData;

import java.util.List;

public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.WeekViewHolder>  {

    List<TimeSlotData> data;
    Context context;
    private EventListenere eventListenere;

    public WeekAdapter(Context context, List<TimeSlotData> data,EventListenere eventListenere) {
        this.context=context;
        this.data = data;
        this.eventListenere=eventListenere;
    }

    @NonNull
    @Override
    public WeekAdapter.WeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lyt_weeksdates, parent, false);
        return new WeekAdapter.WeekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekViewHolder holder, int position) {

        context = holder.itemView.getContext();
        holder.docName.setText(data.get(position).getDate());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class WeekViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        TextView docName;

        public WeekViewHolder(@NonNull View itemView) {
            super(itemView);
            docName = itemView.findViewById(R.id.weekDates);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            eventListenere.onClick(getAdapterPosition());
        }
    }


}
