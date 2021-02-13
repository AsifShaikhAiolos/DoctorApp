package com.twilio.video.app.Doctor_Api_work;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twilio.video.app.SPManager;
import com.twilio.video.app.apiWork.RetrofitClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Doctor_RetrofitClient {
    //RetrofitClient
    private static final String url = "http://65.1.45.74:8181/";
    private static Retrofit retrofit;
    private static Gson gson;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {

            gson = new GsonBuilder().setLenient().create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(url).addConverterFactory(ScalarsConverterFactory.create())
                    .client(getOkkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return retrofit;
    }


    private static OkHttpClient getOkkHttpClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()

                .readTimeout(5, TimeUnit.MINUTES)
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .callTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(new Doctor_RetrofitClient.HeaderInterceptor());


        builder.addNetworkInterceptor(new StethoInterceptor());
        //    builder.interceptors().add(httpLoggingInterceptor());

        return builder.build();
    }



    public static class HeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain)
                throws IOException {
            Request request = chain.request();
            request = request.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("token",""+ SPManager.getInstance().getAccessToken())
                    .build();

           /* Log.d("Token",token);
            Log.d("SPManager",SPManager.getInstance().getAccessToken());*/
            Response response = chain.proceed(request);
            if (response.code() != 500 && response.code()!=401) {
                Response.Builder customBuilder = response.newBuilder();
                customBuilder.code(200);
                return customBuilder.build();
            } else if (response.code() == 500) {
                Response.Builder customBuilder = response.newBuilder();
                customBuilder.code(500);
                return customBuilder.build();
            }
            return response;
        }
    }

}