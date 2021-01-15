package com.twilio.video.app.apiWork.networkPojo.apidata;

import com.google.gson.annotations.SerializedName;

public class DoctorIdData {
    @SerializedName("doctor_id")
    String doctor_id;

    public DoctorIdData(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }
}
