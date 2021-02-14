package com.twilio.video.app.Doctor_Api_work;
import com.twilio.video.app.apiWork.networkPojo.apimodel.ListDoctorModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Doctor_Interface_Api {     /*Asfu*/

    //for doctor login endpoint and pars
    @FormUrlEncoded
    @POST("user/login")
    Call<LoginModel> checkLogin(@Field("email")String email, @Field("password") String password);

    //for doctor total earning end point
    @GET("doctor/get-all")
    Call<ListDoctorModel> getDoctorList();


    //for doctor




}
