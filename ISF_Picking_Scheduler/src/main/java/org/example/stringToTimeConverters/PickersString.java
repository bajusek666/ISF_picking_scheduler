package org.example.stringToTimeConverters;


import java.util.ArrayList;

public class PickersString {
    private ArrayList<String> pickers;
    private String pickingStartTime;
    private String pickingEndTime;

    public ArrayList<String> getPickers() {
        return pickers;
    }

    public void setPickers(ArrayList<String> pickers) {
        this.pickers = pickers;
    }

    public String getPickingStartTime() {
        return pickingStartTime;
    }

    public void setPickingStartTime(String pickingStartTime) {
        this.pickingStartTime = pickingStartTime;
    }

    public String getPickingEndTime() {
        return pickingEndTime;
    }

    public void setPickingEndTime(String pickingEndTime) {
        this.pickingEndTime = pickingEndTime;
    }

}
