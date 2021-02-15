package com.twilio.video.docapp.apiWork.networkPojo.apidata;

public class UpcommingTimeSlotDatat {

    String date;
    String start_time;

    public UpcommingTimeSlotDatat(String date, String start_time) {
        this.date = date;
        this.start_time = start_time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

}
