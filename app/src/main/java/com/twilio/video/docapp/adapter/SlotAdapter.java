package com.twilio.video.docapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.docapp.EventListenere;
import com.twilio.video.docapp.R;

import java.util.List;

public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.ViewHolder> {

    List<String> slottimes;
    Context context;
    LayoutInflater layoutInflater;
    EventListenere eventListenere;
    int index = -1;

  public  SlotAdapter(Context context, List<String> slottimes, EventListenere eventListenere){
        this.context=context;
        layoutInflater= LayoutInflater.from(context);
        this.slottimes=slottimes;
        this.eventListenere=eventListenere;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.lyt_slots, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        context = holder.itemView.getContext();
        if (index == position){
            holder.slotTimes.setBackgroundResource(R.drawable.bordertextclick);
            holder.slotTimes.setTextColor(Color.WHITE);
        }else {
            holder.slotTimes.setBackgroundResource(R.drawable.bordertext);
            holder.slotTimes.setTextColor(Color.BLACK);
        }
        holder.slotTimes.setText(slottimes.get(position));
        holder.slotTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListenere.onChildClickClick(slottimes.get(position),position);
                index = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return slottimes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView slotTimes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            slotTimes = itemView.findViewById(R.id.slotsDates);
        }
    }

}


