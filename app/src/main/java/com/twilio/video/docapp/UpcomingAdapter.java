package com.twilio.video.docapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingAdapter  extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {

    String name[] = {"Ajay", "Omkar", "Asif", "Afzal", "Pintu"};
    String speciality[] = {"Eye", "Brain", "Dentist", "Heart", "Bones"};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.doctor_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.docName.setText(name[position]);
        holder.docS.setText(speciality[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView docName,docPhone, docSlotTime, docS;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            docName = itemView.findViewById(R.id.idDoctorName);
            docS = itemView.findViewById(R.id.idnumber_of_slots);
        }
    }

}

