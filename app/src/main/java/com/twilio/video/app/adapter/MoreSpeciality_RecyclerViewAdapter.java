package com.twilio.video.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.twilio.video.app.BookingDoctorFragment;
import com.twilio.video.app.R;
import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;

import java.util.List;

public class MoreSpeciality_RecyclerViewAdapter extends RecyclerView.Adapter<MoreSpeciality_RecyclerViewAdapter.MoreSpecialViewHolder>
//        implements Filterable
{

            String[] data;
//    List<ListDoctorData> DoctorData,data;
//    Context context;
//    AppCompatActivity activity;

    public MoreSpeciality_RecyclerViewAdapter(String[] data
//                    Context context, List<ListDoctorData> DoctorData, Activity activity

            ) {
//        this.DoctorData=DoctorData;
//        this.context=context;
//        this.activity= (AppCompatActivity) activity;
//        this.data = DoctorData;
        this.data=data;
    }

    @NonNull
    @Override
    public MoreSpecialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lyt_doctor_speciality_more, parent, false);
        return new MoreSpecialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MoreSpecialViewHolder holder, final int position) {
//        context = holder.itemView.getContext();
//        holder.docName.setText(DoctorData.get(position).getName().getFirst_name());
//        holder.docPhone.setText(data.get(position).getPhone_number());
//        holder.docSlotTime.setText(data.get(position).getNumber_of_slots());

        holder.crdDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
////
//                Intent intent = new Intent(activity, BookingDoctorFragment.class);
//                intent.putExtra("doctorModel", DoctorData.get(position));
//                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
//                DoctorData.size();
    }




//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                String charString = constraint.toString();
//                if (charString.isEmpty()){
//                    DoctorData = data;
//                }else{
//                    List<ListDoctorData> filteredList = new ArrayList<>();
//                    for(ListDoctorData row : data){
//                        if (row.getName().getFirst_name().toLowerCase().contains(charString.toLowerCase())){
//                            filteredList.add(row);
//                        }
//                    }
//                    DoctorData = filteredList;
//                }
//                FilterResults filterResults = new FilterResults();
//                filterResults.values =  DoctorData;
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                DoctorData = (ArrayList<ListDoctorData>)results.values;
//                notifyDataSetChanged();
//            }
//        };
//    }

    public class MoreSpecialViewHolder extends RecyclerView.ViewHolder {
        CardView crdDoctor;
        TextView docSpecialityName,spcialityTotal, docSlotTime;

        public MoreSpecialViewHolder(@NonNull View itemView) {
            super(itemView);
            crdDoctor = itemView.findViewById(R.id.crdDoctorSpeciality);
            docSpecialityName = itemView.findViewById(R.id.idDoctorSpecialityName);
            spcialityTotal = itemView.findViewById(R.id.idTotalSpecialitNumber);
        }
    }

}
