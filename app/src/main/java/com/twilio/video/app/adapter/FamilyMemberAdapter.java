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

public class FamilyMemberAdapter extends RecyclerView.Adapter<FamilyMemberAdapter.ViewHolder>{

    String myName[] = {"Family Member 1,Male,25","Family Member 1,FeMale,30"};
    String myPhone[] = {"+91 0000000000","+91 0000000000"};
    String myEmail[] = {"e.g@gmail.com","e.g@gmail.com"};
    String myRelative[] = {"Borther","Sister"};



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.myfamilymembers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(myName[position]);
        holder.phone.setText(myPhone[position]);
        holder.email.setText(myEmail[position]);
        holder.relative.setText(myRelative[position]);
    }

    @Override
    public int getItemCount() {
        return myName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone,email,relative;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.myName);
            phone = itemView.findViewById(R.id.myNumber);
            relative = itemView.findViewById(R.id.myRelative);
            email = itemView.findViewById(R.id.myEmail);
        }
    }
}
