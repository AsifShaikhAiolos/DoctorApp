package com.twilio.video.docapp.apiWork.networkPojo.apidata;

public class PastDatat {
    String user_id;
    String doctor_id;
    String doctor_name;
    String status;
    String createdAt;
    String doc_speciality;
    String updatedAt;
    String room_name;
    PastTimeSlotDatat time_slot;

    public PastDatat(String user_id, String doctor_id, String doctor_name, String status, String createdAt, String doc_speciality, String updatedAt, String room_name, PastTimeSlotDatat time_slot) {
        this.user_id = user_id;
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.status = status;
        this.createdAt = createdAt;
        this.doc_speciality = doc_speciality;
        this.updatedAt = updatedAt;
        this.room_name = room_name;
        this.time_slot = time_slot;
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

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
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

    public String getDoc_speciality() {
        return doc_speciality;
    }

    public void setDoc_speciality(String doc_speciality) {
        this.doc_speciality = doc_speciality;
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

    public PastTimeSlotDatat getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(PastTimeSlotDatat time_slot) {
        this.time_slot = time_slot;
    }
}
