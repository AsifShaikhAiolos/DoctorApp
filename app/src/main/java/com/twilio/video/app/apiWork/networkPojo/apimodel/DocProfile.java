package com.twilio.video.app.apiWork.networkPojo.apimodel;

import com.twilio.video.app.apiWork.networkPojo.apidata.DocProfileData;

import java.util.List;

public class DocProfile {
    List<DocProfileData> data;
    String message;
    String status;

    public DocProfile(List<DocProfileData> data, String message, String status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public List<DocProfileData> getData() {
        return data;
    }

    public void setData(List<DocProfileData> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
