package com.twilio.video.docapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.twilio.video.docapp.HomeActivity;
import com.twilio.video.docapp.R;
import com.twilio.video.docapp.apiWork.NetworkInterface;
import com.twilio.video.docapp.apiWork.RetrofitClient;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.UpCommingDatat;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.VideoID;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.VideoModel;
import com.twilio.video.docapp.ui.login.CommunityLoginActivity;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Url;

public class AppoinmentsAdapterNormal extends RecyclerView.Adapter<AppoinmentsAdapterNormal.ViewHolder> {

    List<UpCommingDatat> data;
    Context context;
    AppCompatActivity activity;
    ViewGroup p;

    public AppoinmentsAdapterNormal(Context contatext,List<UpCommingDatat> mData, Activity activity) {
        data = mData;
        this.activity= (AppCompatActivity) activity;
        this.context = contatext;
        if(data == null){
            data = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        p = parent;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.upcomming_date, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        String appointmenttime = TimeConvertor(data.get(position).getTime_slot().getStart_time());
        String appointmentdate = DateConvertor(data.get(position).getTime_slot().getDate());
        holder.docName.setText(data.get(position).getDoctor_name());
        holder.docST.setText(appointmentdate);
        holder.docD.setText(appointmenttime);
//        Glide.with(context)
//                .load(data.get(position).getProfile_pic())
//                .centerCrop()
//                .into(holder.imageView);

        Glide.with(context)
                .load(data.get(position).getProfile_pic())
                .into(holder.imageView);

        Log.d("tag", data.get(position).getProfile_pic());
        holder.sp.setText(data.get(position).getDoc_speciality());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sm.onClick(data.get(position).get_id());
                    startAppointment(data.get(position).get_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView docName,docD, docST,sp;
        CardView card;
        CircleImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            docName = itemView.findViewById(R.id.idDoctorNameUpcomming);
            docST = itemView.findViewById(R.id.satrtMeeting);
            docD = itemView.findViewById(R.id.idUpcommingDate);
            sp = itemView.findViewById(R.id.idDrSpeciality);
            card = itemView.findViewById(R.id.crdDoctorProfileUpcomming);
            imageView = itemView.findViewById(R.id.IdupProfile);
        }
    }

    public String DateConvertor(String d){
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = inputFormat.parse(d);
            return outputFormat.format(date);
        }catch (Exception e){
            e.printStackTrace();
            return d;
        }
    }

    public String TimeConvertor(String d){
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
            Date date = inputFormat.parse(d);
            return outputFormat.format(date);
        }catch (Exception e){
            e.printStackTrace();
            return d;
        }
    }

    interface StartMeeting{
        public void onClick(String id);
    }

    private void startAppointment(String appointmentId) {
        HomeActivity nAct = new HomeActivity();

        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<VideoModel> call = lgApi.createVideoCall(new VideoID(appointmentId));
        call.enqueue(new Callback<VideoModel>() {
            @Override
            public void onResponse(Call<VideoModel> call, Response<VideoModel> response) {

                if (response.body() != null) {

                    if("success".equalsIgnoreCase(response.body().getStatus())){
                        Intent intent= new Intent(p.getContext(), CommunityLoginActivity.class);
                        intent.putExtra("roomName",response.body().getData().getRoom_name());
                        intent.putExtra("passCode",response.body().getData().getPasscode());
                        intent.putExtra("userName",response.body().getData().getUser_name());


                        p.getContext().startActivity(intent);
                    }
                    //sucess
//                       String roomName = displayName
//                       if (response.body().getData().getRoom_name() != null) {

//                          String roomName = response.body().getData().getRoom_name();
//
//                           RoomViewEvent viewEvent = RoomViewEvent.Connect(displayName ?: "", roomName)
//                           roomViewModel.processInput(viewEvent)
//                       }
//                   }else {
//                       //failed
//                   }
                } else
                    Toast.makeText(context,"something went wrong", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<VideoModel> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}

