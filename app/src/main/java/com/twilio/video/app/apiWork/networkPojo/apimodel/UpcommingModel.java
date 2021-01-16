package com.twilio.video.app.apiWork.networkPojo.apimodel;


import com.twilio.video.app.apiWork.networkPojo.apidata.UpCommingDatat;

import java.util.List;


public class UpcommingModel {
    boolean status;
    String message;
    List<UpCommingDatat> data;

    public UpcommingModel(boolean status, String message, List<UpCommingDatat> data) {
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

    public List<UpCommingDatat> getData() {
        return data;
    }

    public void setData(List<UpCommingDatat> data) {
        this.data = data;
    }
}
