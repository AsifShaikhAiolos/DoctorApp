package com.twilio.video.docapp.apiWork.networkPojo.apimodel;

import com.twilio.video.docapp.apiWork.networkPojo.apidata.VideoData;

public class VideoModel {
    String status;
    String message;
    VideoData data;

    public VideoModel(String status, String message, VideoData data) {
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

    public VideoData getData() {
        return data;
    }

    public void setData(VideoData data) {
        this.data = data;
    }
}
