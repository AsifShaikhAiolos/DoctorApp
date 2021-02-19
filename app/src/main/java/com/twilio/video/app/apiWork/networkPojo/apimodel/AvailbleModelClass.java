package com.twilio.video.app.apiWork.networkPojo.apimodel;

import com.twilio.video.app.apiWork.networkPojo.apidata.Dataclass;
import com.twilio.video.app.apiWork.networkPojo.apidata.ListDoctorData;

import java.util.List;

public class AvailbleModelClass {
    String status;
    String message;
    List<Dataclass> data;

    public AvailbleModelClass(String status, String message, List<Dataclass> data) {
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

    public List<Dataclass> getData() {
        return data;
    }

    public void setData(List<Dataclass> data) {
        this.data = data;
    }
}
