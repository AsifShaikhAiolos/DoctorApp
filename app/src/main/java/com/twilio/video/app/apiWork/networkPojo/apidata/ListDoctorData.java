package com.twilio.video.app.apiWork.networkPojo.apidata;

import android.os.Parcel;
import android.os.Parcelable;

public class ListDoctorData implements Parcelable {
    String email;
    String phone_number;
    String  number_of_slots;
    String city;
    String _id;
    Name name;

    public ListDoctorData(String email, String phone_number, String number_of_slots, String city, String _id, Name name) {
        this.email = email;
        this.phone_number = phone_number;
        this.number_of_slots = number_of_slots;
        this.city = city;
        this._id = _id;
        this.name = name;
    }

    protected ListDoctorData(Parcel in) {
        email = in.readString();
        phone_number = in.readString();
        number_of_slots = in.readString();
        city = in.readString();
        _id = in.readString();
        name = in.readParcelable(Name.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(phone_number);
        dest.writeString(number_of_slots);
        dest.writeString(city);
        dest.writeString(_id);
        dest.writeParcelable(name, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListDoctorData> CREATOR = new Creator<ListDoctorData>() {
        @Override
        public ListDoctorData createFromParcel(Parcel in) {
            return new ListDoctorData(in);
        }

        @Override
        public ListDoctorData[] newArray(int size) {
            return new ListDoctorData[size];
        }
    };

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

    public String getNumber_of_slots() {
        return number_of_slots;
    }

    public void setNumber_of_slots(String number_of_slots) {
        this.number_of_slots = number_of_slots;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
