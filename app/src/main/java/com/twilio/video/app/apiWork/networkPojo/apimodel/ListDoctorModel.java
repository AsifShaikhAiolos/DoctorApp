package com.twilio.video.app.apiWork.networkPojo.apimodel;

import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;

import java.util.List;


public class ListDoctorModel {
    String status;
    String message;
    List<ListDoctorData> data;

    public ListDoctorModel(String status, String message, List<ListDoctorData> data) {
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

    public List<ListDoctorData> getData() {
        return data;
    }

    public void setData(List<ListDoctorData> data) {
        this.data = data;
    }
}
