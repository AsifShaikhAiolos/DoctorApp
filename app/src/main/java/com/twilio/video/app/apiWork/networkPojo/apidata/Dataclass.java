package com.twilio.video.app.apiWork.networkPojo.apidata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dataclass {
    @SerializedName("status_code")
    @Expose
    String status_code;

    public Dataclass(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }
}
