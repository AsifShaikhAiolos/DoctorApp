package com.twilio.video.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.BookingDoctorFragment;
import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;

import java.util.ArrayList;
import java.util.List;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder> implements Filterable {
    List<ListDoctorData> DoctorData,data;
    Context context;
    AppCompatActivity activity;

    public DoctorListAdapter(Context context, List<ListDoctorData> DoctorData, Activity activity) {
        this.DoctorData=DoctorData;
        this.context=context;
        this.activity= (AppCompatActivity) activity;
        this.data = DoctorData;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.doctor_list, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DoctorViewHolder holder, final int position) {
        context = holder.itemView.getContext();
        holder.docName.setText(DoctorData.get(position).getName().getFirst_name());
//        holder.docPhone.setText(data.get(position).getPhone_number());
//        holder.docSlotTime.setText(data.get(position).getNumber_of_slots());

        holder.crdDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//
                Intent intent = new Intent(activity, BookingDoctorFragment.class);
                intent.putExtra("doctorModel", DoctorData.get(position));
               activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  DoctorData.size();
    }




    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()){
                    DoctorData = data;
                }else{
                    List<ListDoctorData> filteredList = new ArrayList<>();
                    for(ListDoctorData row : data){
                        if (row.getName().getFirst_name().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(row);
                        }
                    }
                    DoctorData = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values =  DoctorData;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                DoctorData = (ArrayList<ListDoctorData>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class DoctorViewHolder extends RecyclerView.ViewHolder {
        CardView crdDoctor;
        TextView docName,docPhone, docSlotTime;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            crdDoctor = itemView.findViewById(R.id.crdDoctorProfile);
            docName = itemView.findViewById(R.id.idDoctorName);
//            docPhone = itemView.findViewById(R.id.idPhoneNumber);
            docSlotTime = itemView.findViewById(R.id.idnumber_of_slots);
        }
    }

}

