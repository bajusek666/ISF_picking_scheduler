package org.example.order;

import org.example.order.Order;

import java.time.Duration;
import java.util.ArrayList;


public class OrdersList {


    private ArrayList<Order> ordersList;

    public OrdersList(){
        this.ordersList = new ArrayList<>();
    }

    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }

    public Order getOrderWithTheShortestPickingTime(){
        Duration minDuration = Duration.ofDays(1);
        Order orderWithMinimumDuration = new Order();
        for (Order order: ordersList) {
            if(order.getPickingTime().compareTo(minDuration) < 0){
                minDuration = order.getPickingTime();
                orderWithMinimumDuration = order;
            }
        }
        return orderWithMinimumDuration;
    }

    public Order getOrderWithTheBestValueToTimeRate(){
        Order orderWithBestRate = new Order();
        int maxRate = Integer.MIN_VALUE;
        for (Order order: ordersList) {
            if (order.valueToPickingTimeRate() > maxRate){
                maxRate = order.valueToPickingTimeRate();
                orderWithBestRate = order;
            }
        }

        return orderWithBestRate;
    }

    public void setOrdersList(ArrayList<Order> ordersList) {
        this.ordersList = ordersList;
    }

}
