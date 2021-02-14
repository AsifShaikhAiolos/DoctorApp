package com.twilio.video.app.apiWork;

import com.twilio.video.app.apiWork.networkPojo.apidata.BookingData;
import com.twilio.video.app.apiWork.networkPojo.apidata.DoctorIdData;
import com.twilio.video.app.apiWork.networkPojo.apidata.DoctorProfileUpdateModel;
import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;
import com.twilio.video.app.apiWork.networkPojo.apidata.Name;
import com.twilio.video.app.apiWork.networkPojo.apidata.VideoData;
import com.twilio.video.app.apiWork.networkPojo.apidata.VideoID;
import com.twilio.video.app.apiWork.networkPojo.apimodel.BookingModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.ListDoctorModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.LoginModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.PastModelAPI;
import com.twilio.video.app.apiWork.networkPojo.apimodel.TimeSlotModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.UpcommingModel;
import com.twilio.video.app.apiWork.networkPojo.apimodel.VideoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkInterface {

    @FormUrlEncoded
    @POST("user/docLogin")
    Call<LoginModel> checkLogin(@Field("email")String email, @Field("password") String password);


    @GET("doctor/get-all")
    Call<ListDoctorModel> getDoctorList();


    @POST("appointment/book")
    Call<BookingModel> bookAppointment(@Body BookingData bookingData);

    @POST("doctor/get-available-time-slots")
    Call<TimeSlotModel> createDoctorTimeSlot(@Body DoctorIdData doctorIdData);

    @POST("appointment/start")
    Call<VideoModel> createVideoCall(@Body VideoID videoID);
    @GET("appointment/docPast")
    Call<PastModelAPI> getPastList();


    @GET("appointment/docUpcoming")
    Call<UpcommingModel> getUpcommingList();

//update doctor profile
//    @FormUrlEncoded
//    @POST("user/getDoctorProfile")
//    Call<DoctorProfileUpdateModel> getUpdateDoctorProfile(@Field("email")String email,
//                                                          @Field("phone_number")String phone_number
//                                                          @Field("address")String  address,
//                                                          @Field("city")String city,
//                                                          @Field("name")Name name
//    );

    @GET("user/getDoctorProfile")
    Call<DoctorProfileUpdateModel> getDoctorProfileData();

}
