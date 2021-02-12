package com.twilio.video.app;
import com.twilio.video.app.apiWork.networkPojo.apidata.TimeSlotData;

public interface EventListenere {
    void onParentClick(TimeSlotData timeSlotData,int position);
    void onChildClickClick(String selectedTime,int position);
}
