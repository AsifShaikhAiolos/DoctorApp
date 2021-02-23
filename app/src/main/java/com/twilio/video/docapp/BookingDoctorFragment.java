package com.twilio.video.docapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.os.FileUtils;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.twilio.video.docapp.adapter.SlotAdapter;
import com.twilio.video.docapp.adapter.WeekAdapter;
import com.twilio.video.docapp.apiWork.NetworkInterface;
import com.twilio.video.docapp.apiWork.RetrofitClient;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.BookingData;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.DoctorIdData;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.ListDoctorData;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.TimeSlotData;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.VideoID;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.BookingModel;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.TimeSlotModel;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.VideoModel;
import com.twilio.video.docapp.ui.login.CommunityLoginActivity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BookingDoctorFragment extends AppCompatActivity implements EventListenere {
    Context context;
    TextView Slotstime, docName;
    TextView txtnewsDescription, time;
    private int CAMERA = 1111;
    private int GALLERY = 1121;
    private int FILE = 1131;

    public String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

    Button btnBooking, fq, addFml;
    String doctor_id;
    String start_time;
    String date;
    String email;
    String phone_number;
    String number_of_slots;
    RecyclerView recyclerView, slotRecyclerview;
    WeekAdapter weekAdapter;
    List<TimeSlotData> timeSlotData;
    ListDoctorData doctorData;
    SlotAdapter slotAdapter;
    FloatingActionButton fab;
    ImageView rp1,rp2,rp3,rp4;
    private static Uri _imagefileUri;
    int s = -1;
    List<Uri> uriPdf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        items = new CharSequence[]{"Take Photo", "Open Gallery", "Select Document"};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_booking_doctor);

        btnBooking = findViewById(R.id.btnBooking);
        docName = findViewById(R.id.docName);
        fq = findViewById(R.id.btnFillQu);
        addFml = findViewById(R.id.btnFamilyMember);
        time = findViewById(R.id.selectTime);
//        fab = findViewById(R.id.add_alarm_fab);
        rp1 = findViewById(R.id.reportImg1);
        rp2 = findViewById(R.id.reportImg2);
        rp3 = findViewById(R.id.reportImg3);
        rp4 = findViewById(R.id.reportImg4);


        rp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               choicePick();
               s = 1;
            }
        });

        rp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicePick();
                s = 2;
            }
        });

        rp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicePick();
                s = 3;
            }
        });

        rp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicePick();
                s = 4;
            }
        });


        fq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), FillQuestActivity.class);
                startActivity(i);
            }
        });

        addFml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MyFamilyActivity.class);
                startActivity(i);
            }
        });


        timeSlotData = new ArrayList<>();
        uriPdf = new ArrayList<>();
        recyclerView = findViewById(R.id.WeekRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        weekAdapter = new WeekAdapter(getApplicationContext(), timeSlotData, this);
        recyclerView.setAdapter(weekAdapter);

        Intent intent = getIntent();
        if (intent != null) {
            doctorData = intent.getParcelableExtra("doctorModel");
            docName.setText("Dr. "+doctorData.getName().getFirst_name());
        }


        context = this;
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postBookDataServer();
            }
        });
        getSlotFromServer();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY && resultCode == RESULT_OK){
            _imagefileUri = data.getData();
            uriPdf.add(_imagefileUri);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), _imagefileUri);
                switch(s){
                    case 1:
                        rp1.setImageBitmap(bitmap);
                        break;
                    case 2:
                        rp2.setImageBitmap(bitmap);
                        break;
                    case 3:
                        rp3.setImageBitmap(bitmap);
                        break;
                    case 4:
                        rp4.setImageBitmap(bitmap);
                        break;
                    default:
                        break;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else if(requestCode == FILE && resultCode == RESULT_OK){
            Uri fileUri = data.getData();
            uriPdf.add(fileUri);
            String filePath = fileUri.toString();
            File f = new File(filePath);
            String path = f.getAbsolutePath();
            long size = f.length();
//            Toast.makeText(BookingDoctorFragment.this, String.valueOf(size),Toast.LENGTH_SHORT).show();
            if (f.canExecute()) {
                Toast.makeText(BookingDoctorFragment.this, "file not supported", Toast.LENGTH_SHORT).show();
            } else {
                if (size > 5000000) {
                    Toast.makeText(BookingDoctorFragment.this, "Please upload document with less than 5MB size",Toast.LENGTH_SHORT).show();
                } else {
//                        mViewModel.setBase64image(new File(filePath));
                    switch(s){
                        case 1:
                            rp1.setImageResource(R.drawable.ic_files);
                            break;
                        case 2:
                            rp2.setImageResource(R.drawable.ic_files);
                            break;
                        case 3:
                            rp3.setImageResource(R.drawable.ic_files);
                            break;
                        case 4:
                            rp4.setImageResource(R.drawable.ic_files);
                            break;
                        default:
                            break;
                    }
                }
            }
        }else {
            uriPdf.add(data.getData());
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            switch(s){
                case 1:
                    rp1.setImageBitmap(bitmap);
                    break;
                case 2:
                    rp2.setImageBitmap(bitmap);
                    break;
                case 3:
                    rp3.setImageBitmap(bitmap);
                    break;
                case 4:
                    rp4.setImageBitmap(bitmap);
                    break;
                default:
                    break;
            }
        }
//        Toast.makeText(BookingDoctorFragment.this, uriPdf.toString(), Toast.LENGTH_SHORT).show();
    }

    private void getSlotFromServer() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);
        DoctorIdData doctorIdData = new DoctorIdData(doctorData.get_id());
        Call<TimeSlotModel> call = lgApi.createDoctorTimeSlot(doctorIdData);
        call.enqueue(new Callback<TimeSlotModel>() {
            @Override
            public void onResponse(Call<TimeSlotModel> call, Response<TimeSlotModel> response) {

                timeSlotData.clear();
                if (response.body() != null && response.body().getTimeSlotData() != null) {

                    for (TimeSlotData td : response.body().getTimeSlotData()) {
                        timeSlotData.add(td);
                    }
                }
                weekAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TimeSlotModel> call, Throwable t) {
                if (!call.isCanceled()) {
                    t.printStackTrace();
                }
            }
        });

    }


    private void postBookDataServer() {

        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<BookingModel> call = lgApi.bookAppointment(new BookingData(doctorData.get_id(), start_time, date));
        call.enqueue(new Callback<BookingModel>() {
            @Override
            public void onResponse(Call<BookingModel> call, Response<BookingModel> response) {
                if (response.body() != null) {
                    Intent intent = new Intent(BookingDoctorFragment.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
//                    Log.e("ERROR CHECKING", response.body().getMessage());
                } else
                    Toast.makeText(getApplicationContext(),"Please Book An Appoiment", Toast.LENGTH_LONG).show();
//                Log.e("ERROR CHECKING", response.body().getMessage());
            }

            @Override
            public void onFailure(Call<BookingModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

            }
        });

    }


    private void startAppointment(String appointmentId) {

        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<VideoModel> call = lgApi.createVideoCall(new  VideoID(appointmentId));
        call.enqueue(new Callback<VideoModel>() {
            @Override
            public void onResponse(Call<VideoModel> call, Response<VideoModel> response) {

                if (response.body() != null) {

                   if("success".equalsIgnoreCase(response.body().getStatus())){
                       Intent intent= new Intent(getApplicationContext(), CommunityLoginActivity.class);
                       intent.putExtra("roomName",response.body().getData().getRoom_name());
                       intent.putExtra("passCode",response.body().getData().getPasscode());
                       intent.putExtra("userName",response.body().getData().getUser_name());


                       startActivity(intent);
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

    @Override
    public void onParentClick(TimeSlotData timeSlotDataModel, int position) {
        date=timeSlotDataModel.getDate();
        List<String> list = timeSlotDataModel.getTime_slots();
        Log.e("Tag","enter onclick time");
        if (list != null) {
            time.setVisibility(View.VISIBLE);
            Log.e("","list size"+list.size());
            slotRecyclerview = findViewById(R.id.slotTimeRecyclerView);
            slotAdapter = new SlotAdapter(context, list,this);
            slotRecyclerview.setLayoutManager(new GridLayoutManager(context, 4));
            slotRecyclerview.setNestedScrollingEnabled(false);
            slotRecyclerview.setHasFixedSize(true);
            slotRecyclerview.setAdapter(slotAdapter);

//            Toast.makeText(context, "Position " + timeSlotData.get(position), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onChildClickClick(String selectedTime, int position) {

        start_time=selectedTime;
    }

    public void choiceImage(){
        Intent g = new Intent();
        g.setType("image/*");
        g.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(g, "Select image"), GALLERY);
    }


    public void choicePick(){
       new MaterialDialog.Builder(BookingDoctorFragment.this)
               .title("Select image type")
               .items(R.array.uploadImages)
               .itemsIds(R.array.itemIds)
               .itemsCallback(new MaterialDialog.ListCallback() {
                   @Override
                   public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                       switch (which){
                           case 0:
                               cameraIntent();
                               break;
                           case 1:
                               choiceImage();
//                               genRandom();
//                               Intent intent2 = new Intent(
//                                       android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                               _imagefileUri = Uri.fromFile(getFile());
//
//                               intent2.putExtra(MediaStore.EXTRA_OUTPUT, _imagefileUri);
//                               startActivityForResult(intent2, CAPTURE_PHOTO);
                               break;
                           case 2:
                                fileIntent();
                               break;
                       }
                   }
               })
               .show();
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    private void fileIntent() {
        String[] mimeTypes = {"application/pdf"};
        Intent intent = new Intent();
        //intent.setType("image/*");
        intent.setType(mimeTypes.length == 1 ? mimeTypes[0] : "*/*");
        if (mimeTypes.length > 0) {
            intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        }
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), FILE);
    }

}