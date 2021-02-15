package com.twilio.video.docapp.apiWork.networkPojo.apidata;

public class BookingData {
    String doctor_id;
    String start_time;
    String date;

    public BookingData(String doctor_id, String start_time, String date) {
        this.doctor_id = doctor_id;
        this.start_time = start_time;
        this.date = date;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
