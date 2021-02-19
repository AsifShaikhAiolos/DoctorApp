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
    String qualification;
    String experience;
    String speciality;
    int gender;
    int number_of_slots;
    int __v;
    int duration;
    String profile_pic;
//    int updatedAt;
    Name name;

    public DocProfileData(String _id, String address, String city, String email, String phone_number, String pin_code, String prefix, String state, String user_id, String qualification, String experience, String speciality,
                          int gender, int number_of_slots, int __v, int duration, String profile_pic, Name name) {
        this._id = _id;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phone_number = phone_number;
        this.pin_code = pin_code;
        this.prefix = prefix;
        this.state = state;
        this.user_id = user_id;
        this.qualification = qualification;
        this.experience = experience;
        this.speciality = speciality;
        this.gender = gender;
        this.number_of_slots = number_of_slots;
        this.__v = __v;
        this.duration = duration;
        this.profile_pic = profile_pic;
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getNumber_of_slots() {
        return number_of_slots;
    }

    public void setNumber_of_slots(int number_of_slots) {
        this.number_of_slots = number_of_slots;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
