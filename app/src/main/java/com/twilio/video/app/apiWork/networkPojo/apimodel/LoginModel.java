package com.twilio.video.app.apiWork.networkPojo.apimodel;

import com.twilio.video.app.apiWork.networkPojo.apidata.LoginData;

import java.util.List;

public class LoginModel {
    String status;
    String message;
    String data;


    public LoginModel(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
