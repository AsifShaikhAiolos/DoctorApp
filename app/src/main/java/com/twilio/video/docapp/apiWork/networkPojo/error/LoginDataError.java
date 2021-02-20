package com.twilio.video.docapp.apiWork.networkPojo.error;

public class LoginDataError {
    public String value;
    public String msg;
    public String param;
    public String location;

    public LoginDataError(String value, String msg, String param, String location) {
        this.value = value;
        this.msg = msg;
        this.param = param;
        this.location = location;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
