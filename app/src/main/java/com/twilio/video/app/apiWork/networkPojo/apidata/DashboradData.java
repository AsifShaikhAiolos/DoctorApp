package com.twilio.video.app.apiWork.networkPojo.apidata;

public class DashboradData {

     TimeSlots time_slot;

     String _id;

     String userId;

     String doctorId;

     String status;

     String doctor_name;

     String room_name;

     String createdAt;

     String updatedAt;

    public DashboradData(TimeSlots time_slot, String _id, String userId, String doctorId, String status, String doctor_name, String room_name, String createdAt, String updatedAt) {
        this.time_slot = time_slot;
        this._id = _id;
        this.userId = userId;
        this.doctorId = doctorId;
        this.status = status;
        this.doctor_name = doctor_name;
        this.room_name = room_name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TimeSlots getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(TimeSlots time_slot) {
        this.time_slot = time_slot;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
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
}
