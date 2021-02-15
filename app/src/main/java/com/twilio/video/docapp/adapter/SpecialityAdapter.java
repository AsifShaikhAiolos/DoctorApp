package com.twilio.video.docapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.twilio.video.docapp.R;
import com.twilio.video.docapp.fragments.DoctorListFragment;
import com.twilio.video.docapp.ui.login.CommunityLoginActivity;

public class SpecialityAdapter extends RecyclerView.Adapter<SpecialityAdapter.ViewHolder>{

    String name[] = {"Genetic Counselling","Clinical Genetics","Psychological Counselling"};
    int icon[] = {
            R.drawable.ic_genetics7,
            R.drawable.ic_gmo2,
            R.drawable.ic_genetics8,
    };

    ViewGroup p;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        p = parent;
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

        holder.crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SepName == "Genetic Counselling"){
                    next("Clinical Geneticist");
                }else if (SepName == "Clinical Genetics"){
                    next("Genetic Counselor");
                }else {
                    next("Emotional & Psychological Counselor");
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            AppCompatImageView iv;
            AppCompatTextView tx;
            MaterialCardView crd;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.specialityIcon);
            tx = itemView.findViewById(R.id.specialityText);
            crd = itemView.findViewById(R.id.markets);
        }
    }


    public void next(String name){
        AppCompatActivity activity = (AppCompatActivity) p.getContext();
        DoctorListFragment doctorListFragment = new DoctorListFragment(name);
        activity.getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container, doctorListFragment).addToBackStack(null).commit();
    }

}
