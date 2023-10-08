package org.example.schedule;

import java.time.LocalTime;

public class Task {
    private String pickerId;
    private String orderId;
    private LocalTime pickingStartTime;

    public String getPickerId() {
        return pickerId;
    }

    public void setPickerId(String pickerId) {
        this.pickerId = pickerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalTime getPickingStartTime() {
        return pickingStartTime;
    }

    public void setPickingStartTime(LocalTime pickingStartTime) {
        this.pickingStartTime = pickingStartTime;
    }

    public String toString(){
        return pickerId + " " + orderId + " " + pickingStartTime.toString();
    }
}
