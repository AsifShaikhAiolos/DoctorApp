package com.twilio.video.app.apiWork.networkPojo.apimodel;

import com.twilio.video.app.apiWork.networkPojo.apidata.DashUpcoming;
import com.twilio.video.app.apiWork.networkPojo.apidata.DashboradData;

public class Dashborad {
    String status;
    String message;
    DashUpcoming data;

    public Dashborad(String status, String message, DashUpcoming data) {
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

    public DashUpcoming getData() {
        return data;
    }

    public void setData(DashUpcoming data) {
        this.data = data;
    }
}
