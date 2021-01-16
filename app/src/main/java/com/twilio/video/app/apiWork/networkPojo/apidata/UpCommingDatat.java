package com.twilio.video.app.apiWork.networkPojo.apidata;

public class UpCommingDatat {


    String _id;
    String user_id;
    String doctor_id;
    String status;
    String createdAt;
    String updatedAt;
    String room_name;
    UpcommingTimeSlotDatat time_slot;

    public UpCommingDatat(String _id, String user_id, String doctor_id, String status, String createdAt, String updatedAt, String room_name, UpcommingTimeSlotDatat time_slot) {
        this._id = _id;
        this.user_id = user_id;
        this.doctor_id = doctor_id;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.room_name = room_name;
        this.time_slot = time_slot;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public UpcommingTimeSlotDatat getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(UpcommingTimeSlotDatat time_slot) {
        this.time_slot = time_slot;
    }
}
