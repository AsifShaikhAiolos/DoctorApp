package com.twilio.video.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.R;

import java.util.List;

public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.ViewHolder> {

    List<String> slottimes;
    Context context;

  public  SlotAdapter( Context context,List<String> slottimes){
        this.context=context;
        this.slottimes=slottimes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lyt_slots, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        context = holder.itemView.getContext();
        holder.slotTimes.setText(slottimes.get(position));
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


