package com.twilio.video.app.apiWork.networkPojo.apidata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DoctorProfileUpdateModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DoctorDataListForDoctor> data = null;

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

    public List<DoctorDataListForDoctor> getData() {
        return data;
    }

    public void setData(List<DoctorDataListForDoctor> data) {
        this.data = data;
    }
}
