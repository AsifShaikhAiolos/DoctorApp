package com.twilio.video.docapp;

import com.twilio.video.docapp.apiWork.networkPojo.apidata.TimeSlotData;

public interface EventListenere {
    void onParentClick(TimeSlotData timeSlotData,int position);
    void onChildClickClick(String selectedTime,int position);
}
