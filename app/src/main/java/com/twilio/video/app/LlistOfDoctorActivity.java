package com.twilio.video.app;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.twilio.video.app.adapter.DoctorListAdapter;
import com.twilio.video.app.adapter.SpecialityAdapter;
import com.twilio.video.app.apiWork.RetrofitClient;
import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;
import com.twilio.video.app.apiWork.networkPojo.apimodel.ListDoctorModel;

import com.twilio.video.app.apiWork.NetworkInterface;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LlistOfDoctorActivity extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener
{
    RecyclerView recyclerView;
    DoctorListAdapter doctorListAdapter;
    List<ListDoctorData> listDoctorData;
    public Context context = this;
    EditText et_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llist_of_doctor);
        recyclerView = findViewById(R.id.doctorRecyclerView);

        listDoctorData = new ArrayList<>();
        et_search = findViewById(R.id.et_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        doctorListAdapter = new DoctorListAdapter(getApplicationContext(), listDoctorData, this);
        recyclerView.setAdapter(doctorListAdapter);


        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                doctorListAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        getDoctorDataFromServer();



    }


    private void getDoctorDataFromServer() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        final NetworkInterface lgApi = retrofit.create(NetworkInterface.class);

        Call<ListDoctorModel> call = lgApi.getDoctorList();
        call.enqueue(new Callback<ListDoctorModel>() {
            @Override
            public void onResponse(Call<ListDoctorModel> call, Response<ListDoctorModel> response) {

                listDoctorData.clear();
                if (response.body() != null && response.body().getData() != null) {

                    for (ListDoctorData d : response.body().getData()) {
                        listDoctorData.add(d);
                    }
                }
                doctorListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ListDoctorModel> call, Throwable t) {
                if (!call.isCanceled()) {
                    t.printStackTrace();
                }
            }
        });

    }


//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        break;
//        case R.id.id_logOut:
//        Toast.makeText(MainActivity.this, "clicked on button", Toast.LENGTH_LONG).show();
//        break;
//
//        case R.id.id_aboutapp:
////                Intent intentabout = new Intent(MainActivity.this, AboutAppActivity.class);
////                startActivity(intentabout);
//        break;
////
//
//        case R.id.id_share:
//        try {
//            Intent shareIntent = new Intent(Intent.ACTION_SEND);
//            shareIntent.setType("text/plain");
//            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
//            String shareMessage = "\nSheetalAcademy App\n\n";
//            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
//            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
//            startActivity(Intent.createChooser(shareIntent, "choose one"));
//        } catch (Exception e) {
//        }
//        break;
//
//        case R.id.id_rate:
//        try {
//            Uri marketUri = Uri.parse("market://details?id=" + getPackageName());
//            Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
//            startActivity(marketIntent);
//        } catch (ActivityNotFoundException e) {
//            Uri marketUri = Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName());
//            Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
//            startActivity(marketIntent);
//        }
//        break;
//    }
//        return true;
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.search, menu);

    final MenuItem searchItem = menu.findItem(R.id.action_search);
    final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
    searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) LlistOfDoctorActivity.this);

    return true;
}
}