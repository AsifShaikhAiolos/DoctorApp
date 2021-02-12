package com.twilio.video.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
    LayoutInflater layoutInflater;
    int select = -1;

    public WeekAdapter(Context context, List<TimeSlotData> data,EventListenere eventListenere) {
         layoutInflater = LayoutInflater.from(context);
        this.context=context;
        this.data = data;
        this.eventListenere=eventListenere;
    }

    @NonNull
    @Override
    public WeekAdapter.WeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.lyt_weeksdates, parent, false);
        return new WeekAdapter.WeekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekViewHolder holder, int position) {

        context = holder.itemView.getContext();
        holder.docName.setText(data.get(position).getDate());
        int color = Integer.parseInt("bdbdbd", 16)+0xFFFFFF;

        if (select == position){
            holder.docName.setBackgroundResource(R.drawable.bordertextclick);
            holder.docName.setTextColor(Color.WHITE);
        }else {
            holder.docName.setBackgroundResource(R.drawable.bordertext);
            holder.docName.setTextColor(Color.BLACK);
        }

        holder.docName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Tag","pos="+position);
                if(eventListenere!=null){
                    eventListenere.onParentClick(data.get(position),position );
                }
                select = position;
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class WeekViewHolder extends RecyclerView.ViewHolder  {
        TextView docName;
        LinearLayout layoutDays;
        public WeekViewHolder(@NonNull View itemView) {
            super(itemView);
            docName = itemView.findViewById(R.id.weekDates);
            layoutDays=itemView.findViewById(R.id.layoutDays);
        }
    }
}
