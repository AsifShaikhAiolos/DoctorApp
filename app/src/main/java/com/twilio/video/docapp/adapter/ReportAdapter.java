package com.twilio.video.docapp.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.twilio.video.docapp.R;
import com.twilio.video.docapp.fragments.DoctorListFragment;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder>{


    ViewGroup p;
    List<Bitmap> bitmaps;

    public ReportAdapter(List<Bitmap> bitmaps){
        this.bitmaps = bitmaps;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        p = parent;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.image_report, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Bitmap b = bitmaps.get(position);
        holder.iv.setImageBitmap(b);

//        String SepName = name[position];
//        int SepIcon = icon[position];
//        holder.tx.setText(SepName);
//        holder.iv.setImageResource(SepIcon);

//        holder.crd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (SepName == "Genetic Counselling"){
//                    next("Genetic Counselor");
//                }else if (SepName == "Clinical Genetics"){
//                    next("Clinical Geneticist");
//                }else {
//                    next("Psychological Counselling");
//                }
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return bitmaps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.reportImg);
        }
    }


}
