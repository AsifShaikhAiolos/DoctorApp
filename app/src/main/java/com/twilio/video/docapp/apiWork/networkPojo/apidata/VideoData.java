package com.twilio.video.docapp.apiWork.networkPojo.apidata;

public class VideoData {
    String passcode;
    String user_name;
    String room_name;

    public VideoData(String passcode, String user_name, String room_name) {
        this.passcode = passcode;
        this.user_name = user_name;
        this.room_name = room_name;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }
}
