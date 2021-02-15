package com.twilio.video.docapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SPManager {
    private static SPManager myManager;
    private SharedPreferences s;
    private String IS_LOGIN = "isLogin";
    private String IS_LOGOUT = "isLogin";
    private String ACCESS_TOKEN = "at";
    Context _context;
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


    private  void savedRoomName(String key,String data){
        SharedPreferences.Editor editor = s.edit();
        editor.putString(key, data);
        editor.apply();
    }

    public String getRoomName() {
        return retrieveString(getRoomName());
    }


    private void saveString(String key, String data) {
        SharedPreferences.Editor editor = s.edit();
        editor.putString(key, data);
        editor.apply();
    }





    private String retrieveString(String key) {
        return s.getString(key, null);
    }


    public String getAccessToken() {
        return retrieveString(ACCESS_TOKEN);
    }

    public void setAccessToken(String token) {
        saveString(ACCESS_TOKEN, token);
    }

    public void makeLogout(){
        SharedPreferences.Editor editor  = _context.getSharedPreferences(_context.getPackageName(),Context.MODE_PRIVATE).edit();
        editor.putBoolean(IS_LOGOUT,false);
        editor.commit();
    }

    public boolean isLogin(){
        SharedPreferences editor  = _context.getSharedPreferences(_context.getPackageName(),Context.MODE_PRIVATE);
        return editor.getBoolean(IS_LOGIN,false);
    }

    public void signOut(){
        SharedPreferences.Editor editor = s.edit();
        editor.clear().commit();
    }

}
