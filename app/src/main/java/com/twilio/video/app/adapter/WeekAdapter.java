package com.twilio.video.app.adapter;

import android.content.Context;
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
    int pos = 0;

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
        if (data.get(position).getisRead() == true){
            holder.docName.setBackgroundResource(R.drawable.bordertextclick);
            holder.docName.setTextColor(R.color.white_with_alpha);
        }else{
            holder.docName.setBackgroundResource(R.drawable.bordertext);
            holder.docName.setTextColor(R.color.black);
        }
        holder.docName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Tag","pos="+position);
                if(eventListenere!=null){
                    eventListenere.onParentClick(data.get(position),position );
                }
                if (position == pos){
                    pos = 0;
                }else{
                    pos = position;
                }
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


    public void unselect(int p){
        if(pos == p){
            if (data.get(p).getisRead()){
                data.get(p).setisRead(false);
                notifyItemChanged(position)
            }

        }
    }



}
