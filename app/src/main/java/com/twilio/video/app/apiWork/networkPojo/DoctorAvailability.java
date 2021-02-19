package com.twilio.video.app.apiWork.networkPojo;


import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorAvailability {

    @SerializedName("selected_days")
    @Expose
    private List<String> selectedDays;
    @SerializedName("make_available")
    @Expose
    private int makeAvailable;

    public List<String> getSelectedDays() {
        return selectedDays;
    }

    public void setSelectedDays(List<String> selectedDays) {
        this.selectedDays = selectedDays;
    }

    public int getMakeAvailable() {
        return makeAvailable;
    }

    public DoctorAvailability(List<String> selectedDays, int makeAvailable) {
        this.selectedDays = selectedDays;
        this.makeAvailable = makeAvailable;
    }

    public void setMakeAvailable(int makeAvailable) {
        this.makeAvailable = makeAvailable;
    }

}

