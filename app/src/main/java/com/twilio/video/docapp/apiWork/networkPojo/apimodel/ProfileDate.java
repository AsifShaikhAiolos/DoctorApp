package com.twilio.video.docapp.apiWork.networkPojo.apimodel;

import com.twilio.video.docapp.apiWork.networkPojo.apidata.Name;

import java.util.Date;

public class ProfileDate {
    public Name name;
    public String _id;
    public String email;
    public String password;
    public String user_type;
    public Date createdAt;
    public Date updatedAt;
    public int __v;

    public ProfileDate(Name name, String _id, String email, String password, String user_type, Date createdAt, Date updatedAt, int __v) {
        this.name = name;
        this._id = _id;
        this.email = email;
        this.password = password;
        this.user_type = user_type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.__v = __v;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
