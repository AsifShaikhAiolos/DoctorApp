package com.twilio.video.docapp.apiWork.networkPojo.apidata;

import java.util.List;

public class DashUpcoming {
    List<DashboradData> upcoming_appointment;

    public DashUpcoming(List<DashboradData> upcoming_appointment) {
        this.upcoming_appointment = upcoming_appointment;
    }

    public List<DashboradData> getUpcoming_appointment() {
        return upcoming_appointment;
    }

    public void setUpcoming_appointment(List<DashboradData> upcoming_appointment) {
        this.upcoming_appointment = upcoming_appointment;
    }
}
