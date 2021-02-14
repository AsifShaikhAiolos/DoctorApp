package com.twilio.video.app.apiWork.networkPojo.apimodel;

import com.twilio.video.app.apiWork.networkPojo.apidata.DashData;

public class DashModel {
    String status;
    String message;
    DashData data;

    public DashModel(String status, String message, DashData data) {
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

    public DashData getData() {
        return data;
    }

    public void setData(DashData data) {
        this.data = data;
    }
}
