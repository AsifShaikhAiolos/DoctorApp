package com.twilio.video.app.apiWork.networkPojo.apimodel;

import com.twilio.video.app.apiWork.networkPojo.apidata.PastDatat;

import java.util.List;


public class PastModelAPI {
    boolean status;
    String message;
    List<PastDatat> data;

    public PastModelAPI(boolean status, String message, List<PastDatat> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PastDatat> getData() {
        return data;
    }

    public void setData(List<PastDatat> data) {
        this.data = data;
    }
}
