package com.twilio.video.app.apiWork.networkPojo.apidata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TimeSlotData {
    String date;
    @SerializedName("time_slots")
    List<String> time_slots;

    public TimeSlotData(String date, List<String> time_slots) {
        this.date = date;
        this.time_slots = time_slots;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getTime_slots() {
        return time_slots;
    }

    public void setTime_slots(List<String> time_slots) {
        this.time_slots = time_slots;
    }

}
