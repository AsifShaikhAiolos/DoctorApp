package com.twilio.video.docapp.apiWork.networkPojo.apimodel;

import com.twilio.video.docapp.apiWork.networkPojo.apidata.BookingData;

public class BookingModel {
    boolean status;
    String message;
    BookingData data;

    public BookingModel(boolean status, String message, BookingData data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BookingData getData() {
        return data;
    }

    public void setData(BookingData data) {
        this.data = data;
    }
}
