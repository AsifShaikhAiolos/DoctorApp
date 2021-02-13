package com.twilio.video.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.R;

public class SpecialityAdapter extends RecyclerView.Adapter<SpecialityAdapter.ViewHolder>{

    String name[] = {"Cardiology","Neurology","Ophthalmology","Pulmonology","surgical gastroenterology","Rheumatology", "Dentist"};
    int icon[] = {
            R.drawable.ic_heart_beat,
            R.drawable.ic_brain__1_,
            R.drawable.ic_ophthalmology,
            R.drawable.ic_lungs,
            R.drawable.ic_surgery_room,
            R.drawable.ic_joint,
            R.drawable.ic_dentist
    };


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.specility_lyt, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String SepName = name[position];
        int SepIcon = icon[position];
        holder.tx.setText(SepName);
        holder.iv.setImageResource(SepIcon);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            AppCompatImageView iv;
            AppCompatTextView tx;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.specialityIcon);
            tx = itemView.findViewById(R.id.specialityText);
        }
    }
}
