package com.twilio.video.docapp.apiWork.networkPojo.apimodel;

import java.util.List;

public class ProfileMoel {
    public String status;
    public String message;
    public List<ProfileDate> data;

    public ProfileMoel(String status, String message, List<ProfileDate> data) {
        this.status = status;
        this.message = message;
        this.data = data;
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

    public List<ProfileDate> getData() {
        return data;
    }

    public void setData(List<ProfileDate> data) {
        this.data = data;
    }
}
