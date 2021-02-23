package com.twilio.video.docapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.twilio.video.docapp.util.Crypto;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.spec.SecretKeySpec;

public class SPManager {
    private static SPManager myManager;
    private SharedPreferences s;
    private String IS_LOGIN = "isLogin";
    private String IS_LOGOUT = "isLogout";
    private String ACCESS_TOKEN = "at";
    Context _context;
    Crypto crypto = new Crypto();
    String masterkeys;

    private SPManager(Context context) {

        s = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
//        try{
//            masterkeys = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
//            s = EncryptedSharedPreferences.create(
//                    "files",
//                    masterkeys,
//                    nAct.getAppication(),
//                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//            );
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
        return crypto.decrypt(retrieveString(ACCESS_TOKEN), "token");
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

//
//    public String encrypt(String data){
//        SecretKeySpec key = generatekey()
//    }

}
