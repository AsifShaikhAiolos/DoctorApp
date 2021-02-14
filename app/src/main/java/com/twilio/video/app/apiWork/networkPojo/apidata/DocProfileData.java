package com.twilio.video.app.apiWork.networkPojo.apidata;

public class DocProfileData {
    String _id;
    String address;
    String city;
    String email;
    String phone_number;
    String pin_code;
    String prefix;
    String state;
    String user_id;
    int gender;
    int number_of_slots;
    int __v;
    int duration;
//    int updatedAt;
    Name name;

    public String get_id() {
        return _id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPin_code() {
        return pin_code;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getState() {
        return state;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getGender() {
        return gender;
    }

    public int getNumber_of_slots() {
        return number_of_slots;
    }

    public int get__v() {
        return __v;
    }

    public int getDuration() {
        return duration;
    }

    public Name getName() {
        return name;
    }

    public DocProfileData(String _id, String address, String city, String email, String phone_number, String pin_code, String prefix, String state, String user_id, int gender, int number_of_slots, int __v, int duration, Name name) {
        this._id = _id;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phone_number = phone_number;
        this.pin_code = pin_code;
        this.prefix = prefix;
        this.state = state;
        this.user_id = user_id;
        this.gender = gender;
        this.number_of_slots = number_of_slots;
        this.__v = __v;
        this.duration = duration;
//        this.updatedAt = updatedAt;
        this.name = name;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setNumber_of_slots(int number_of_slots) {
        this.number_of_slots = number_of_slots;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

//    public void setUpdatedAt(int updatedAt) {
//        this.updatedAt = updatedAt;
//    }

    public void setName(Name name) {
        this.name = name;
    }
}
