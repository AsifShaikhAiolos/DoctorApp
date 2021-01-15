package com.twilio.video.app;

import android.content.Context;
import android.content.SharedPreferences;

public class SPManager {
    private static SPManager myManager;
    private SharedPreferences s;
    private String IS_LOGIN = "isLogin";
    private String ACCESS_TOKEN = "at";

    private SPManager(Context context) {
        s = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public static SPManager getInstance() {
        if (myManager == null) {
            synchronized (SPManager.class) {
                if (myManager == null) {
                    myManager = new SPManager(VideoApplication.Companion.getContext());
                }
            }
        }
        return myManager;
    }

    private void saveString(String key, String data) {
        SharedPreferences.Editor editor = s.edit();
        editor.putString(key, data);
        editor.apply();
    }

    private void saveInt(String key, int data) {
        SharedPreferences.Editor editor = s.edit();
        editor.putInt(key, data);
        editor.apply();
    }

    private void saveBoolean(String key, boolean data) {
        SharedPreferences.Editor editor = s.edit();
        editor.putBoolean(key, data);
        editor.apply();
    }

    private void delete(String key) {
        SharedPreferences.Editor editor = s.edit();
        //editor.putString(key, "null");
        editor.remove(key);
        //editor.clear();
        editor.apply();
    }

    private String retrieveString(String key) {
        return s.getString(key, null);
    }

    private int retrieveInt(String key) {
        return s.getInt(key, 0);
    }

    private boolean retrieveBool(String key) {
        return s.getBoolean(key, false);
    }

    private boolean retrieveBool(String key, boolean defaultValue) {
        return s.getBoolean(key, defaultValue);
    }

    public String getAccessToken() {
        return retrieveString(ACCESS_TOKEN);
    }

    public void setAccessToken(String token) {
        saveString(ACCESS_TOKEN, token);
    }

}
