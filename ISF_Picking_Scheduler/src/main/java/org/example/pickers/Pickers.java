package org.example.pickers;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;

public class Pickers {

    private ArrayList<String> pickers;
    private LocalTime pickingStartTime;
    private LocalTime pickingEndTime;

    public ArrayList<String> getPickers() {
        return pickers;
    }

    public void setPickers(ArrayList<String> pickers) {
        this.pickers = pickers;
    }

    public LocalTime getPickingStartTime() {
        return pickingStartTime;
    }

    public void setPickingStartTime(LocalTime pickingStartTime) {
        this.pickingStartTime = pickingStartTime;
    }

    public LocalTime getPickingEndTime() {
        return pickingEndTime;
    }

    public void setPickingEndTime(LocalTime pickingEndTime) {
        this.pickingEndTime = pickingEndTime;
    }

    public String toString(){
        return pickers.toString() + "\n" + pickingStartTime.toString() + "\n" + pickingEndTime.toString() + "\n";
    }
}
