package com.twilio.video.docapp.apiWork.networkPojo.apimodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpcomingModel {
    String status;
    String message;
    @SerializedName("data")
    private List<Object> data;

    public UpcomingModel(String status, String message, List<Object> data) {
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

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
