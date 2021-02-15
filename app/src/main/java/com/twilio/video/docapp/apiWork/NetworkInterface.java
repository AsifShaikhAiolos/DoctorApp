package com.twilio.video.docapp.apiWork;

import com.twilio.video.docapp.apiWork.networkPojo.apidata.BookingData;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.DoctorIdData;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.SignModel;
import com.twilio.video.docapp.apiWork.networkPojo.apidata.VideoID;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.BookingModel;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.Dashborad;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.ListDoctorModel;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.LoginModel;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.PastModelAPI;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.ProfileMoel;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.TimeSlotModel;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.UpcommingModel;
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.VideoModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkInterface {

    @FormUrlEncoded
    @POST("user/login")
    Call<LoginModel> checkLogin(@Field("email")String email, @Field("password") String password);


    @GET("doctor/get-all")
    Call<ListDoctorModel> getDoctorList();


    @POST("appointment/book")
    Call<BookingModel> bookAppointment(@Body BookingData bookingData);

    @POST("doctor/get-available-time-slots")
    Call<TimeSlotModel> createDoctorTimeSlot(@Body DoctorIdData doctorIdData);

    @POST("appointment/start")
    Call<VideoModel> createVideoCall(@Body VideoID videoID);
    @GET("appointment/past")
    Call<PastModelAPI> getPastList();


    @GET("appointment/upcoming")
    Call<UpcommingModel> getUpcommingList();


    @FormUrlEncoded
    @POST("user/patientDashboard")
    Call<Dashborad> checkDash(@Field("email")String email, @Field("password") String password);


    @FormUrlEncoded
    @POST("user/signup")
    Call<SignModel> checkUser(@Field("first_name")String first_name,
                              @Field("last_name")String last_name,
                              @Field("email")String email,
                              @Field("password") String password,
                              @Field("user_type")String user_type);


    @FormUrlEncoded
    @POST("user/getPatientProfile")
    Call<ProfileMoel> checkProfile(@Field("email")String email, @Field("password") String password);


}
