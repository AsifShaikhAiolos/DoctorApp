package com.twilio.video.docapp.apiWork.networkPojo.error;

import java.util.List;

public class BaseModelError {
    public String status;
    public String message;
    public List<LoginDataError> data;

    public BaseModelError(){

    }

    public BaseModelError(String status, String message, List<LoginDataError> data) {
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

    public List<LoginDataError> getData() {
        return data;
    }

    public void setData(List<LoginDataError> data) {
        this.data = data;
    }

}
