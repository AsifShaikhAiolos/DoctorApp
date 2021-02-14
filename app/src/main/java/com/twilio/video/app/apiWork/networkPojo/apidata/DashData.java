package com.twilio.video.app.apiWork.networkPojo.apidata;

public class DashData {
    int number_of_bookings;
    int upcoming_count;
    String total_earnings;
    String user_id;

    public DashData(int number_of_bookings, int upcoming_count, String total_earnings, String user_id) {
        this.number_of_bookings = number_of_bookings;
        this.upcoming_count = upcoming_count;
        this.total_earnings = total_earnings;
        this.user_id = user_id;
    }

    public int getNumber_of_bookings() {
        return number_of_bookings;
    }

    public void setNumber_of_bookings(int number_of_bookings) {
        this.number_of_bookings = number_of_bookings;
    }

    public int getUpcoming_count() {
        return upcoming_count;
    }

    public void setUpcoming_count(int upcoming_count) {
        this.upcoming_count = upcoming_count;
    }

    public String getTotal_earnings() {
        return total_earnings;
    }

    public void setTotal_earnings(String total_earnings) {
        this.total_earnings = total_earnings;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
