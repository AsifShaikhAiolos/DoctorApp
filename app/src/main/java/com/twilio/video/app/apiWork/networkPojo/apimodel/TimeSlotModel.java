package com.twilio.video.app.apiWork.networkPojo.apimodel;

import com.google.gson.annotations.SerializedName;
import com.twilio.video.app.apiWork.networkPojo.apidata.TimeSlotData;

import java.util.List;

public class TimeSlotModel {
    String status;
    String message;
    @SerializedName("data")
    List<TimeSlotData> timeSlotData;

    public TimeSlotModel(String status, String message, List<TimeSlotData> timeSlotData) {
        this.status = status;
        this.message = message;
        this.timeSlotData = timeSlotData;
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

    public List<TimeSlotData> getTimeSlotData() {
        return timeSlotData;
    }

    public void setTimeSlotData(List<TimeSlotData> timeSlotData) {
        this.timeSlotData = timeSlotData;
    }
}
