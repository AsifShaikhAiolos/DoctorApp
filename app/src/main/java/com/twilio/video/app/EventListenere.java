package com.twilio.video.app;

import android.view.View;

import com.twilio.video.app.apiWork.networkPojo.apidata.TimeSlotData;
import com.twilio.video.app.apiWork.networkPojo.apimodel.TimeSlotModel;

public interface EventListenere {
    void onParentClick(TimeSlotData timeSlotData,int position);
    void onChildClickClick(String selectedTime,int position);
}
